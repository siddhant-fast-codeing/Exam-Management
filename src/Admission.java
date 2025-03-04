/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 91914
 */
public class Admission extends javax.swing.JFrame {
    Statement stmt=null;
    Connection conn=null;
    ResultSet rs;
    
     int generateRegistrationNumber() {
        int registrationNumber=0;
        try {
            stmt = (Statement) conn.createStatement();
            String query = "SELECT MAX(Registration_Number) FROM add_addmission";
            rs = stmt.executeQuery(query);
         if (rs.next()) {
                    int lastRegistrationNumber = rs.getInt(1);
                    System.out.println(""+lastRegistrationNumber);

                    // Increment the last registration number by 1
                    int newRegistrationNumber = lastRegistrationNumber + 1;

                    // Start generating registration numbers from 100
                    if (newRegistrationNumber < 100) {
                        newRegistrationNumber = 100;
                    }

                    registrationNumber = newRegistrationNumber;
                } else {
                    // If no records found, start from 100
                    registrationNumber = 100;
                }
        } catch (SQLException e) {
            
        }
        return registrationNumber;
    }
    
    public String Gender()
    { 
        try
        {
        if(Male.isSelected())
            return "Male";
        else if (Female.isSelected());
            return "Female";
     
        }
        catch(Exception e)
        {
            
        }
        
        return null;
    }
    
    public String MaritalStatus()
    {
        
        try
        {
        if(Married.isSelected())
            return "Married";
        else if (Unmarried.isSelected())
            return "Unmarried";
        }
        catch(Exception e)
        {
            
        }
        
            return null;
      }
    

    /**
     * Creates new form Admission
     */
    public Admission() {
        setUndecorated(true);
        initComponents();
        getContentPane().setBackground(Color.decode("#000000"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Male = new javax.swing.JRadioButton();
        Female = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        Married = new javax.swing.JRadioButton();
        Unmarried = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Address = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        regisNum = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Pincode = new javax.swing.JTextField();
        Fname = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Contact = new javax.swing.JTextField();
        Mname = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Lname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Addhar = new javax.swing.JTextField();
        Course = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        NameCir = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Bdate = new com.toedter.calendar.JDateChooser();
        ExamFormFilling = new com.toedter.calendar.JDateChooser();

        buttonGroup.add(Male);buttonGroup.add(Female);

        buttonGroup1.add(Married);buttonGroup1.add(Unmarried);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 51));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("Date of Birth");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setText("Gender");

        Male.setText("Male");

        Female.setText("Female");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("Marital Status");

        Married.setText("Marrierd");

        Unmarried.setText("Unmarried");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText("Address");

        Address.setColumns(20);
        Address.setRows(5);
        jScrollPane1.setViewportView(Address);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Registration Number:");

        regisNum.setEditable(false);
        regisNum.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setText("Pincode");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("First Name");

        Pincode.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        Fname.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setText("Contact Number");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Middle Name");

        Contact.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        Mname.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setText("email");

        Lname.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        email.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Last Name");

        Addhar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        Course.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course", "C++", "C", "php" }));
        Course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Select Your Course");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Student Exam Form");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel15.setText("Addhar Number");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel16.setText("Date of Form Filling");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Name on certificate");

