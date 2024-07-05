package com.mycompany.quanlysinhvien.gui;

import connect.CommonSql;
import java.awt.Image;
import java.awt.Toolkit;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FormMenu extends javax.swing.JFrame {
    private String a[];
    public FormMenu() {
        initComponents();
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();                
        String path=s+"\\log\\data.txt";
        String data = CommonSql.readFile(path);
        a = data.split(";");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        mi_sinhvien = new javax.swing.JMenuItem();
        mi_lop = new javax.swing.JMenuItem();
        mi_nganh = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menu_timkiem = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        mi_create = new javax.swing.JMenuItem();
        mi_per = new javax.swing.JMenuItem();
        menu_logout = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jLabel3.setIcon(new javax.swing.ImageIcon("D:\\java\\BUOI3\\images\\chomduong.png")); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang chủ");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 340));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\Pictures\\images.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 230, 250));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("QLSV_Dương Tất Danh");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jMenu9.setText("Danh mục");

        mi_sinhvien.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mi_sinhvien.setText("Sinh viên");
        mi_sinhvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_sinhvienActionPerformed(evt);
            }
        });
        jMenu9.add(mi_sinhvien);

        mi_lop.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mi_lop.setText("Lớp");
        mi_lop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_lopActionPerformed(evt);
            }
        });
        jMenu9.add(mi_lop);

        mi_nganh.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mi_nganh.setText("Ngành");
        mi_nganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_nganhActionPerformed(evt);
            }
        });
        jMenu9.add(mi_nganh);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Niên Khóa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem2);

        jMenuBar1.add(jMenu9);

        menu_timkiem.setText("Tìm kiếm sinh viên");
        menu_timkiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_timkiemMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_timkiem);

        jMenu1.setText("Tài khoản");

        mi_create.setText("Tạo tài khoản");
        mi_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_createActionPerformed(evt);
            }
        });
        jMenu1.add(mi_create);

        mi_per.setText("Các quyền");
        mi_per.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_perActionPerformed(evt);
            }
        });
        jMenu1.add(mi_per);

        jMenuBar1.add(jMenu1);

        menu_logout.setText("Đăng xuất");
        menu_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_logoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_logout);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menu_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_logoutMouseClicked
        String[] options={"Đồng ý","Không đồng ý"};
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        String path=s+"\\images\\logo.png";
        int choose=JOptionPane.showOptionDialog(null,
                "Đăng xuất không?","Thông báo",
                JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, 
                new ImageIcon(path), options, options[0]);
        if(choose==0){
            dispose();
            FormLogin fm = new FormLogin();
            Image iconImage = Toolkit.getDefaultToolkit().getImage(".\\images\\login.png");
            fm.setIconImage(iconImage);
            fm.setVisible(true);
        }
    }//GEN-LAST:event_menu_logoutMouseClicked

    private void mi_nganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_nganhActionPerformed
        if(!(a[2].equals("1"))) {
            JOptionPane.showMessageDialog(null, "Bạn không được phép truy cập vào mục này");
        }
        else {
            FormNganh fm = new FormNganh();
            Image iconImage = Toolkit.getDefaultToolkit().getImage(".\\images\\nganh.png");
            fm.setIconImage(iconImage);
            fm.setVisible(true);
        }               
    }//GEN-LAST:event_mi_nganhActionPerformed

    private void mi_lopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_lopActionPerformed
        if(!(a[2].equals("1"))) {
            JOptionPane.showMessageDialog(null, "Bạn không được phép truy cập vào mục này");
        }
        else {
            FormClass fm = new FormClass();        
            Image iconImage = Toolkit.getDefaultToolkit().getImage(".\\images\\class.png");
            fm.setIconImage(iconImage);
            fm.setVisible(true);
        }       
    }//GEN-LAST:event_mi_lopActionPerformed

    private void mi_sinhvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_sinhvienActionPerformed
        if(!(a[2].equals("1"))) {
            JOptionPane.showMessageDialog(null, "Bạn không được phép truy cập vào mục này");
        }
        else {
            FormSV fm = new FormSV();        
            Image iconImage = Toolkit.getDefaultToolkit().getImage(".\\images\\student.png");
            fm.setIconImage(iconImage);
            fm.setVisible(true);
        }       
    }//GEN-LAST:event_mi_sinhvienActionPerformed

    private void menu_timkiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_timkiemMouseClicked
        FormTimKiem fm = new FormTimKiem();        
        Image iconImage = Toolkit.getDefaultToolkit().getImage(".\\images\\search.png");
        fm.setIconImage(iconImage);
        fm.setVisible(true);                          
    }//GEN-LAST:event_menu_timkiemMouseClicked

    private void mi_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_createActionPerformed
        if(!(a[2].equals("1"))) {
            JOptionPane.showMessageDialog(null, "Bạn không được phép truy cập vào mục này");
        }
        else {
            FormRegister fm = new FormRegister();        
            Image iconImage = Toolkit.getDefaultToolkit().getImage(".\\images\\register.png");
            fm.setIconImage(iconImage);
            fm.setVisible(true);
        }
    }//GEN-LAST:event_mi_createActionPerformed

    private void mi_perActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_perActionPerformed
        if(!(a[2].equals("1"))) {
            JOptionPane.showMessageDialog(null, "Bạn không được phép truy cập vào mục này");
        }
        else {
            FormQuyen fm = new FormQuyen();        
            Image iconImage = Toolkit.getDefaultToolkit().getImage(".\\images\\user.png");
            fm.setIconImage(iconImage);
            fm.setVisible(true);
        }       
    }//GEN-LAST:event_mi_perActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if(!(a[2].equals("1"))) {
            JOptionPane.showMessageDialog(null, "Bạn không được phép truy cập vào mục này");
        }
        else {
            FormNienKhoa fm = new FormNienKhoa();        
            Image iconImage = Toolkit.getDefaultToolkit().getImage(".\\images\\year.png");
            fm.setIconImage(iconImage);
            fm.setVisible(true);
        }       
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menu_logout;
    private javax.swing.JMenu menu_timkiem;
    private javax.swing.JMenuItem mi_create;
    private javax.swing.JMenuItem mi_lop;
    private javax.swing.JMenuItem mi_nganh;
    private javax.swing.JMenuItem mi_per;
    private javax.swing.JMenuItem mi_sinhvien;
    // End of variables declaration//GEN-END:variables
}
