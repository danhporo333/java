/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.buoi3.gui.nhoma;


import connect.CommonSQL;
import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class FrmMenu extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenu
     */
    public FrmMenu() {
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/resource/computer.png"));
        Image image = icon.getImage();
        setIconImage(image);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mi_exit = new javax.swing.JMenuItem();
        mi_register = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mi_phongban = new javax.swing.JMenuItem();
        mi_nhanvien = new javax.swing.JMenuItem();
        mi_quyen = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        timkiem = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenu7.setText("File");
        jMenuBar2.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar2.add(jMenu8);

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Dương Tất Danh");

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\java\\BUOI3\\images\\chomduong.png")); // NOI18N

        jMenu1.setText("Chức năng");
        jMenu1.setToolTipText("Chức năng dùng để thoát");

        mi_exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mi_exit.setIcon(new javax.swing.ImageIcon("D:\\java\\BUOI3\\images\\notepad.png")); // NOI18N
        mi_exit.setText("Thoát");
        mi_exit.setToolTipText("chức năng thoát");
        mi_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_exitActionPerformed(evt);
            }
        });
        jMenu1.add(mi_exit);

        mi_register.setText("Đăng kí Tài Khoản");
        mi_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_registerActionPerformed(evt);
            }
        });
        jMenu1.add(mi_register);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Danh mục");

        mi_phongban.setText("Phòng ban");
        mi_phongban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_phongbanActionPerformed(evt);
            }
        });
        jMenu2.add(mi_phongban);

        mi_nhanvien.setText("Nhân Viên");
        mi_nhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_nhanvienActionPerformed(evt);
            }
        });
        jMenu2.add(mi_nhanvien);

        mi_quyen.setText("Quyền");
        mi_quyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_quyenActionPerformed(evt);
            }
        });
        jMenu2.add(mi_quyen);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Nghiệp Vụ");
        jMenuBar1.add(jMenu3);

        timkiem.setText("Tìm kiếm");
        timkiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timkiemMouseClicked(evt);
            }
        });
        jMenuBar1.add(timkiem);

        jMenu5.setText("Báo cáo ");
        jMenuBar1.add(jMenu5);

        jMenu6.setText("Thoát");
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mi_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_exitActionPerformed
        String[] options={"Đồng ý","Không đồng ý"};
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("s"+s);
        String path=s+"\\images\\exit.png";
        int choose=JOptionPane.showOptionDialog(null,
                "Bạn có chắc thoát ứng dụng không?","Thông báo",
                JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, 
                new ImageIcon(path), options, options[0]);
        System.out.println(""+choose);
        if(choose==0){
            System.out.println("Đã click đồng ý");
            System.exit(0);
        }else{
            System.out.println("Đã click không đồng ý");
        }
    }//GEN-LAST:event_mi_exitActionPerformed

    private void mi_phongbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_phongbanActionPerformed
        FrmPhongBan pb = null;
        try {
            pb = new FrmPhongBan();
        } catch (SQLException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        pb.setVisible(true);
    }//GEN-LAST:event_mi_phongbanActionPerformed

    private void mi_nhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_nhanvienActionPerformed
       FrmNhanVien nv = new FrmNhanVien();
       nv.setVisible(true);
    }//GEN-LAST:event_mi_nhanvienActionPerformed

    private void mi_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_registerActionPerformed
        try {
            FrmNewRegister r = new FrmNewRegister();
            r.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_mi_registerActionPerformed

    private void timkiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timkiemMouseClicked
        Timkiem tk = null;
        try {
            tk = new Timkiem();
        } catch (SQLException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        tk.setVisible(true);
    }//GEN-LAST:event_timkiemMouseClicked

    private void mi_quyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_quyenActionPerformed
        // TODO add your handling code here:
        FrmQuyen q = null;
        try {
            q = new FrmQuyen();
        } catch (SQLException ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        q.setVisible(true);
    }//GEN-LAST:event_mi_quyenActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem mi_exit;
    private javax.swing.JMenuItem mi_nhanvien;
    private javax.swing.JMenuItem mi_phongban;
    private javax.swing.JMenuItem mi_quyen;
    private javax.swing.JMenuItem mi_register;
    private javax.swing.JMenu timkiem;
    // End of variables declaration//GEN-END:variables
}