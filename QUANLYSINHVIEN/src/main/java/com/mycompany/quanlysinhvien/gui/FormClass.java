package com.mycompany.quanlysinhvien.gui;

import com.mycompany.quanlysinhvien.model.Lop;
import com.mycompany.quanlysinhvien.model.Nganh;
import com.mycompany.quanlysinhvien.model.Nienkhoa;
import connect.CommonSql;
import connect.KetNoiSqlServer;
import constance.Constance;
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

public final class FormClass extends javax.swing.JFrame {
    private final Connection con = KetNoiSqlServer.getConnection(Constance.DB_URL, Constance.USER_NAME, Constance.PASSWORD);
    ArrayList<Lop> listlop;
    public FormClass() {
        initComponents();
        showCombobox();
        showcombobox2();
        listlop = new ArrayList<>();
        showTable("","");
    }
    
    private void showCombobox() {
        try {
            String sql = """
                            SELECT manganh, tennganh
                            FROM nganh""";
            ResultSet rs = CommonSql.querySlect(sql, con);
            while(rs.next()) {
                String manganh = rs.getString("manganh");
                String tennganh = rs.getString("tennganh");                
                Nganh n = new Nganh(manganh, tennganh);
                cbnganh1.addItem(n);
                cb_nganh2.addItem(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showcombobox2() {
    try {
        cb_khoa2.addItem(null);
            String sql = "SELECT makhoa FROM khoa";
            ResultSet rs = CommonSql.querySlect(sql, con);

            // Duyệt qua các hàng trong ResultSet
            while (rs.next()) {
                String khoa = rs.getString("makhoa");
                Nienkhoa k = new Nienkhoa(khoa);
                cb_khoa2.addItem(k);
            }
    } catch(SQLException ex) {
        Logger.getLogger(FormClass.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    
    public void showTable(String ma, String kh) {
        try {           
            String sql = """
                         SELECT lop.malop, lop.tenlop, lop.manganh, lop.khoa, lop.soluongsv, nganh.tennganh
                         FROM lop INNER JOIN
                         nganh ON lop.manganh = nganh.manganh
                         WHERE lop.manganh like '%"""+ma+"%' and lop.khoa like '%"+kh+"%'";
                         
            ResultSet rs = CommonSql.querySlect(sql, con);
            while(rs.next()) {
                String malop = rs.getString("malop");
                String tenlop = rs.getString("tenlop");
                String manganh = rs.getString("manganh");
                String tennganh = rs.getString("tennganh");
                String khoa = rs.getString("khoa");
                String soluong = rs.getString("soluongsv");
                Nganh nganh = new Nganh(manganh, tennganh);
                Lop lop = new Lop(malop, tenlop, nganh, khoa, soluong);
                listlop.add(lop);
            }
            tb_lop.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {                       
                },
                new String [] {
                    "Mã lớp","Tên lớp", "Ngành", "Khóa", "Số lượng"
                }
            ));  
            
            for(Lop lop : listlop){
                String a[]=new String[]{lop.getMalop(), lop.getTenlop(), lop.getNganh().getTennganh(), lop.getKhoa(), lop.getSoluong()};
                ((DefaultTableModel)tb_lop.getModel()).addRow(a);
            }
            txtnum.setText("Tổng: "+listlop.size());
        } catch (SQLException ex) {
            Logger.getLogger(FormNganh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_lop = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnum = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtmalop = new javax.swing.JTextField();
        txttenlop = new javax.swing.JTextField();
        cbnganh1 = new javax.swing.JComboBox<>();
        btnthem = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnlamlai = new javax.swing.JButton();
        btnthoat = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtsl = new javax.swing.JTextField();
        txtkhoa1 = new javax.swing.JTextField();
        btnaddnienkhoa = new javax.swing.JButton();
        cb_khoa2 = new javax.swing.JComboBox<>();
        cb_nganh2 = new javax.swing.JComboBox<>();
        btntim = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(" Lớp");
        setResizable(false);

        tb_lop.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_lop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_lopMouseClicked(evt);
            }
        });
        tb_lop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_lopKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_lop);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Khóa");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ngành");

        txtnum.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtnum.setText("Tổng: 0");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã lớp");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngành");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tên lớp");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Khóa");

        txtmalop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txttenlop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbnganh1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnthem.setBackground(new java.awt.Color(153, 0, 153));
        btnthem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnthem.setForeground(new java.awt.Color(255, 255, 255));
        btnthem.setText("Thêm");
        btnthem.setBorderPainted(false);
        btnthem.setFocusPainted(false);
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnxoa.setBackground(new java.awt.Color(51, 255, 255));
        btnxoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnxoa.setForeground(new java.awt.Color(51, 0, 51));
        btnxoa.setText("Xóa");
        btnxoa.setBorderPainted(false);
        btnxoa.setFocusPainted(false);
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnsua.setBackground(new java.awt.Color(0, 204, 153));
        btnsua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnsua.setForeground(new java.awt.Color(255, 255, 255));
        btnsua.setText("Sửa");
        btnsua.setBorderPainted(false);
        btnsua.setFocusPainted(false);
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnlamlai.setBackground(new java.awt.Color(153, 102, 255));
        btnlamlai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnlamlai.setForeground(new java.awt.Color(255, 255, 255));
        btnlamlai.setText("Làm lại");
        btnlamlai.setBorderPainted(false);
        btnlamlai.setFocusPainted(false);
        btnlamlai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlamlaiActionPerformed(evt);
            }
        });

        btnthoat.setBackground(new java.awt.Color(0, 0, 0));
        btnthoat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnthoat.setForeground(new java.awt.Color(255, 255, 255));
        btnthoat.setText("Thoát");
        btnthoat.setBorderPainted(false);
        btnthoat.setFocusPainted(false);
        btnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Số lượng");

        txtsl.setText("0");

        txtkhoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkhoa1ActionPerformed(evt);
            }
        });

        btnaddnienkhoa.setBackground(new java.awt.Color(0, 153, 0));
        btnaddnienkhoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnaddnienkhoa.setText("thêm niên khóa");
        btnaddnienkhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddnienkhoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmalop)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtkhoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtsl, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addComponent(txttenlop)
                    .addComponent(cbnganh1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnthem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnxoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnlamlai)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnthoat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnaddnienkhoa)
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtmalop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txttenlop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txtsl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtkhoa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbnganh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnxoa)
                    .addComponent(btnsua)
                    .addComponent(btnlamlai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthoat)
                    .addComponent(btnaddnienkhoa))
                .addContainerGap())
        );

        cb_khoa2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_khoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_khoa2ActionPerformed(evt);
            }
        });

        cb_nganh2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btntim.setBackground(new java.awt.Color(0, 255, 0));
        btntim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btntim.setText("Tìm");
        btntim.setBorderPainted(false);
        btntim.setFocusPainted(false);
        btntim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_khoa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_nganh2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btntim, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_khoa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(cb_nganh2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btntim))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnum)
                .addGap(99, 99, 99))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed
        dispose();
    }//GEN-LAST:event_btnthoatActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        if(txtmalop.getText().equals("") || txttenlop.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Hãy nhập dữ liệu");
        else {
            try {
                String malop = txtmalop.getText();
                String tenlop = txttenlop.getText(); 
                String khoa = txtkhoa1.getText();
                String soluong = txtsl.getText();
                Nganh n = (Nganh) cbnganh1.getModel().getSelectedItem();
                String sql = "insert into lop values ('"+malop+"','"+tenlop+"','"+n.getManganh()+"','"+khoa+"','"+soluong+"')";
                int kq = CommonSql.iud_Sql(sql, con);
                if(kq>0) {      
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                    listlop.clear();
                    showTable("","");
                    txtmalop.setText("");
                    txtmalop.requestFocus();
                    txttenlop.setText("");
                } else { 
                    JOptionPane.showMessageDialog(null, "Thêm thất bại");
                }
            } catch (SQLException ex) {
                Logger.getLogger(FormNganh.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        if(txtmalop.getText().equals("") && txtmalop.getText().equals(""))
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
                    String malop = txtmalop.getText();
                    String tenlop = txttenlop.getText();                     
                    String sql = "delete from lop where malop = '"+malop+"' or tenlop = N'"+tenlop+"'";
                    int kq = CommonSql.iud_Sql(sql, con);
                    if(kq>0) { 
                        JOptionPane.showMessageDialog(null, "Xóa thành công");
                        listlop.clear();
                        showTable("","");
                        txtmalop.setText("");
                        txtmalop.requestFocus();
                        txttenlop.setText("");
                    } else { 
                        JOptionPane.showMessageDialog(null, "Xóa thất bại");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FormNganh.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }   
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        if(txtmalop.getText().equals("") || txttenlop.getText().equals("") || txtsl.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Hãy nhập dữ liệu");
        else {
            try {               
                String malop = txtmalop.getText();
                String tenlop = txttenlop.getText(); 
                String khoa = txtkhoa1.getText();
                String soluong = txtsl.getText();
                Nganh n = (Nganh) cbnganh1.getModel().getSelectedItem();
                String test = "select count(masv) as sl from sinhvien where malop = '"+malop+"'";
                ResultSet rs = CommonSql.querySlect(test, con);
                if(rs.next()) {
                    String s = rs.getString("sl");
                    if(!(s.equals(soluong))) {
                        JOptionPane.showMessageDialog(null, "không thể cập nhật vì số lượng SV không trùng khớp với dữ liệu của lớp.");
                    }
                    else {
                        String sql = "update lop set tenlop = N'"+tenlop+"', khoa = '"+khoa+"', manganh = '"+n.getManganh()+"', soluongsv = "+s+" where malop = '"+malop+"'";
                        int kq = CommonSql.iud_Sql(sql, con);
                        if(kq>0) {      
                            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                            listlop.clear();
                            showTable("","");
                        } else { 
                            JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
                        }
                    }                    
                }
                else {
                    System.out.print("Đếm sinh viên không được");
                }            
            } catch (SQLException ex) {
                Logger.getLogger(FormNganh.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void tb_lopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_lopMouseClicked
        int row = tb_lop.getSelectedRow();
        txtmalop.setText(listlop.get(row).getMalop());
        txttenlop.setText(listlop.get(row).getTenlop());
        txtsl.setText(listlop.get(row).getSoluong());
        txtkhoa1.setText(listlop.get(row).getKhoa());
        cbnganh1.getModel().setSelectedItem(listlop.get(row).getNganh());
    }//GEN-LAST:event_tb_lopMouseClicked

    private void tb_lopKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_lopKeyReleased
        int row = tb_lop.getSelectedRow();
        txtmalop.setText(listlop.get(row).getMalop());
        txttenlop.setText(listlop.get(row).getTenlop());
        txtsl.setText(listlop.get(row).getSoluong());
        txtkhoa1.setText(listlop.get(row).getKhoa());
        cbnganh1.getModel().setSelectedItem(listlop.get(row).getNganh());
    }//GEN-LAST:event_tb_lopKeyReleased

    private void btntimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimActionPerformed
        listlop.clear();       
        String k = "", m = "";
        Nganh n;
        if(cb_khoa2.getSelectedIndex()>0) 
            k = cb_khoa2.getSelectedItem().toString();
        if(cb_nganh2.getSelectedIndex()>0) {
            n = (Nganh) cb_nganh2.getModel().getSelectedItem();
            m = n.getManganh();
        }
        showTable(m,k);
    }//GEN-LAST:event_btntimActionPerformed

    private void btnlamlaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlamlaiActionPerformed
        txtmalop.setText("");
        txtmalop.requestFocus();
        txttenlop.setText("");
        txtsl.setText("0");       
    }//GEN-LAST:event_btnlamlaiActionPerformed

    private void cb_khoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_khoa2ActionPerformed
       
    }//GEN-LAST:event_cb_khoa2ActionPerformed

    private void txtkhoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkhoa1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtkhoa1ActionPerformed

    private void btnaddnienkhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddnienkhoaActionPerformed
        FormNienKhoa nk = new FormNienKhoa();
        nk.setVisible(true);
    }//GEN-LAST:event_btnaddnienkhoaActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FormClass().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddnienkhoa;
    private javax.swing.JButton btnlamlai;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnthoat;
    private javax.swing.JButton btntim;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<com.mycompany.quanlysinhvien.model.Nienkhoa> cb_khoa2;
    private javax.swing.JComboBox<Nganh> cb_nganh2;
    private javax.swing.JComboBox<Nganh> cbnganh1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_lop;
    private javax.swing.JTextField txtkhoa1;
    private javax.swing.JTextField txtmalop;
    private javax.swing.JLabel txtnum;
    private javax.swing.JTextField txtsl;
    private javax.swing.JTextField txttenlop;
    // End of variables declaration//GEN-END:variables
}
