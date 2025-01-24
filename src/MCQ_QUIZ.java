

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
/**
 *
 * @author 91914
 */import java.sql.*;
   import javax.swing.*;
 import java.sql.ResultSet;
import java.text.ParseException;
 import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MCQ_QUIZ extends javax.swing.JFrame {
    
    Connection conn=null;
    Statement stmt;
    ResultSet rs;
    
    int registration;
    String cours;
    int questionNumber = 0; // Declare this variable as a class-level field.
    private javax.swing.Timer quizTimer;
    private int remainingTime = 3600;
    int correctAnswers ;
    int currentQuestionIndex = 0;
    int totalNumberOfQuestions=50   ;
    




    private List<String> selectedAnswers = new ArrayList<>();
    
    
    private List<String> correctAnswersList = new ArrayList<>();



    /**
     * Creates new form MCQ_Quiz
     * @param reg
     * @param cour
     */
    public MCQ_QUIZ(int reg,String cour) {
        getContentPane().setBackground(Color.decode("#93E2D5"));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        initComponents();
        
        
        
        registration=reg;
        cours=cour;  
    }

 private void startQuizTimer() {
    quizTimer = new javax.swing.Timer(1000, new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            remainingTime--;
            if (remainingTime <= 0) {
                quizTimer.stop();
                JOptionPane.showMessageDialog(null, "Time's up! Quiz has been locked.");
               
                    submitQuiz();
                 
            }
        }
    });
    quizTimer.start();
}
 
 
 
 
 
 
 private void updateTimerLabel() {
    int hours = remainingTime / 3600;
    int minutes = (remainingTime % 3600) / 60;
    int seconds = remainingTime % 60;
    String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
    Timer.setText(timeString);
}

 
   /* private void submitQuiz() {
     

    // Check if the user has answered all the questions.
    int answeredQuestions = selectedAnswers.size();
    System.out.println("Selected answers: " + answeredQuestions);
    
    if (answeredQuestions == totalNumberOfQuestions) 
    {
        // Calculate the score.
        int correctAnswers = calculateCorrectAnswers();
        quizTimer.stop();
        // Display the score using a JOptionPane.
        String message = "All Answers Submitted!\nYour Final Score is: " + correctAnswers;
        JOptionPane.showMessageDialog(null, message);
        
    } else {
        JOptionPane.showMessageDialog(null, "Please answer all questions before submitting.");
        System.out.println("Selected answers: " + answeredQuestions);
    }

}*/
 
 private void submitQuiz()  {
    if (!checkAnswers()) {
        JOptionPane.showMessageDialog(null, "Please answer all questions before submitting.");
        return;
    }

    int correctAnswers = calculateCorrectAnswers();
    int totalMarks = totalNumberOfQuestions * 2;

    // Calculate the percentage
    double percentage = (correctAnswers / (double) totalMarks) * 100;

    // Determine the grade based on the percentage
    String grade;
    if (percentage >= 90) {
        grade = "O";
    } else if (percentage >= 80) {
        grade = "A+";
    } else if (percentage >= 70) {
        grade = "A";
    } else if (percentage >= 60) {
        grade = "B";
    } else if (percentage >= 50) {
        grade = "C";
    } else if (percentage >= 40) {
        grade = "D";
    } else {
        grade = "F";
    }

    // Determine the result status (Pass or Fail)
    String resultStatus = (percentage >= 40) ? "Pass" : "Fail";

    String message = "All Answers Submitted!\nYour Final Score is: " + correctAnswers + " out of " + totalMarks +
            "\nGrade: " + grade + "\nResult Status: " + resultStatus;
    //JOptionPane.showMessageDialog(null, message);
    dispose();
    new Exam_Complete().setVisible(true);
    
    // Insert the data into the database.
    try
    {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // You can change the format as needed
        String currentDate = dateFormat.format(new Date());
        
        String insertQuery = "INSERT INTO student_exam_score (Registration_Number, Name_On_Certificate, Course_Name, Exam_Date, Score, Grade, Result_Status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertQuery);
        pstmt.setInt(1, registration);
        pstmt.setString(2, Name.getText().substring(5));
        pstmt.setString(3, cours);
        pstmt.setString(4, currentDate);
        pstmt.setInt(5, correctAnswers);
        pstmt.setString(6, grade);
        pstmt.setString(7, resultStatus);

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data inserted into student_exam_score table.");
			quizTimer.stop();
			JOptionPane.showMessageDialog(null,"Quiz has Been Successfully Completed");
			
			
        } else {
            System.out.println("Data insertion failed.");
        }
    
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

 


int generateQuestionNumber1() {
    // Decrease the questionNumber when going back.
    if (currentQuestionIndex >= 0) {
        questionNumber = currentQuestionIndex + 1;
    }
    return questionNumber;
}


private void updateSelectedAnswer(String selectedAnswer) {
    if (selectedAnswers.size() > currentQuestionIndex) {
        selectedAnswers.set(currentQuestionIndex, selectedAnswer);

        // Check if the selected answer is correct and update the score.
        if (selectedAnswer.equals(correctAnswersList.get(currentQuestionIndex))) {
            correctAnswers++;
        }
    } else {
        selectedAnswers.add(selectedAnswer);
    }
}



    
public void loadQuestion() {
    try {
        if (rs.absolute(currentQuestionIndex + 1)) {
            Label1.setText(rs.getString("questions"));
            r1.setText(rs.getString("option_1"));
            r2.setText(rs.getString("option_2"));
            r3.setText(rs.getString("option_3"));
            r4.setText(rs.getString("option_4"));
            Qnum.setText("Q" + generateQuestionNumber1());

            // Check if there's a previously selected answer for this question.
            if (selectedAnswers.size() > currentQuestionIndex) {
            String selectedAnswer = selectedAnswers.get(currentQuestionIndex);
             if (selectedAnswer.equals(r1.getText())) {
             r1.setSelected(true);
            } else if (selectedAnswer.equals(r2.getText())) {
            r2.setSelected(true);
            } else if (selectedAnswer.equals(r3.getText())) {
            r3.setSelected(true);
            } else if (selectedAnswer.equals(r4.getText())) {
            r4.setSelected(true);
    }

            }
        } else {
           
           
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private String getSelectedAnswer() {
    if (r1.isSelected()) {
        return r1.getText();
    } else if (r2.isSelected()) {
        return r2.getText();
    } else if (r3.isSelected()) {
        return r3.getText();
    } else if (r4.isSelected()) {
        return r4.getText();
    }
    return null;
}





    private boolean checkAnswers()
    {
         return selectedAnswers.size() == totalNumberOfQuestions;
    }
    
    
    private int calculateCorrectAnswers() {
    int correctAnswers = 0;

    for (int i = 0; i < totalNumberOfQuestions; i++) {
        String selectedAnswer = selectedAnswers.get(i);
        String correctAnswer = correctAnswersList.get(i); // You should have a list of correct answers.
        if (selectedAnswer != null && selectedAnswer.equals(correctAnswer)) {
            correctAnswers+=2;
        }
    }

    return correctAnswers;
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jFrame1 = new javax.swing.JFrame();
        Label1 = new javax.swing.JLabel();
        r1 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        r3 = new javax.swing.JRadioButton();
        r4 = new javax.swing.JRadioButton();
        Qnum = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Name = new javax.swing.JLabel();
        regNum = new javax.swing.JLabel();
        DOB = new javax.swing.JLabel();
        Course = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Timer1 = new javax.swing.JLabel();
        Timer = new javax.swing.JLabel();
        cDate = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 0));
        setBounds(new java.awt.Rectangle(100, 100, 100, 100));
        setForeground(new java.awt.Color(51, 0, 51));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Label1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Label1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Label1MouseMoved(evt);
            }
        });

        r1.setBackground(new java.awt.Color(51, 0, 51));
        buttonGroup1.add(r1);
        r1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        r1.setForeground(new java.awt.Color(255, 255, 255));
        r1.setAutoscrolls(true);
        r1.setBorderPainted(true);
        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });

        r2.setBackground(new java.awt.Color(51, 0, 51));
        buttonGroup1.add(r2);
        r2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        r2.setForeground(new java.awt.Color(255, 0, 51));
        r2.setAutoscrolls(true);
        r2.setBorderPainted(true);

        r3.setBackground(new java.awt.Color(51, 0, 51));
        buttonGroup1.add(r3);
        r3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        r3.setForeground(new java.awt.Color(255, 0, 0));
        r3.setAutoscrolls(true);
        r3.setBorderPainted(true);

        r4.setBackground(new java.awt.Color(51, 0, 51));
        buttonGroup1.add(r4);
        r4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        r4.setForeground(new java.awt.Color(255, 0, 0));
        r4.setBorderPainted(true);
        r4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4ActionPerformed(evt);
            }
        });

        Qnum.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        Name.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        regNum.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        DOB.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        Course.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 4, true));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("COUNT DOWN");

        Timer1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Timer1.setText("Timer Remaining");

        Timer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Timer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TimerMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(Timer1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Timer, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(135, 135, 135))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Timer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Timer1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cDate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(regNum, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(216, 216, 216))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Course, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cDate, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(regNum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(Course, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cDate, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jButton2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 0));
        jButton2.setText("Previous");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 0));
        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 0));
        jButton3.setText("Submit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jButton2)
                .addGap(213, 213, 213)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(692, 692, 692)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Qnum, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(r1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(r2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(r3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(r4))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(Qnum, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(r1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(r2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(r3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(r4)
                .addGap(105, 105, 105)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284)
                .addComponent(jLabel1)
                .addGap(410, 410, 410))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      try{
            
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/oes2","root","");
       
           
       stmt = conn.createStatement();
       String Query="SELECT * From add_addmission WHERE Registration_Number="+registration+"";
       rs = stmt.executeQuery(Query);
       while(rs.next())
       {
           
           int regis=rs.getInt("Registration_Number");
           String Na=rs.getString("Name_On_Certificate");
           String course=rs.getString("Course_Name");
           String Date_Birth=rs.getString("Date_Of_Birth");
           regNum.setText("Registration Number: "+regis);
           Name.setText("Name:"+Na);
           Course.setText("Course name: "+course);
           DOB.setText("Date Of Birth: "+Date_Birth);
         
       }
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    String query = "SELECT * FROM add_question WHERE Course_Name='" + cours + "'";
    rs = stmt.executeQuery(query);
    
    while (rs.next()) {
            correctAnswersList.add(rs.getString("correct_ans"));
        }

        Qnum.setText("Q"+generateQuestionNumber1());
        
        
        
        loadQuestion();
         startQuizTimer();
         updateTimerLabel();
         
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // You can change the format as needed
        String currentDate = dateFormat.format(new Date());
        cDate.setText("Exam Date: " + currentDate);
         
         buttonGroup1.clearSelection();
        System.out.println("Hello");
         JOptionPane.showMessageDialog(null," Connected");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Not Connected");
        }
      
      
        
        // TODO add your handling code here:  // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
/*try {
        if (quizTimer.isRunning()) {
            // Store the selected answer when a radio button is clicked.
            String selectedAnswer = getSelectedAnswer();
            if (selectedAnswer != null) {
                updateSelectedAnswer(selectedAnswer);
            }

            currentQuestionIndex++;
            loadQuestion();
             buttonGroup1.clearSelection();

        } else {
            // Quiz timer has expired, show a message and submit the quiz.
           JOptionPane.showMessageDialog(null, "Time's up! Quiz has been locked.");

        }

        int num = generateQuestionNumber1();
        Qnum.setText("Q" + num);
    } catch (Exception e) {
        // Handle any exceptions here...
    }*/

 try {
        if (quizTimer.isRunning()) {
            // Store the selected answer when a radio button is clicked.
            String selectedAnswer = getSelectedAnswer();
            if (selectedAnswer != null) {
                updateSelectedAnswer(selectedAnswer);
            }

            if (generateQuestionNumber1() < 50) { // Check if the question number is less than 50
                currentQuestionIndex++;
                loadQuestion();
                buttonGroup1.clearSelection();
            } else {
                JOptionPane.showMessageDialog(null, "You've reached the last question.");
            }
        } else {
            // Quiz timer has expired, show a message and submit the quiz.
            JOptionPane.showMessageDialog(null, "Time's up! Quiz has been locked.");
        }

        int num = generateQuestionNumber1();
        Qnum.setText("Q" + num);
    } catch (Exception e) {
        // Handle any exceptions here...
    }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void Label1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label1MouseMoved
    updateTimerLabel();    // TODO add your handling code here:
    }//GEN-LAST:event_Label1MouseMoved

    private void TimerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimerMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TimerMouseReleased

    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 try {
        if (quizTimer.isRunning()) {
            currentQuestionIndex--;
            if (currentQuestionIndex < 0) {
                currentQuestionIndex = 0;
            }
            loadQuestion();
        }
    } catch (Exception e) {
        // Handle any exceptions here...
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  
   
            // Stop the quiz timer.
            submitQuiz();
            
   
   
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void r4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MCQ_QUIZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MCQ_QUIZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MCQ_QUIZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MCQ_QUIZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MCQ_QUIZ(0,"").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Course;
    private javax.swing.JLabel DOB;
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Qnum;
    private javax.swing.JLabel Timer;
    private javax.swing.JLabel Timer1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel cDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JRadioButton r3;
    private javax.swing.JRadioButton r4;
    private javax.swing.JLabel regNum;
    // End of variables declaration//GEN-END:variables
}