        NameCir.setEditable(false);
        NameCir.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        NameCir.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NameCirFocusGained(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(jButton1)
                                .addGap(42, 42, 42)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(ExamFormFilling, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(320, 320, 320))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(regisNum, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Course, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NameCir, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Addhar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Fname, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Mname, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Lname, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(Bdate, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Male))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Pincode, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Female)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(Married, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Unmarried)
                            .addComponent(Contact, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(regisNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(Mname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(Lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(Course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(NameCir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(Male)
                    .addComponent(Female)
                    .addComponent(jLabel10)
                    .addComponent(Married)
                    .addComponent(Unmarried)
                    .addComponent(Bdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Pincode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Addhar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExamFormFilling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CourseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Change the format to your needs
    int regisNumber;
    String FirstName, MiddleName, LastName, NameOnCertificate, course, Gender, MaritalStatus, address, pincode, ContactNumber, Email, AddharNumber, DOB, DOA;

    // Check if any field is empty
    if (regisNum.getText().isEmpty() || Fname.getText().isEmpty() || Mname.getText().isEmpty() || Lname.getText().isEmpty() ||
        NameCir.getText().isEmpty() || Course.getSelectedItem() == null || Bdate.getDate() == null || Gender().isEmpty() || 
        MaritalStatus().isEmpty() || Address.getText().isEmpty() || Pincode.getText().isEmpty() || Contact.getText().isEmpty() || 
        email.getText().isEmpty() || Addhar.getText().isEmpty() || ExamFormFilling.getDate() == null) {
        JOptionPane.showMessageDialog(null, "Please fill in all the fields");
        return;
    }

    regisNumber = Integer.parseInt(regisNum.getText());
    FirstName = Fname.getText();
    MiddleName = Mname.getText();
    LastName = Lname.getText();
    NameOnCertificate = NameCir.getText();
    course = Course.getSelectedItem().toString();
    Date DateOfBirth = Bdate.getDate();
    Gender = Gender();
    MaritalStatus = MaritalStatus();
    address = Address.getText();
    pincode = Pincode.getText();
    ContactNumber = Contact.getText();
    Email = email.getText();
    AddharNumber = Addhar.getText();
    Date dateOfadmission = ExamFormFilling.getDate();
    DOB = dateFormat.format(DateOfBirth);
    DOA = dateFormat.format(dateOfadmission);

    // Email Validation
    String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
    if (!Email.matches(emailPattern)) {
        JOptionPane.showMessageDialog(null, "Please enter a valid email address");
        return;
    }

    // Contact Number Validation (Assuming a 10-digit number)
    String contactPattern = "^[0-9]{10}$";
    if (!ContactNumber.matches(contactPattern)) {
        JOptionPane.showMessageDialog(null, "Please enter a valid 10-digit contact number");
        return;
    }

    // Aadhar Number Validation (Assuming a 12-digit Aadhar number)
    String aadharPattern = "^[0-9]{12}$";
    if (!AddharNumber.matches(aadharPattern)) {
        JOptionPane.showMessageDialog(null, "Please enter a valid 12-digit Aadhar number");
        return;
    }

    // Additional field validations can be added similarly.
    // For example, for the 'pincode' field:
    String pincodePattern = "^[0-9]{6}$";
    if (!pincode.matches(pincodePattern)) {
        JOptionPane.showMessageDialog(null, "Please enter a valid 6-digit pincode");
        return;
    }

    stmt = (Statement) conn.createStatement();

    String query = "INSERT INTO add_addmission VALUES(" + regisNumber + ",'" + FirstName + "','" + MiddleName + "','" + LastName + "','" + NameOnCertificate + "','" + course + "','" + DOB + "','" + Gender + "','" + MaritalStatus + "','" + address + "','" + pincode + "','" + ContactNumber + "','" + Email + "','" + AddharNumber + "','" + DOA + "')";
    stmt.execute(query);
    String username = FirstName + regisNumber;
    
    System.out.println(username);
    String password = username;
    System.out.println(password);
    String query1 = "INSERT INTO student_user_id_password VALUES(" + regisNumber + ",'" + NameOnCertificate + "','" + course + "','" + username + "','" + password + "','" + DOA + "', 0)";

    stmt.execute(query1);

    JOptionPane.showMessageDialog(null, "Your Username And Password For Your Exam is\n" + "Username: " + username + "\n" + "Password is: " + username);
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Fill The Fields Properly");
}

        
        /*
try
{
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Change the format to your needs
int regisNumber =Integer.parseInt(regisNum.getText());
String FirstName=Fname.getText();
String MiddleName=Mname.getText();
String LastName=Lname.getText();
String NameOnCertificate=NameCir.getText();
String course=Course.getSelectedItem().toString();
Date DateOfBirth=Bdate.getDate();
String Gender=Gender();
String MaritalStatus=MaritalStatus();
String address=Address.getText();
String pincode=Pincode.getText();
String ContactNumber=Contact.getText();
String Email=email.getText();
String AddharNumber=Addhar.getText();
Date dateOfadmission=ExamFormFilling.getDate();
String DOB=dateFormat.format(DateOfBirth);
String DOA=dateFormat.format(dateOfadmission);
stmt = (Statement) conn.createStatement();
String query="INSERT INTO add_addmission VALUES("+regisNumber+",'"+FirstName+"','"+MiddleName+"','"+LastName+"','"+NameOnCertificate+"','"+course+"','"+DOB+"','"+Gender+"','"+MaritalStatus+"','"+address+"','"+pincode+"','"+ContactNumber+"','"+Email+"','"+AddharNumber+"','"+DOA+"')";

stmt.execute(query);
String username=FirstName+regisNumber;
System.out.println(username);
String pasword=username;
System.out.println(pasword);
String query1="INSERT INTO student_user_id_password VALUES("+regisNumber+",'"+NameOnCertificate+"','"+course+"','"+username+"','"+pasword+"')";
stmt.execute(query1);

    JOptionPane.showMessageDialog(null,"Your Username And Pasword For Your Exam is\n"+"Username: "+username+"\n"+"Password is: "+username);
}
catch(Exception e)
{
    JOptionPane.showMessageDialog(null,"Fill The Fields Properly");
}
*/

/*try {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Change the format to your needs

    // Validate input
    if (regisNum.getText().isEmpty() || Fname.getText().isEmpty() || Lname.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
    } else {
        int regisNumber = Integer.parseInt(regisNum.getText());
        String FirstName = Fname.getText();
        String MiddleName = Mname.getText();
        String LastName = Lname.getText();
        String NameOnCertificate = NameCir.getText();
        String course = Course.getSelectedItem().toString();
        
        // Parse dates
        Date DateOfBirth = Bdate.getDate();
        Date dateOfAdmission = ExamFormFilling.getDate();
        
        if (DateOfBirth == null || dateOfAdmission == null) {
            JOptionPane.showMessageDialog(null, "Invalid date format. Please select valid dates.");
        } else {
            String DOB = dateFormat.format(DateOfBirth);
            String DOA = dateFormat.format(dateOfAdmission);
            String Gender = Gender(); // Define this function to return a valid value
            String MaritalStatus = MaritalStatus(); // Define this function to return a valid value
            String address = Address.getText();
            String pincode = Pincode.getText();
            String ContactNumber = Contact.getText();
            String Email = email.getText();
            String AddharNumber = Addhar.getText();

            stmt = (Statement) conn.createStatement();
            String query = "INSERT INTO add_admission VALUES(" + regisNumber + ",'" + FirstName + "','" + MiddleName + "','" + LastName + "','" + NameOnCertificate + "','" + course + "','" + DOB + "','" + Gender + "','" + MaritalStatus + "','" + address + "','" + pincode + "','" + ContactNumber + "','" + Email + "','" + AddharNumber + "','" + DOA + "')";
            stmt.executeUpdate(query);

            String username = FirstName + regisNumber;
            String password = username;

            String query1 = "INSERT INTO student_user_id_password VALUES(" + regisNumber + ",'" + NameOnCertificate + "','" + course + "','" + username + "','" + password + "')";
            stmt.executeUpdate(query1);

            JOptionPane.showMessageDialog(null, "Your Username And Password For Your Exam is\n" + "Username: " + username + "\nPassword is: " + username);
        }
    }
} catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "An error occurred. Please check your input.");
}
*/
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NameCirFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameCirFocusGained
String FirstName=Fname.getText();
String MiddleName=Mname.getText();
String LastName=Lname.getText();
NameCir.setText(" "+FirstName+" "+MiddleName+" "+LastName);    // TODO add your handling code here:
    }//GEN-LAST:event_NameCirFocusGained

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      try
      {
        Class.forName("com.mysql.cj.jdbc.Driver"); 
        conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/oes2","root","");
        JOptionPane.showMessageDialog(null,"Connected");
       int regNumber=generateRegistrationNumber();
       regisNum.setText(""+regNumber);
      }
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Not Connected");
}// TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        new Student_Management().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admission().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Addhar;
    private javax.swing.JTextArea Address;
    private com.toedter.calendar.JDateChooser Bdate;
    private javax.swing.JTextField Contact;
    javax.swing.JComboBox<String> Course;
    private com.toedter.calendar.JDateChooser ExamFormFilling;
    private javax.swing.JRadioButton Female;
    private javax.swing.JTextField Fname;
    private javax.swing.JTextField Lname;
    private javax.swing.JRadioButton Male;
    private javax.swing.JRadioButton Married;
    private javax.swing.JTextField Mname;
    private javax.swing.JTextField NameCir;
    private javax.swing.JTextField Pincode;
    private javax.swing.JRadioButton Unmarried;
    public javax.swing.ButtonGroup buttonGroup;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField regisNum;
    // End of variables declaration//GEN-END:variables
}
