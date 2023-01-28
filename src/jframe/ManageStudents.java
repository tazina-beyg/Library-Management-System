/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author hp
 */
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    
    String studentName,course,branch;
    int studentId;
    DefaultTableModel model;
    public ManageStudents() {
        initComponents();
        setStudentDetailsToTable();
    }
    //to set the book details into the table 
     public void setStudentDetailsToTable(){
         try {
                   Class.forName("com.mysql.cj.jdbc.Driver"); 
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms?zeroDateTimeBehavior=convertToNull","root", "Password@44"); 
       Statement st = con.createStatement();
      ResultSet rs =  st.executeQuery("select * from student_details");
         
         while(rs.next()){
             String StudentId = rs.getString("student_id");
             String StudentName = rs.getString("name");
             String course = rs.getString("course");
             String branch = rs.getString("branch");
             
             Object[] obj = {StudentId,StudentName,course,branch};
         model = (DefaultTableModel)tbl_studentDetails.getModel();
         model.addRow(obj);
         
         }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     //to add student to student_deatils table
     public boolean addStudent(){
     boolean isAdded = false;
    studentId = Integer.parseInt(txt_studentId.getText());
     studentName = txt_studentName.getText();
      course = combo_CourseName.getSelectedItem().toString();
       branch = jComboBox1.getSelectedItem().toString();
         
         try {
             Connection con = DBConnection.getConnection();
             String sql = "insert into student_details values(?,?,?,?)";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1, studentId);
             pst.setString(2, studentName);
             pst.setString(3, course);
             pst.setString(4, branch);
             
             
            int rowCount =  pst.executeUpdate();
            if(rowCount > 0){
                isAdded = true;
                }else{
                isAdded = false;
            }
         } catch (Exception e) {
             e.printStackTrace();
         }
     return isAdded;
     }
     //to update student details
       public boolean updateStudent(){
            boolean isUpdated = false;
      studentId = Integer.parseInt(txt_studentId.getText());
       studentName = txt_studentName.getText();
        course = combo_CourseName.getSelectedItem().toString();
         branch = jComboBox1.getSelectedItem().toString();
           try {
               Connection con = DBConnection.getConnection();
               String sql = "update student_details set name = ?,course = ?,branch = ? where student_id = ?";
               PreparedStatement pst = con.prepareStatement(sql);
               pst.setString(1, studentName);
               pst.setString(2, course);
               pst.setString(3, branch );
               pst.setInt(4, studentId);
               
               int rowCount = pst.executeUpdate();
               if(rowCount > 0 ){
                   isUpdated = true;
                    }else{
                   isUpdated = false;
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
       return isUpdated;
       }
             
     
       //method to delete book detail
       public boolean deleteStudent(){
           boolean isDeleted = false;
             studentId = Integer.parseInt(txt_studentId.getText());
               try {
               Connection con = DBConnection.getConnection();
               String sql = "delete from student_details where student_id = ? ";
               PreparedStatement pst = con.prepareStatement(sql);
               pst.setInt(1, studentId);
               
            int rowCount =  pst.executeUpdate();
             if(rowCount > 0 ){
                   isDeleted = true;
                    }else{
                   isDeleted = false;
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
             return isDeleted;
             
       }
       
     // method to clear table 
     
     public void clearTable(){
         DefaultTableModel model = (DefaultTableModel) tbl_studentDetails.getModel();
         model.setRowCount(0);
     }
     
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jCTextField5 = new app.bolivia.swing.JCTextField();
        jLabel49 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jCTextField11 = new app.bolivia.swing.JCTextField();
        jLabel53 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jCTextField12 = new app.bolivia.swing.JCTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        txt_username1 = new app.bolivia.swing.JCTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jCTextField13 = new app.bolivia.swing.JCTextField();
        jLabel63 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jCTextField14 = new app.bolivia.swing.JCTextField();
        jLabel67 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jCTextField15 = new app.bolivia.swing.JCTextField();
        jLabel71 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jCTextField16 = new app.bolivia.swing.JCTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jCTextField17 = new app.bolivia.swing.JCTextField();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        txt_password1 = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle5 = new rojerusan.RSMaterialButtonCircle();
        jLabel80 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        txt_studentName = new app.bolivia.swing.JCTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        rSMaterialButtonCircle6 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle7 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle8 = new rojerusan.RSMaterialButtonCircle();
        jPanel19 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        combo_CourseName = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(41, 70, 126));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(102, 102, 255));
        jPanel10.setForeground(new java.awt.Color(102, 102, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 25)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 20, 20));

        jLabel44.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Welcome,Login to your Account");
        jPanel10.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 280, 40));

        jPanel11.setBackground(new java.awt.Color(102, 102, 255));
        jPanel11.setForeground(new java.awt.Color(102, 102, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel11.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 50, 50));

        jLabel47.setFont(new java.awt.Font("Segoe UI Historic", 1, 25)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText(" SignUp Page ");
        jPanel11.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 180, 40));

        jLabel48.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Create New Account Here ");
        jPanel11.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 240, 40));

        jCTextField5.setBackground(new java.awt.Color(102, 102, 255));
        jCTextField5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jCTextField5.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jCTextField5.setPlaceholder("Enter Username");
        jCTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextField5ActionPerformed(evt);
            }
        });
        jPanel11.add(jCTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        jLabel49.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Username");
        jPanel11.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 240, 40));

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 530, 910));

        jPanel12.setBackground(new java.awt.Color(102, 102, 255));
        jPanel12.setForeground(new java.awt.Color(102, 102, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel12.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 50, 50));

        jLabel51.setFont(new java.awt.Font("Segoe UI Historic", 1, 25)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText(" SignUp Page ");
        jPanel12.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 180, 40));

        jLabel52.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Create New Account Here ");
        jPanel12.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 240, 40));

        jCTextField11.setBackground(new java.awt.Color(102, 102, 255));
        jCTextField11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jCTextField11.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jCTextField11.setPlaceholder("Enter Username");
        jCTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextField11ActionPerformed(evt);
            }
        });
        jPanel12.add(jCTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        jLabel53.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Username");
        jPanel12.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 240, 40));

        jPanel13.setBackground(new java.awt.Color(102, 102, 255));
        jPanel13.setForeground(new java.awt.Color(102, 102, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel13.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 50, 50));

        jLabel55.setFont(new java.awt.Font("Segoe UI Historic", 1, 25)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText(" SignUp Page ");
        jPanel13.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 180, 40));

        jLabel56.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Create New Account Here ");
        jPanel13.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 240, 40));

        jCTextField12.setBackground(new java.awt.Color(102, 102, 255));
        jCTextField12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jCTextField12.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jCTextField12.setPlaceholder("Enter Username");
        jCTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextField12ActionPerformed(evt);
            }
        });
        jPanel13.add(jCTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        jLabel57.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Username");
        jPanel13.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 240, 40));

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 530, 910));

        jPanel10.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 530, 910));

        jLabel58.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Username");
        jPanel10.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 240, 40));

        jLabel59.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel10.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 50, 50));

        txt_username1.setBackground(new java.awt.Color(102, 102, 255));
        txt_username1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_username1.setPlaceholder("Enter Username");
        txt_username1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_username1FocusLost(evt);
            }
        });
        txt_username1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_username1ActionPerformed(evt);
            }
        });
        jPanel10.add(txt_username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, -1, -1));

        jPanel14.setBackground(new java.awt.Color(102, 102, 255));
        jPanel14.setForeground(new java.awt.Color(102, 102, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel14.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 50, 50));

        jLabel61.setFont(new java.awt.Font("Segoe UI Historic", 1, 25)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText(" SignUp Page ");
        jPanel14.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 180, 40));

        jLabel62.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Create New Account Here ");
        jPanel14.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 240, 40));

        jCTextField13.setBackground(new java.awt.Color(102, 102, 255));
        jCTextField13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jCTextField13.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jCTextField13.setPlaceholder("Enter Username");
        jCTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextField13ActionPerformed(evt);
            }
        });
        jPanel14.add(jCTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        jLabel63.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Username");
        jPanel14.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 240, 40));

        jPanel15.setBackground(new java.awt.Color(102, 102, 255));
        jPanel15.setForeground(new java.awt.Color(102, 102, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel64.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel15.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 50, 50));

        jLabel65.setFont(new java.awt.Font("Segoe UI Historic", 1, 25)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText(" SignUp Page ");
        jPanel15.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 180, 40));

        jLabel66.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("Create New Account Here ");
        jPanel15.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 240, 40));

        jCTextField14.setBackground(new java.awt.Color(102, 102, 255));
        jCTextField14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jCTextField14.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jCTextField14.setPlaceholder("Enter Username");
        jCTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextField14ActionPerformed(evt);
            }
        });
        jPanel15.add(jCTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        jLabel67.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Username");
        jPanel15.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 240, 40));

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 530, 910));

        jPanel16.setBackground(new java.awt.Color(102, 102, 255));
        jPanel16.setForeground(new java.awt.Color(102, 102, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel16.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 50, 50));

        jLabel69.setFont(new java.awt.Font("Segoe UI Historic", 1, 25)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText(" SignUp Page ");
        jPanel16.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 180, 40));

        jLabel70.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("Create New Account Here ");
        jPanel16.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 240, 40));

        jCTextField15.setBackground(new java.awt.Color(102, 102, 255));
        jCTextField15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jCTextField15.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jCTextField15.setPlaceholder("Enter Username");
        jCTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextField15ActionPerformed(evt);
            }
        });
        jPanel16.add(jCTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        jLabel71.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Username");
        jPanel16.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 240, 40));

        jPanel17.setBackground(new java.awt.Color(102, 102, 255));
        jPanel17.setForeground(new java.awt.Color(102, 102, 255));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel17.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 50, 50));

        jLabel73.setFont(new java.awt.Font("Segoe UI Historic", 1, 25)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText(" SignUp Page ");
        jPanel17.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 180, 40));

        jLabel74.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Create New Account Here ");
        jPanel17.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 240, 40));

        jCTextField16.setBackground(new java.awt.Color(102, 102, 255));
        jCTextField16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jCTextField16.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jCTextField16.setPlaceholder("Enter Username");
        jCTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextField16ActionPerformed(evt);
            }
        });
        jPanel17.add(jCTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        jLabel75.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("Username");
        jPanel17.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 240, 40));

        jPanel16.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 530, 910));

        jPanel14.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 530, 910));

        jLabel76.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("Username");
        jPanel14.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 240, 40));

        jLabel77.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel14.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 50, 50));

        jCTextField17.setBackground(new java.awt.Color(102, 102, 255));
        jCTextField17.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jCTextField17.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jCTextField17.setPlaceholder("Enter Username");
        jCTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTextField17ActionPerformed(evt);
            }
        });
        jPanel14.add(jCTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        jPanel10.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 530, 910));

        jLabel78.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel10.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 50, 50));

        jLabel79.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Password");
        jPanel10.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 240, 40));

        txt_password1.setBackground(new java.awt.Color(102, 102, 255));
        txt_password1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_password1.setPlaceholder("Enter Password");
        txt_password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_password1ActionPerformed(evt);
            }
        });
        jPanel10.add(txt_password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, -1, -1));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(51, 0, 255));
        rSMaterialButtonCircle4.setText("LogIN");
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel10.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 270, 60));

        rSMaterialButtonCircle5.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle5.setText("SignUp");
        rSMaterialButtonCircle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle5ActionPerformed(evt);
            }
        });
        jPanel10.add(rSMaterialButtonCircle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, 270, 60));

        jLabel80.setFont(new java.awt.Font("Segoe UI Historic", 1, 25)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setText("Login Page");
        jPanel10.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 130, 40));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 530, 910));

        txt_studentId.setBackground(new java.awt.Color(41, 70, 135));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentId.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student ID ...");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel9.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 250, 30));

        jLabel81.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px_1.png"))); // NOI18N
        jPanel9.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 30, 40));

        jLabel82.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setText("Enter Student ID");
        jPanel9.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 240, 40));

        jLabel83.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel9.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        jLabel84.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setText("Enter Student Name");
        jPanel9.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 240, 40));

        txt_studentName.setBackground(new java.awt.Color(41, 70, 135));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentName.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_studentName.setPlaceholder("Enter Student Name ...");
        txt_studentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentNameFocusLost(evt);
            }
        });
        txt_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentNameActionPerformed(evt);
            }
        });
        jPanel9.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 250, 30));

        jLabel85.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel9.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, 60));

        jLabel86.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText("Select Course");
        jPanel9.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 240, 40));

        jLabel87.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("Select Branch");
        jPanel9.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 240, 40));

        jLabel88.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel9.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, 50));

        rSMaterialButtonCircle6.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonCircle6.setForeground(new java.awt.Color(41, 70, 126));
        rSMaterialButtonCircle6.setText("DELETE");
        rSMaterialButtonCircle6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle6ActionPerformed(evt);
            }
        });
        jPanel9.add(rSMaterialButtonCircle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 560, 130, 60));

        rSMaterialButtonCircle7.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonCircle7.setForeground(new java.awt.Color(41, 70, 126));
        rSMaterialButtonCircle7.setText("ADD");
        rSMaterialButtonCircle7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle7ActionPerformed(evt);
            }
        });
        jPanel9.add(rSMaterialButtonCircle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 130, 60));

        rSMaterialButtonCircle8.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonCircle8.setForeground(new java.awt.Color(41, 70, 126));
        rSMaterialButtonCircle8.setText("UPDATE");
        rSMaterialButtonCircle8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle8ActionPerformed(evt);
            }
        });
        jPanel9.add(rSMaterialButtonCircle8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 560, 130, 60));

        jPanel19.setBackground(new java.awt.Color(202, 169, 95));
        jPanel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel19MouseClicked(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(202, 169, 95));
        jLabel5.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px_1.png"))); // NOI18N
        jLabel5.setText("Back");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 50));

        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "CS", "SE", "GIS", " ", " " }));
        jPanel9.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 240, 30));

        combo_CourseName.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_CourseName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSC", "MSC", "PHD" }));
        jPanel9.add(combo_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 240, 30));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 1030));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(202, 169, 95));
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel18MouseClicked(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(102, 102, 255));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 23)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, 60, 40));

        tbl_studentDetails.setBackground(new java.awt.Color(242, 242, 242));
        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(41, 70, 126));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(41, 70, 126));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(202, 169, 95));
        tbl_studentDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_studentDetails.setRowHeight(33);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentDetails);
        if (tbl_studentDetails.getColumnModel().getColumnCount() > 0) {
            tbl_studentDetails.getColumnModel().getColumn(0).setResizable(false);
            tbl_studentDetails.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 750, 270));

        jLabel1.setBackground(new java.awt.Color(240, 240, 240));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(202, 169, 95));
        jLabel1.setText("   Manage Students");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 300, 90));

        jPanel2.setBackground(new java.awt.Color(202, 169, 95));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 410, 5));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 1110, 1020));

        setSize(new java.awt.Dimension(1545, 1023));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        //System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jCTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextField5ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextField5ActionPerformed

    private void jCTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextField11ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextField11ActionPerformed

    private void jCTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextField12ActionPerformed

    private void txt_username1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_username1FocusLost

    }//GEN-LAST:event_txt_username1FocusLost

    private void txt_username1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_username1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_username1ActionPerformed

    private void jCTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextField13ActionPerformed

    private void jCTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextField14ActionPerformed

    private void jCTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextField15ActionPerformed

    private void jCTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextField16ActionPerformed

    private void jCTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTextField17ActionPerformed

    private void txt_password1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_password1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_password1ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
        // TODO add your handling code here:
   
       
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
        {
            ManageStudents books = new ManageStudents();
            books.setVisible(true);
            dispose();

        }
    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost

    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameFocusLost

    private void txt_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameActionPerformed

    private void rSMaterialButtonCircle6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle6ActionPerformed
        if (deleteStudent()== true){
         JOptionPane.showMessageDialog(this, "Student Deleted");
         clearTable();
         setStudentDetailsToTable();
     }else{
         JOptionPane.showMessageDialog(this, "Student Deletion Failure");
     }
        




      
    }//GEN-LAST:event_rSMaterialButtonCircle6ActionPerformed

    private void rSMaterialButtonCircle7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle7ActionPerformed
     if (addStudent() == true){
         JOptionPane.showMessageDialog(this, "Student Added");
         clearTable();
         setStudentDetailsToTable();
     }else{
         JOptionPane.showMessageDialog(this, "Student Addition Failure");
     }
    }//GEN-LAST:event_rSMaterialButtonCircle7ActionPerformed

    private void rSMaterialButtonCircle8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle8ActionPerformed
         if (updateStudent()== true){
         JOptionPane.showMessageDialog(this, "Student Updated");
         clearTable();
         setStudentDetailsToTable();
     }else{
         JOptionPane.showMessageDialog(this, "Student Updation Failure");
     }
    }//GEN-LAST:event_rSMaterialButtonCircle8ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jPanel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseClicked
          
    }//GEN-LAST:event_jPanel18MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
      HomePage home = new HomePage();
            home.setVisible(true);
            dispose();  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jPanel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MouseClicked

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
       
         int rowNo = tbl_studentDetails.getSelectedRow();
         TableModel model = tbl_studentDetails.getModel();
        
         txt_studentId.setText(model.getValueAt(rowNo, 0).toString());
          txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
           combo_CourseName.setSelectedItem(model.getValueAt(rowNo, 2).toString());
           jComboBox1.setSelectedItem(model.getValueAt(rowNo, 3).toString());
         
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_CourseName;
    private app.bolivia.swing.JCTextField jCTextField11;
    private app.bolivia.swing.JCTextField jCTextField12;
    private app.bolivia.swing.JCTextField jCTextField13;
    private app.bolivia.swing.JCTextField jCTextField14;
    private app.bolivia.swing.JCTextField jCTextField15;
    private app.bolivia.swing.JCTextField jCTextField16;
    private app.bolivia.swing.JCTextField jCTextField17;
    private app.bolivia.swing.JCTextField jCTextField5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle5;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle6;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle7;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle8;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    private app.bolivia.swing.JCTextField txt_password1;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentName;
    private app.bolivia.swing.JCTextField txt_username1;
    // End of variables declaration//GEN-END:variables
}
