/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.buoi3.gui.nhoma;

import com.mycompany.buoi3.model.Account;
import com.mycompany.buoi3.model.NhanVien;
import com.mycompany.buoi3.model.PhongBan;
import com.mycompany.buoi3.model.Quyen;
import connect.CommonSQL;
import connect.ketnoiSQLsever;
import constance.Constance;
import constance.MaHoaMD5;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class FrmNewRegister extends javax.swing.JFrame {
    ArrayList<Quyen> arrq;
    ArrayList<Account> list_account;
    Connection conn  = ketnoiSQLsever.getConnection(Constance.DB_URL, Constance.USER_NAME, Constance.PASSWORD);
    /**
     * Creates new form FrmNewRegister
     */
    public FrmNewRegister() throws SQLException {
        initComponents();
//        arrq = new ArrayList<>();
//        arrq.add(new Quyen(0, "admin"));
//        arrq.add(new Quyen(1, "Quản Lý"));
//        arrq.add(new Quyen(2, "Nhân Viên"));
//        for(Quyen q:arrq){
//            cbquyen.addItem(q);
//        }
        // ket noi sql
        if(conn!=null){
            txtconnect.setText("kết nối SQL thành công");
        } else {
            txtconnect.setText("kết nối không thành công");
        }
        cbquyen.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnregisterActionPerformed(null);  // Call login action method
                }
            }
        });
        showCombobox();
        list_account = new ArrayList<>();
        showTableDataFormSQL();
        Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            System.out.println("s"+s);
            String path = s+"\\log\\data.txt";
            String data = CommonSQL.readFile(path);
            System.out.println("data= "+data);
            String a[] = data.split(";");
            System.out.println(""+a[0]);
            System.out.println(""+a[1]);
            System.out.println(""+a[2]);
