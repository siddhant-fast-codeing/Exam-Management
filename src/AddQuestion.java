

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;
import java.sql.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 91914
 */
public class AddQuestion extends javax.swing.JFrame {
    Connection connection=null;
    Statement stmt;
    ResultSet rs;
    String selectedCourse;
     
    
      int generateQuestionNumber(String selectedCourse) {
        int questionNumber = 0;
        try {
            stmt = (Statement) connection.createStatement();
            String query = "SELECT COUNT(*) FROM add_question WHERE Course_Name = '" + selectedCourse + "'";
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                questionNumber = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately, such as showing an error message.
        }
        return questionNumber + 1;
    }

    
     int generateQuestionNumber1() {
        int questionNumber = 0;
        try {
            stmt = (Statement) connection.createStatement();
            String query = "SELECT MAX(Question_Number) FROM add_question";
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                questionNumber = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately, such as showing an error message.
        }
        return questionNumber + 1;
    }


    
    

    /**
     * Creates new form AddQuestion
     */
    public AddQuestion() throws SQLException{
        setUndecorated(true);
        initComponents();
      
    }
    
    
     private boolean validateFields() {
        if (Cour.getSelectedItem().toString().equals("Select Cour")) {
            JOptionPane.showMessageDialog(this, "Please select a course.");
            return false;
        }

        if (Question.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a question.");
            return false;
        }

        if (option1.getText().isEmpty() || option2.getText().isEmpty() || option3.getText().isEmpty() || option4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter all options.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (correct_answer.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the correct answer.");
            return false;
        }

        return true;
    }



// You can also add similar validation to other fields if needed

 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Qnumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Question = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        option1 = new javax.swing.JTextField();
        option2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        option3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        option4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        correct_answer = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        b1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        Cour = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        TQ = new javax.swing.JTextField();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Add Question");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Question No");

        Qnumber.setEditable(false);
        Qnumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Qnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QnumberActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Question");

        Question.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Question.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                QuestionKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Option 1");

        option1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        option1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                option1KeyPressed(evt);
            }
        });

        option2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        option2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2ActionPerformed(evt);
            }
        });
        option2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                option2KeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Option 2");

        option3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        option3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                option3KeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Option 3");

        option4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        option4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                option4KeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Option 4");

        correct_answer.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        correct_answer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                correct_answerKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("correct_answer");

        b1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        b1.setText("Submit");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        b1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                b1KeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Select Course Name");

        Cour.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Cour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Cour", "C", "Java", "php" }));
        Cour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Total Questions");

        TQ.setEditable(false);
        TQ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        b2.setText("Exit");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        b2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                b2KeyPressed(evt);
            }
        });

        b3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        b3.setText("Back");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        b3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                b3KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Cour, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Qnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Question, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(option1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(option2, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(option3, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(option4, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(correct_answer, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TQ, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Cour, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Qnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TQ, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Question, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(option1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(option2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(option3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(option4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(correct_answer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b1)
                    .addComponent(b2)
                    .addComponent(b3))
                .addGap(174, 174, 174))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
if (!validateFields()) 
{
        return;
}
        
        try
            {
                String cour=Cour.getSelectedItem().toString();
                String Question_Num=TQ.getText();
                String Questions=Question.getText();
                String OPTION1 = option1.getText();
                String OPTION2 = option2.getText();
                String OPTION3 = option3.getText();
                String OPTION4 = option4.getText();
                String cns=correct_answer.getText();
                
                stmt = (Statement) connection.createStatement();
                String query="INSERT INTO add_question VALUES("+Question_Num+",'"+cour+"','"+Questions+"','"+OPTION1+"','"+OPTION2+"','"+OPTION3+"','"+OPTION4+"','"+cns+"')";
                stmt.execute(query);
                JOptionPane.showMessageDialog(this,"Question Added Succesfully");
                
                int questionNumber = generateQuestionNumber(selectedCourse);
                int qu_Num=generateQuestionNumber1();
                Qnumber.setText(""+questionNumber);
                TQ.setText(""+qu_Num);
                Question.setText("");
                option1.setText("");
                option2.setText("");
                option3.setText("");
                option4.setText("");
                correct_answer.setText("");
                
                
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,"Error Adding Question");
            }
	        // TODO add your handling code here:
    }//GEN-LAST:event_b1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
try{
            
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/oes2","root","");
        int qu_Num=generateQuestionNumber1();
        TQ.setText(""+qu_Num);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Not Connected");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void option2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_option2ActionPerformed

    private void QnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QnumberActionPerformed

    private void CourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourActionPerformed
 try {
        selectedCourse = Cour.getSelectedItem().toString();
        int questionNumber = generateQuestionNumber(selectedCourse);
        Qnumber.setText("" + questionNumber);
    } catch (Exception e) {
        e.printStackTrace();
    }       // TODO add your handling code here:
    }//GEN-LAST:event_CourActionPerformed

    private void QuestionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QuestionKeyPressed
   // TODO add your handling code here:
    }//GEN-LAST:event_QuestionKeyPressed

    private void option1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_option1KeyPressed
   // TODO add your handling code here:
    }//GEN-LAST:event_option1KeyPressed

    private void option2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_option2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_option2KeyPressed

    private void option3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_option3KeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_option3KeyPressed

    private void option4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_option4KeyPressed
    // TODO add your handling code here:
    }//GEN-LAST:event_option4KeyPressed

    private void correct_answerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correct_answerKeyPressed
      // TODO add your handling code here:
    }//GEN-LAST:event_correct_answerKeyPressed

    private void b1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b1KeyPressed
       if (!validateFields()) 
{
        return;
}
        
        try
            {
                String cour=Cour.getSelectedItem().toString();
                String Question_Num=TQ.getText();
                String Questions=Question.getText();
                String OPTION1 = option1.getText();
                String OPTION2 = option2.getText();
                String OPTION3 = option3.getText();
                String OPTION4 = option4.getText();
                String cns=correct_answer.getText();
                
                stmt = (Statement) connection.createStatement();
                String query="INSERT INTO add_question VALUES("+Question_Num+",'"+cour+"','"+Questions+"','"+OPTION1+"','"+OPTION2+"','"+OPTION3+"','"+OPTION4+"','"+cns+"')";
                stmt.execute(query);
                JOptionPane.showMessageDialog(this,"Question Added Succesfully");
                
                int questionNumber = generateQuestionNumber(selectedCourse);
                int qu_Num=generateQuestionNumber1();
                Qnumber.setText(""+questionNumber);
                TQ.setText(""+qu_Num);
                Question.setText("");
                option1.setText("");
                option2.setText("");
                option3.setText("");
                option4.setText("");
                correct_answer.setText("");
                
                
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,"Error Adding Question");
            }
	        // TODO add your handling code here: // TODO add your handling code here:
    }//GEN-LAST:event_b1KeyPressed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
System.exit(0);
    }//GEN-LAST:event_b2ActionPerformed

    private void b2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_b2KeyPressed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
new Quiz_Management().setVisible(true);  
dispose();// TODO add your handling code here:
    }//GEN-LAST:event_b3ActionPerformed

    private void b3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_b3KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
            
         
         
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddQuestion().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AddQuestion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> Cour;
    private javax.swing.JTextField Qnumber;
    private javax.swing.JTextField Question;
    private javax.swing.JTextField TQ;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JTextField correct_answer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField option1;
    private javax.swing.JTextField option2;
    private javax.swing.JTextField option3;
    private javax.swing.JTextField option4;
    // End of variables declaration//GEN-END:variables

}
