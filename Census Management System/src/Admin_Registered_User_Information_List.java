import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Admin_Registered_User_Information_List extends javax.swing.JFrame {

    /**
     * Creates new form Registered_User_List
     */
    public Admin_Registered_User_Information_List() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/black info list.png"))); // NOI18N
        jLabel1.setText("Under A Admin General User Infromation");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "User Name", "Email", "Phone", "Admin User Name"
            }
        ));
        jScrollPane1.setViewportView(Table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 1088, 110));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/show little.png"))); // NOI18N
        jButton1.setText("Show Information");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 180, 180, 40));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/cross- 20.png"))); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 380, 110, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/black info list.png"))); // NOI18N
        jLabel2.setText("Registered Users Information List");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jTextField1.setText("Enter Your User Name...");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 340, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         //String Admin_UserName = jTextField1.getText();
         
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/censusmanagement", "root", "");
            Statement st = con.createStatement();
            String sql = "select u.Name,u.User_UserName,u.Email,u.Phone,u.Admin_UserName,a.Admin_UserName from register_user_account as u Inner Join register_admin_account as a on u.Admin_UserName=a.Admin_UserName";
            //String sql="SELECT u.Name,u.User_UserName,u.Email,u.Pass_Word,u.Admin_UserName,a.Admin_UserName FROM `register_user_account` as u INNER JOIN `register_admin_account`as a on u.Admin_UserName=a.Admin_UserName";
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                //Object o[] = {rs.getInt("Name"), rs.getString("UserName"), rs.getString("Email"), rs.getString("Phone"),rs.getString("Pass_Word")};
                //Object o[] = {rs.getInt("RegID"), rs.getString("Name"), rs.getString("FatherName"),rs.getString("DateofBirth"), rs.getString("NIDNo"),rs.getString("Gender"), rs.getString("BloodGroup"), rs.getString("Address"), rs.getString("ContactNumber"),rs.getString("Nationality")};
                //tm.addRow(o);
                
                String Name=rs.getString("Name");
                String UserName=rs.getString("User_UserName");
                String Email=rs.getString("Email");
                String Phone=rs.getString("Phone");
                String Admin_UserName=rs.getString("Admin_UserName");
                //String Pass_Word=rs.getString("Pass_Word");
           
                String tbData[]={Name,UserName,Email,Phone,Admin_UserName};//Pass_Word
                DefaultTableModel tblModel = (DefaultTableModel) Table.getModel();
                
                tblModel.addRow(tbData);
            }
            
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Showing Information Isn't In Corect Format");
        }
        
        /*
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/censusmanagement", "root", "");
            Statement st = conn.createStatement();
            //String sql = "select * from addinformation";
            //String sql = "select * from addinformation Order BY RegID";
            String sql = "select u.Name,u.User_UserName,u.Email,u.Phone,u.Admin_UserName from register_user_account as u Inner join register_admin_account as a on u.Admin_UserName=a.Admin_UserName and a.Admin_UserName='"+Admin_UserName+"' ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            DefaultTableModel tm = (DefaultTableModel) Table.getModel();
            tm.setRowCount(0);
            while (rs.next()) {
                //Object o[] = {rs.getInt("RegID"), rs.getString("Name"), rs.getString("FatherName")};
                jTextField1.setText(rs.getString(1));
                Object o[] = {rs.getInt("Name"), rs.getString("User_UserName"), rs.getString("Email"),rs.getString("Phone"), rs.getString("Admin_UserName")};
                tm.addRow(o);
                
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Showing Information Isn't In Corect Format");
        }*/
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Registered_User_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registered_User_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registered_User_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registered_User_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Registered_User_Information_List().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
