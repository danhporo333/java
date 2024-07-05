
package com.mycompany.qlsv.gui;

import connect.CommonSQL;
import java.awt.Image;
import java.awt.Toolkit;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class FormMenu extends javax.swing.JFrame {
    private String a[];
   
    public FormMenu() {
        initComponents();
        // đọc dữ liệu để lấy quyền
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();                
        String path=s+"\\log\\data.txt";
        String data = CommonSQL.readFile(path);
        a = data.split(";");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mi_add_student = new javax.swing.JMenuItem();
        mi_add_class = new javax.swing.JMenuItem();
        mi_nganh = new javax.swing.JMenuItem();
        Timkiem = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        mi_createaccount = new javax.swing.JMenuItem();
        Quyen = new javax.swing.JMenuItem();
        menu_exit = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang Chủ");

        jLabel1.setText("QLSV_Dương Tất Danh");

        jMenu1.setText("Chức năng");

        mi_add_student.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mi_add_student.setText("thêm sinh viên");
        mi_add_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_add_studentActionPerformed(evt);
            }
        });
        jMenu1.add(mi_add_student);

        mi_add_class.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mi_add_class.setText("Thêm lớp");
        mi_add_class.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_add_classActionPerformed(evt);
            }
        });
        jMenu1.add(mi_add_class);

        mi_nganh.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mi_nganh.setText("thêm ngành");
        mi_nganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_nganhActionPerformed(evt);
            }
        });
        jMenu1.add(mi_nganh);

        jMenuBar1.add(jMenu1);

        Timkiem.setText("Tìm kiếm");
        Timkiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TimkiemMouseClicked(evt);
            }
        });
        jMenuBar1.add(Timkiem);

        jMenu3.setText("Tài Khoản");

        mi_createaccount.setText("tạo tài khoản");
        mi_createaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_createaccountActionPerformed(evt);
            }
        });
        jMenu3.add(mi_createaccount);

        Quyen.setText("quyền");
        Quyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuyenActionPerformed(evt);
            }
        });
        jMenu3.add(Quyen);

        jMenuBar1.add(jMenu3);

        menu_exit.setText("Đăng xuất");
        menu_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_exitMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_exit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(373, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(251, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(17, 17, 17))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menu_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_exitMouseClicked
        // TODO add your handling code here:
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
            try {
                dispose();
                FromLogin m = new FromLogin();
                Image iconImage = Toolkit.getDefaultToolkit().getImage(".\\images\\login.png");
                m.setIconImage(iconImage);
                m.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(FormMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_menu_exitMouseClicked

    private void mi_nganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_nganhActionPerformed
        // TODO add your handling code here:
         if(!(a[2].equals("1"))) {
            JOptionPane.showMessageDialog(null, "không đủ quyền hạn");
        }
        else {
            FormNganh fm = new FormNganh();
            Image iconImage = Toolkit.getDefaultToolkit().getImage(".\\images\\nganh.png");
            fm.setIconImage(iconImage);
            fm.setVisible(true);
        }       
    }//GEN-LAST:event_mi_nganhActionPerformed

    private void mi_add_classActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_add_classActionPerformed
        // TODO add your handling code here:
        if(!(a[2].equals("1"))) {
            JOptionPane.showMessageDialog(null, "không đủ quyền hạn");
        }
        else {
            FormClass fm = new FormClass();        
            Image iconImage = Toolkit.getDefaultToolkit().getImage(".\\images\\graduated.png");
            fm.setIconImage(iconImage);
            fm.setVisible(true);
        }       
    }//GEN-LAST:event_mi_add_classActionPerformed

    private void mi_add_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_add_studentActionPerformed
        // TODO add your handling code here:
        if(!(a[2].equals("1"))) {
            JOptionPane.showMessageDialog(null, "không đủ quyền hạn");
        }
        else {
            FormSV fm = new FormSV();        
            Image iconImage = Toolkit.getDefaultToolkit().getImage(".\\images\\graduated.png");
            fm.setIconImage(iconImage);
            fm.setVisible(true);
        }       
    }//GEN-LAST:event_mi_add_studentActionPerformed

    private void TimkiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimkiemMouseClicked
        // TODO add your handling code here:
        FormTimKiem fm = new FormTimKiem();        
        Image iconImage = Toolkit.getDefaultToolkit().getImage(".\\images\\find.png");
        fm.setIconImage(iconImage);
        fm.setVisible(true);  
    }//GEN-LAST:event_TimkiemMouseClicked

    private void QuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuyenActionPerformed
        // TODO add your handling code here:
        if(!(a[2].equals("1"))) {
            JOptionPane.showMessageDialog(null, "không đủ quyền hạn");
        }
        else {
            FormQuyen fm = new FormQuyen();        
            Image iconImage = Toolkit.getDefaultToolkit().getImage(".\\images\\key.png");
            fm.setIconImage(iconImage);
            fm.setVisible(true);
        }       
    }//GEN-LAST:event_QuyenActionPerformed

    private void mi_createaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_createaccountActionPerformed
        // TODO add your handling code here:
        if(!(a[2].equals("1"))) {
            JOptionPane.showMessageDialog(null, "Bạn không được phép truy cập vào mục này");
        }
        else {
            FormRegister fm = new FormRegister();        
            Image iconImage = Toolkit.getDefaultToolkit().getImage(".\\images\\add.png");
            fm.setIconImage(iconImage);
            fm.setVisible(true);
        }
    }//GEN-LAST:event_mi_createaccountActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Quyen;
    private javax.swing.JMenu Timkiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu menu_exit;
    private javax.swing.JMenuItem mi_add_class;
    private javax.swing.JMenuItem mi_add_student;
    private javax.swing.JMenuItem mi_createaccount;
    private javax.swing.JMenuItem mi_nganh;
    // End of variables declaration//GEN-END:variables
}
