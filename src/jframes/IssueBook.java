/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;



/**
 *
 * @author Vidusha
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }

    //to fetch the book details from the database and display it to book details panel
public void getBookDetails() {
    int bookId= Integer.parseInt(txt_bookId.getText());
    try {
    Connection con= DBConnection.getConnection();
    PreparedStatement pst = con.prepareStatement("select * from book_details where book_id =?");
     pst.setInt(1, bookId);
     ResultSet rs = pst.executeQuery();
     
if (rs.next()) {
lbl_bookId.setText (rs.getString("book_id"));
lbl_bookName.setText(rs.getString("book_name"));
lbl_author.setText (rs.getString("author"));
lbl_quantity.setText(rs.getString("quantity"));
lbl_bookError.setText("");
}
else{
    lbl_bookError.setText("Invalid Book Id !");
    lbl_bookId.setText ("");
    lbl_bookName.setText("");
    lbl_author.setText("");
    lbl_quantity.setText("");
    }
    }
catch (Exception e) {
e.printStackTrace();
}
}

    //to fetch the student details from the database and display it to book details panel
public void getStudentDetails() {
    int studentId = Integer.parseInt(txt_studentId.getText());
    try {
    Connection con= DBConnection.getConnection();
    PreparedStatement pst = con.prepareStatement("select * from student_details where student_id =?");
     pst.setInt(1, studentId);
     ResultSet rs = pst.executeQuery();
     
if (rs.next()) {
lbl_studentId.setText (rs.getString("student_id"));
lbl_studentName.setText(rs.getString("name"));
lbl_course.setText (rs.getString("course"));
lbl_branch.setText(rs.getString("branch"));
lbl_studenterror.setText("");
}
else{
   lbl_studenterror.setText("Invalid Student Id !");
   lbl_studentId.setText ("");
    lbl_studentName.setText("");
    lbl_course.setText ("");
    lbl_branch.setText("");
    }
    }
   
catch (Exception e) {
e.printStackTrace();
}
}

//insert issue book details to database
public boolean issueBook(){
    boolean isIssued = false;
int bookId = Integer.parseInt(txt_bookId.getText());
int studentId = Integer.parseInt(txt_studentId.getText());
String bookName = lbl_bookName.getText();
String studentName = lbl_studentName.getText ();


Date uIssueDate = date_issueDate.getDatoFecha ();
Date uDueDate = date_dueDate.getDatoFecha();

Long l1 = uIssueDate.getTime();
long l2 = uDueDate.getTime();

java.sql.Date sIssueDate = new java.sql.Date(l1);
java.sql.Date sDueDate = new java.sql.Date(l2);

try{
Connection con=DBConnection.getConnection();
String sql = "insert into issue_book_details(book_id,book_name,student_id,student_name,issue_date,due_date,status) values(?,?,?,?,?,?,?)";
PreparedStatement pst = con.prepareStatement(sql);
pst.setInt(1,bookId);
pst.setString(2,bookName);
pst.setInt(3, studentId);
pst.setString(4,studentName);
pst.setDate(5,sIssueDate);
pst.setDate(6,sDueDate);
pst.setString(7, "pending");

int rowCount = pst.executeUpdate();

if (rowCount > 0) {
    isIssued = true;
}else{
    isIssued =false;
}
}catch(Exception e){
e.printStackTrace();
}
return isIssued;
}

public void updateBookCount () {
int bookId = Integer.parseInt(txt_bookId.getText());
try {
Connection con = DBConnection.getConnection();
String sql = "update book_details set quantity = quantity - 1 where book_id = ?";
PreparedStatement pst = con.prepareStatement (sql);
pst.setInt(1, bookId);

int rowCount = pst.executeUpdate ();

if (rowCount > 0) {

    JOptionPane.showMessageDialog(this,"Book Count Updated");
    int initialCount = Integer.parseInt(lbl_quantity.getText());

    lbl_quantity.setText (Integer.toString(initialCount - 1));
}else{
    JOptionPane. showMessageDialog(this, "can't update book count");
    }
} catch (Exception e) {
    e.printStackTrace () ;
}
}

//check whether book already allocated or not 
public boolean isAlreadyIssued() {

boolean isAlreadyIssued = false;
int bookId = Integer.parseInt(txt_bookId.getText ());
int studentId = Integer.parseInt (txt_studentId.getText ());

try {
Connection con = DBConnection.getConnection();
String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
PreparedStatement pst = con.prepareStatement (sql);
pst.setInt(1, bookId);
pst.setInt(2, studentId);
pst.setString(3, "pending");

ResultSet rs = pst.executeQuery();

if (rs.next()) {
    isAlreadyIssued = true;
}else{
    isAlreadyIssued = false;

}
} catch (Exception e) {

    e.printStackTrace ();
}
    return isAlreadyIssued;
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bookName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        lbl_studentError = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        studentName = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        lbl_studentId = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_studenterror = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        lbl_quantity1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        add_btn = new rojerusan.RSMaterialButtonCircle();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel4 = new javax.swing.JLabel();
        date_toDate = new rojeru_san.componentes.RSDateChooser();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 0, 51));
        jLabel1.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Vidusha\\Desktop\\New folder (4)\\JAVA\\resoures\\AddNewBookIcons\\back.png")); // NOI18N
        jLabel1.setText(" BACK");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 46));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 50));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon("C:\\Users\\Vidusha\\Desktop\\New folder (4)\\JAVA\\resoures\\AddNewBookIcons\\icons8_Literature_100px_1.png")); // NOI18N
        jLabel26.setText(" Books Details ");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 380, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Book Id :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 291, 120, -1));

        bookName.setBackground(new java.awt.Color(255, 255, 255));
        bookName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bookName.setForeground(new java.awt.Color(255, 255, 255));
        bookName.setText("Book Name :");
        jPanel1.add(bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 356, 150, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Aythor :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 421, 120, -1));

        lbl_author.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jPanel1.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 270, 30));

        lbl_bookId.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jPanel1.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 270, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 190, 30));

        lbl_bookName.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jPanel1.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 270, 30));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Quantity :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 486, 120, -1));

        lbl_bookError.setBackground(new java.awt.Color(255, 255, 255));
        lbl_bookError.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 360, 30));

        lbl_quantity.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jPanel1.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 260, 30));

        kGradientPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(51, 51, 51));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(480, 800));

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 794, Short.MAX_VALUE)
        );

        jPanel1.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 800));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 800));

        lbl_studentError.setBackground(new java.awt.Color(255, 0, 0));
        lbl_studentError.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        lbl_studentError.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon("C:\\Users\\Vidusha\\Desktop\\New folder (4)\\JAVA\\resoures\\AddNewBookIcons\\icons8_Student_Registration_100px_2.png")); // NOI18N
        jLabel27.setText(" Student Details ");
        lbl_studentError.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 420, 110));

        lbl_studentName.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lbl_studentError.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 250, 30));

        studentName.setBackground(new java.awt.Color(255, 255, 255));
        studentName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        studentName.setForeground(new java.awt.Color(255, 255, 255));
        studentName.setText("Student Name :");
        lbl_studentError.add(studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 356, 190, -1));

        lbl_branch.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lbl_studentError.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, 210, 30));

        lbl_studentId.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lbl_studentError.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 210, 30));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Student Id :");
        lbl_studentError.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 291, 160, -1));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Branch :");
        lbl_studentError.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 486, 140, -1));

        lbl_course.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lbl_studentError.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 230, 30));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Course :");
        lbl_studentError.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 421, 140, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("X");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        lbl_studentError.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1453, 0, 30, 60));

        lbl_studenterror.setBackground(new java.awt.Color(255, 255, 255));
        lbl_studenterror.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_studenterror.setForeground(new java.awt.Color(255, 255, 255));
        lbl_studentError.add(lbl_studenterror, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 360, 30));

        kGradientPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        kGradientPanel2.setkEndColor(new java.awt.Color(255, 17, 38));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 153, 51));
        kGradientPanel2.setPreferredSize(new java.awt.Dimension(480, 800));

        lbl_quantity1.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addComponent(lbl_quantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 264, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(448, Short.MAX_VALUE)
                .addComponent(lbl_quantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(306, 306, 306))
        );

        lbl_studentError.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, -1));

        getContentPane().add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 480, 800));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setBackground(new java.awt.Color(255, 0, 51));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 0, 0));
        jLabel30.setIcon(new javax.swing.ImageIcon("C:\\Users\\Vidusha\\Desktop\\New folder (4)\\JAVA\\resoures\\AddNewBookIcons\\icons8_Books_52px_1.png")); // NOI18N
        jLabel30.setText(" Isssu Books");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 380, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Book Id :");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 120, 40));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 0, 51)));
        txt_bookId.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txt_bookId.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book Id.....");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        jPanel4.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 260, 40));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 0, 51)));
        txt_studentId.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txt_studentId.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student Id.....");
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
        jPanel4.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 260, 40));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Issu Date :");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 150, 40));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Student Id :");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 150, 40));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Due Date :");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 150, 40));

        add_btn.setBackground(new java.awt.Color(255, 0, 51));
        add_btn.setBorder(null);
        add_btn.setText("ISSUE BOOK");
        add_btn.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });
        jPanel4.add(add_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 650, 240, 70));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setText("X");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(14, 14, 14))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, -1));

        date_dueDate.setColorBackground(new java.awt.Color(255, 0, 51));
        date_dueDate.setColorForeground(new java.awt.Color(0, 0, 0));
        date_dueDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        date_dueDate.setFuente(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        date_dueDate.setPlaceholder("Select Due Date ...");
        jPanel4.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 260, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Due Date :");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 190, -1, -1));

        date_toDate.setColorBackground(new java.awt.Color(255, 0, 51));
        date_toDate.setColorForeground(new java.awt.Color(0, 0, 0));
        date_toDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        date_toDate.setFuente(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        date_toDate.setPlaceholder("Select Due Date ...");
        jPanel4.add(date_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 190, -1, -1));

        date_issueDate.setColorBackground(new java.awt.Color(255, 0, 51));
        date_issueDate.setColorForeground(new java.awt.Color(0, 0, 0));
        date_issueDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        date_issueDate.setFuente(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        date_issueDate.setPlaceholder("Select Issue Date ...");
        jPanel4.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 260, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("X");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 51));
        jLabel18.setText("X");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 30, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, 520, 800));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 80, 800));

        setSize(new java.awt.Dimension(1501, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseClicked

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
     if(!txt_bookId.getText().equals("")){
     getBookDetails();}
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
       if(!txt_studentId.getText().equals("")){
     getStudentDetails();}
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        if(lbl_quantity.getText().equals("0")){
           JOptionPane.showMessageDialog(this,"Book is not available right now");
        }
        else{
             if(isAlreadyIssued()== false){
           if(issueBook() == true){
                JOptionPane.showMessageDialog(this,"Book Issued Successfully ");
                updateBookCount();}   
            else{
                 JOptionPane.showMessageDialog(this,"Can't Issue the Book ");
       }
       }else{
             JOptionPane.showMessageDialog(this,"Student has already this Book ");
       }
        }        
    }//GEN-LAST:event_add_btnActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel18MouseClicked

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle add_btn;
    private javax.swing.JLabel bookName;
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private rojeru_san.componentes.RSDateChooser date_toDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_quantity1;
    private javax.swing.JPanel lbl_studentError;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JLabel lbl_studenterror;
    private javax.swing.JLabel studentName;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
