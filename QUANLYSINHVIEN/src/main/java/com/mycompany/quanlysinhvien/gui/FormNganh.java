package com.mycompany.quanlysinhvien.gui;

import com.mycompany.quanlysinhvien.model.Nganh;
import connect.CommonSql;
import connect.KetNoiSqlServer;
import constance.Constance;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public final class FormNganh extends javax.swing.JFrame {
    private final Connection con = KetNoiSqlServer.getConnection(Constance.DB_URL, Constance.USER_NAME, Constance.PASSWORD);
    ArrayList<Nganh> listnganh;
    public FormNganh() {
        initComponents();        
        listnganh = new ArrayList<>();
        showTable("");
    }   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtmanganh = new javax.swing.JTextField();
        txttennganh = new javax.swing.JTextField();
        btnthem = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnlamlai = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_nganh = new javax.swing.JTable();
        txts = new javax.swing.JTextField();
        txtnum = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnthoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ngành học");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Điền thông tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(51, 51, 51))); // NOI18N

        jLabel1.setText("Mã ngành");

        jLabel2.setText("Tên ngành");

        txtmanganh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtmanganh.setForeground(new java.awt.Color(153, 153, 255));

        txttennganh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txttennganh.setForeground(new java.awt.Color(153, 153, 255));

        btnthem.setBackground(new java.awt.Color(0, 204, 102));
        btnthem.setForeground(new java.awt.Color(255, 255, 255));
        btnthem.setText("Thêm");
        btnthem.setBorderPainted(false);
        btnthem.setFocusPainted(false);
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnxoa.setBackground(new java.awt.Color(255, 51, 0));
        btnxoa.setForeground(new java.awt.Color(255, 255, 255));
        btnxoa.setText("Xóa");
        btnxoa.setBorderPainted(false);
        btnxoa.setFocusPainted(false);
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnsua.setBackground(new java.awt.Color(0, 153, 255));
        btnsua.setForeground(new java.awt.Color(255, 255, 255));
        btnsua.setText("Sửa");
        btnsua.setBorderPainted(false);
        btnsua.setFocusPainted(false);
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnlamlai.setBackground(new java.awt.Color(255, 255, 0));
        btnlamlai.setText("Làm lại");
        btnlamlai.setBorderPainted(false);
        btnlamlai.setFocusPainted(false);
        btnlamlai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlamlaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttennganh)
                    .addComponent(txtmanganh))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnthem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnxoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnlamlai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtmanganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txttennganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnxoa)
                    .addComponent(btnsua)
                    .addComponent(btnlamlai))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tb_nganh.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_nganh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_nganhMouseClicked(evt);
            }
        });
        tb_nganh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_nganhKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_nganh);

        txts.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txts.setForeground(new java.awt.Color(153, 153, 255));
        txts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsKeyReleased(evt);
            }
        });

        txtnum.setText("0");

        jLabel3.setText("Tổng");

        btnthoat.setBackground(new java.awt.Color(51, 51, 51));
        btnthoat.setForeground(new java.awt.Color(255, 255, 255));
        btnthoat.setText("Thoát");
        btnthoat.setBorderPainted(false);
        btnthoat.setFocusPainted(false);
        btnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txts)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnthoat))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnthoat))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnum))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        if(txtmanganh.getText().equals("") || txttennganh.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Hãy nhập dữ liệu");
        else {
            try {
                String manganh = txtmanganh.getText();
                String tennganh = txttennganh.getText();                     
                String sql = "insert into nganh values ('"+manganh+"',N'"+tennganh+"')";
                int kq = CommonSql.iud_Sql(sql, con);
                if(kq>0) {      
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                    listnganh.clear();
                    showTable("");
                    txtmanganh.setText("");
                    txtmanganh.requestFocus();
                    txttennganh.setText("");
                } else { 
                    JOptionPane.showMessageDialog(null, "Thêm thất bại");
                }
            } catch (SQLException ex) {
                Logger.getLogger(FormNganh.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        if(txtmanganh.getText().equals("") && txttennganh.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Hãy nhập dữ liệu");
        else {
            String[] options={"Đồng ý","Không đồng ý"};
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            String path=s+"\\images\\logo.png";
            int choose=JOptionPane.showOptionDialog(null, "Bạn có chắc muốn xóa không?","Thông báo", 
                    JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,
                    new ImageIcon(path), options, options[0]);
            if(choose==0){                   
                try {
                    String manganh = txtmanganh.getText();
                    String tennganh = txttennganh.getText();                     
                    String sql = "delete from nganh where tennganh = N'"+tennganh+"' or manganh = '"+manganh+"'";
                    int kq = CommonSql.iud_Sql(sql, con);
                    if(kq>0) { 
                        JOptionPane.showMessageDialog(null, "Xóa thành công");
                        listnganh.clear();
                        showTable("");
                        txtmanganh.setText("");
                        txtmanganh.requestFocus();
                        txttennganh.setText("");
                    } else { 
                        JOptionPane.showMessageDialog(null, "Xóa thất bại");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FormNganh.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }   
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void tb_nganhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_nganhMouseClicked
        int row = tb_nganh.getSelectedRow();
        txtmanganh.setText(listnganh.get(row).getManganh());
        txttennganh.setText(listnganh.get(row).getTennganh());
    }//GEN-LAST:event_tb_nganhMouseClicked

    private void tb_nganhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_nganhKeyReleased
        int row = tb_nganh.getSelectedRow();
        txtmanganh.setText(listnganh.get(row).getManganh());
        txttennganh.setText(listnganh.get(row).getTennganh());
    }//GEN-LAST:event_tb_nganhKeyReleased

    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed
        dispose();
    }//GEN-LAST:event_btnthoatActionPerformed

    private void btnlamlaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlamlaiActionPerformed
        txtmanganh.setText("");
        txtmanganh.requestFocus();
        txttennganh.setText("");
    }//GEN-LAST:event_btnlamlaiActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        if(txtmanganh.getText().equals("") && txttennganh.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Hãy nhập dữ liệu");
        else {
            try {
                String manganh = txtmanganh.getText();
                String tennganh = txttennganh.getText();                     
                String sql = "update nganh set tennganh = N'"+tennganh+"' where manganh = '"+manganh+"'";
                int kq = CommonSql.iud_Sql(sql, con);
                if(kq>0) { 
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                    listnganh.clear();
                    showTable("");
                    txtmanganh.setText("");
                    txtmanganh.requestFocus();
                    txttennganh.setText("");
                } 
                else { 
                     JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(FormNganh.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void txtsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsKeyPressed
        String s=txts.getText();
        listnganh.clear();
        showTable(s);
    }//GEN-LAST:event_txtsKeyPressed

    private void txtsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsKeyReleased
        String s=txts.getText();
        listnganh.clear();
        showTable(s);
    }//GEN-LAST:event_txtsKeyReleased

    public void showTable(String s) {
        try {           
            String sql = """
                         SELECT *
                         FROM nganh 
                         WHERE manganh like N'%"""+s+"%' OR tennganh like N'%"+s+"%'";
                         
            ResultSet rs = CommonSql.querySlect(sql, con);
            while(rs.next()) {
                String manganh = rs.getString("manganh");
                String tennganh = rs.getString("tennganh");               
                Nganh nganh = new Nganh(manganh, tennganh);                
                listnganh.add(nganh);
            }
            tb_nganh.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {                       
                },
                new String [] {
                    "Mã ngành","Tên ngành"
                }
            ));  
            for(Nganh nganh : listnganh){
                String a[]=new String[]{nganh.getManganh(),nganh.getTennganh()};
                ((DefaultTableModel)tb_nganh.getModel()).addRow(a);
            }
            txtnum.setText(""+listnganh.size());
        } catch (SQLException ex) {
            Logger.getLogger(FormNganh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
            java.util.logging.Logger.getLogger(FormNganh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormNganh().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlamlai;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnthoat;
    private javax.swing.JButton btnxoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_nganh;
    private javax.swing.JTextField txtmanganh;
    private javax.swing.JLabel txtnum;
    private javax.swing.JTextField txts;
    private javax.swing.JTextField txttennganh;
    // End of variables declaration//GEN-END:variables
}