//            System.out.println(""+a[3]);
            if(a[2].equals("1") || a[2].equals("0" )){
                btnquyen.setVisible(true);
            } else {
                btnquyen.setVisible(true);
            }
    }
    
    private void showCombobox(){
      String sql="select idq,nameq from quyen";
        try {
            ResultSet rs=CommonSQL.querySlect(sql,conn);
            while(rs.next()){
                int idq=rs.getInt("idq");
                String nameq=rs.getString("nameq");
               
                Quyen q=new Quyen(idq,nameq);
                cbquyen.addItem(q);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmPhongBan.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    private void showTableDataFormSQL(){
        tb_account.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {                       
                    },
                    new String [] {
                        "tên đang nhập","Tên đầy đủ","giới tính","chức vụ"
                    }
        ));
        String sql = """
                     SELECT Login.Username, Login.fullname, Login.gender, quyen.nameq, quyen.idq
                     FROM Login
                     INNER JOIN quyen ON Login.permission = quyen.idq;""";
        ResultSet rs;
        try {
            rs = CommonSQL.querySlect(sql, conn);
            while (rs.next()){
                String Username= rs.getString("Username");
                String fullname= rs.getString("fullname");
                String gender= rs.getString("gender");
                String nameq = rs.getString("nameq");
                int idq = rs.getInt("idq");
                Quyen q = new Quyen(idq, nameq);
                list_account.add(new Account(Username,fullname,gender,q));
            }
        } catch (SQLException e) {
            Logger.getLogger(FrmPhongBan.class.getName()).log(Level.SEVERE, null, e);
        }
        for(Account ac:list_account){
            String a[]=new String[]{ac.getUsername(),ac.getFullname(),ac.getGender(), ac.getQ().getNameq()};
            ((DefaultTableModel)tb_account.getModel()).addRow(a);
         }
           txtnum.setText(""+list_account.size());
    }
    
//    private void showCom

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbgt = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        txtpass = new javax.swing.JTextField();
        txtfullname = new javax.swing.JTextField();
        cbquyen = new javax.swing.JComboBox<>();
        btnregister = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        txtconnect = new javax.swing.JLabel();
        btnquyen = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_account = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtnum = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Đăng kí Tài Khoản"));

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jLabel3.setText("Fullname");

        jLabel4.setText("Giới Tính");

        cmbgt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam\t", "Nữ", "Giới tính thứ 3" }));

        jLabel5.setText("Quyền");

        cbquyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbquyenActionPerformed(evt);
            }
        });

        btnregister.setText("Tạo");
        btnregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregisterActionPerformed(evt);
            }
        });

        btnexit.setText("Thoát");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        btnquyen.setText("Thay đổi quyền");
        btnquyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquyenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnregister)
                                .addGap(26, 26, 26)
                                .addComponent(btnexit)
                                .addGap(18, 18, 18)
                                .addComponent(btnquyen))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtuser)
                                .addComponent(txtfullname)
                                .addComponent(txtpass)
                                .addComponent(cmbgt, 0, 244, Short.MAX_VALUE)
                                .addComponent(cbquyen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtfullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbgt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbquyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnregister)
                    .addComponent(btnexit)
                    .addComponent(btnquyen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel6.setText("các tài khoản đang có");

        tb_account.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_account.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_accountMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_account);

        jLabel7.setText("Tổng số tài khoản đang có");

        txtnum.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtnum))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregisterActionPerformed
        try {
            String user = txtuser.getText();
            String pass = txtpass.getText();
            pass = MaHoaMD5.getMd5(pass);
            String fullname = txtfullname.getText();
            String gender = (String)cmbgt.getSelectedItem();
            Quyen q = (Quyen)cbquyen.getSelectedItem();
            String sql = "insert into Login values('"+user+"','"+pass+"',N'"+fullname+"',N'"+gender+"','"+q.getIdg()+"')";
            int kq = CommonSQL.insert_update_deleteSQL(sql, conn);
            if (kq>0) {
            JOptionPane.showMessageDialog(null, "tạo tài khoản thành công");
            list_account.clear();
            showTableDataFormSQL();
            } else {
            JOptionPane.showMessageDialog(null, "Tạo tài khoản thất bại");
                }
            } catch (SQLException ex) {
                  Logger.getLogger(FrmPhongBan.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }//GEN-LAST:event_btnregisterActionPerformed

    private void cbquyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbquyenActionPerformed
        
    }//GEN-LAST:event_cbquyenActionPerformed

    private void tb_accountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_accountMouseClicked
        int row = tb_account.getSelectedRow();
        String user = list_account.get(row).getUsername();
        String fullname = list_account.get(row).getFullname();
        String gt = list_account.get(row).getGender();
        Quyen q = list_account.get(row).getQ();
        txtuser.setText(user);
        txtfullname.setText(user);
        cmbgt.setSelectedItem(gt);
        cbquyen.getModel().setSelectedItem(q);
    }//GEN-LAST:event_tb_accountMouseClicked

    private void btnquyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquyenActionPerformed
        // TODO add your handling code here:
        try {
            String user = txtuser.getText();
            Quyen q = (Quyen)cbquyen.getSelectedItem();
            String sql = "update Login set permission='"+q.getIdg()+"' where username='"+user+"'";
            int kq = CommonSQL.insert_update_deleteSQL(sql, conn);
            if(kq>0){
                JOptionPane.showConfirmDialog(null, "thay đổi quyền thành công");
                list_account.clear();
                showTableDataFormSQL();
            } else {
                JOptionPane.showConfirmDialog(null, "thay đổi quyền thất bại");
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmPhongBan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnquyenActionPerformed

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
            java.util.logging.Logger.getLogger(FrmNewRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNewRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNewRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNewRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmNewRegister().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmNewRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnquyen;
    private javax.swing.JButton btnregister;
    private javax.swing.JComboBox<Quyen> cbquyen;
    private javax.swing.JComboBox<String> cmbgt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_account;
    private javax.swing.JLabel txtconnect;
    private javax.swing.JTextField txtfullname;
    private javax.swing.JLabel txtnum;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
