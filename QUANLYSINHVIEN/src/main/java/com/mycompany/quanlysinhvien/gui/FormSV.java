
package com.mycompany.quanlysinhvien.gui;

import com.mycompany.quanlysinhvien.model.Lop;
import com.mycompany.quanlysinhvien.model.SinhVien;
import common.Common;
import connect.CommonSql;
import connect.KetNoiSqlServer;
import constance.Constance;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class FormSV extends javax.swing.JFrame {

    private final Connection con = KetNoiSqlServer.getConnection(Constance.DB_URL, Constance.USER_NAME, Constance.PASSWORD);
    ArrayList<SinhVien> listsv;
    public FormSV() {
        initComponents();
        listsv = new ArrayList<>();
        showCombobox();
        showTable("");
    }
    private void showCombobox() {
        try { 
            String sql = """
                         SELECT malop, tenlop
                         FROM lop""";
            ResultSet rs = CommonSql.querySlect(sql, con);
            while(rs.next()) {
                String malop = rs.getString("malop");
                String tenlop = rs.getString("tenlop");
                cblop.addItem(new Lop(malop, tenlop));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showTable(String s) {
        try {           
            String sql = """
                         SELECT sinhvien.masv, sinhvien.tensv, sinhvien.gioitinh, sinhvien.ngaysinh, sinhvien.email, sinhvien.sodienthoai,lop.malop, lop.tenlop, nganh.tennganh
                         FROM sinhvien INNER JOIN
                         lop ON sinhvien.malop = lop.malop INNER JOIN
                         nganh ON lop.manganh = nganh.manganh
                         where (masv like '%"""+s+"%' or tensv like '%"+s+"%') and sinhvien.status = '1'";
                         
            ResultSet rs = CommonSql.querySlect(sql, con);
            while(rs.next()) {
                String masv = rs.getString("masv");
                String tensv = rs.getString("tensv");
                String gioitinh = rs.getString("gioitinh");
                Date ns = rs.getDate("ngaysinh");
                String email = rs.getString("email");
                String sdt = rs.getString("sodienthoai");
                String malop = rs.getString("malop");
                String tenlop = rs.getString("tenlop");
                String tennganh = rs.getString("tennganh");
                listsv.add(new SinhVien(masv,tensv, gioitinh,ns,email,sdt,new Lop(malop, tenlop),tennganh));
            }
            tb_sv.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {                       
                },
                new String [] {
                    "MSSV","Họ tên", "Ngày sinh", "Lớp", "Ngành", "Giới tính", "Email", "SĐT"
                }
            ));  
            
            for(SinhVien sv : listsv){
                String a[]=new String[]{sv.getMasv(), sv.getTensv(), sv.getNgaysinh().toString(), sv.getLop().getTenlop(), sv.getTennganh(),sv.getGioitinh(),sv.getEmail(),sv.getSdt()};
                ((DefaultTableModel)tb_sv.getModel()).addRow(a);
            }
            txtnum.setText("Tổng: "+listsv.size());
        } catch (SQLException ex) {
            Logger.getLogger(FormNganh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_sv = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtmasv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txttensv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ngaysinh = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        rbnam = new javax.swing.JRadioButton();
        rbnu = new javax.swing.JRadioButton();
        btnthem = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnlamlai = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cblop = new javax.swing.JComboBox<>();
        txtnum = new javax.swing.JLabel();
        txts = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnthoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thông tin sinh viên");
        setResizable(false);

        tb_sv.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_sv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_svMouseClicked(evt);
            }
        });
        tb_sv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_svKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_sv);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MSSV");

        txtmasv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Họ tên");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Điền thông tin sinh viên");

        txttensv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Giới tính");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ngày sinh");

        ngaysinh.setPreferredSize(new java.awt.Dimension(123, 25));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email");

        txtemail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Số điện thoại");

        txtsdt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        rbnam.setBackground(new java.awt.Color(153, 153, 255));
        btngroup.add(rbnam);
        rbnam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbnam.setForeground(new java.awt.Color(255, 255, 255));
        rbnam.setSelected(true);
        rbnam.setText("Nam");
        rbnam.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        rbnu.setBackground(new java.awt.Color(153, 153, 255));
        btngroup.add(rbnu);
        rbnu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbnu.setForeground(new java.awt.Color(255, 255, 255));
        rbnu.setText("Nữ");

        btnthem.setBackground(new java.awt.Color(102, 255, 102));
        btnthem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnthem.setText("Thêm");
        btnthem.setFocusPainted(false);
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnxoa.setBackground(new java.awt.Color(102, 255, 255));
        btnxoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnxoa.setText("Xóa");
        btnxoa.setFocusPainted(false);
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnsua.setBackground(new java.awt.Color(255, 0, 255));
        btnsua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnsua.setText("Sửa");
        btnsua.setFocusPainted(false);
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnlamlai.setBackground(new java.awt.Color(255, 255, 0));
        btnlamlai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnlamlai.setText("Làm lại");
        btnlamlai.setFocusPainted(false);
        btnlamlai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlamlaiActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Lớp");

        cblop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cblop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cblopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7))
                                    .addGap(21, 21, 21)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txttensv, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(rbnam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(rbnu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(cblop, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnthem)
                                .addGap(18, 18, 18)
                                .addComponent(btnxoa)
                                .addGap(18, 18, 18)
                                .addComponent(btnsua)
                                .addGap(18, 18, 18)
                                .addComponent(btnlamlai))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txttensv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rbnam)
                    .addComponent(rbnu))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cblop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnxoa)
                    .addComponent(btnsua)
                    .addComponent(btnlamlai))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        txtnum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtnum.setText("Tổng: 0");

        txts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Nhập thông tin để tìm");
        jLabel9.setToolTipText("");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txts, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnthoat))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnum)
                            .addComponent(btnthoat))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsKeyPressed
        String s = txts.getText();
        listsv.clear();
        showTable(s);
    }//GEN-LAST:event_txtsKeyPressed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        if(txtmasv.getText().equals("") || txttensv.getText().equals("") || txtsdt.getText().equals("") || txtemail.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Hãy nhập đầy đủ thông tin");
        }
        else if (!(Common.isTenDigitNumber(txtmasv.getText()))) {
            JOptionPane.showMessageDialog(null,"MSSV không hợp lệ");
        }
        else if (!(Common.isValidEmail(txtemail.getText()))) {
            JOptionPane.showMessageDialog(null,"Email không hợp lệ");
        }
        else if (!(Common.isTenDigitNumber(txtsdt.getText()))) {
            JOptionPane.showMessageDialog(null,"Số điện thoại không hợp lệ");
        }       
        else {       
            try {
                String masv = txtmasv.getText();
                String tensv = txttensv.getText();
                String email = txtemail.getText();
                String sdt = txtsdt.getText();
                java.sql.Date ns = new java.sql.Date(ngaysinh.getDate().getTime());
                Lop lop = (Lop) cblop.getModel().getSelectedItem();
                String gt = "Nam";
                if(rbnu.isSelected())
                    gt = "Nữ";
                String sql = "insert into sinhvien values ('"+masv+"',N'"+tensv+"', N'"+gt+"','"+ns+"','"+email+"','"+sdt+"','"+lop.getMalop()+"','1')";
                int kq = CommonSql.iud_Sql(sql, con);
                if(kq>0) {                    
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                    updateSoluongSVtang(lop.getMalop());
                    listsv.clear();
                    showTable("");
                    lamlai();
                } else { 
                    JOptionPane.showMessageDialog(null, "Thêm thất bại");
                }
            } catch (SQLException ex) {
                Logger.getLogger(FormSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        if(txtmasv.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Hãy nhập MSSV để xóa");
        }          
        else {               
            try {
                String masv = txtmasv.getText();                
                String sql = "update sinhvien set status = 0 where masv = '"+masv+"'";
                int kq = CommonSql.iud_Sql(sql, con);
                if(kq>0) {                    
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                    
                    xoaSV(masv);
                    listsv.clear();
                    showTable("");
                    lamlai();
                } else { 
                    JOptionPane.showMessageDialog(null, "Xóa thất bại");
                }
            } catch (SQLException ex) {
                Logger.getLogger(FormSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnxoaActionPerformed
    
    private void tb_svKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_svKeyReleased
        tbClick();    
    }//GEN-LAST:event_tb_svKeyReleased

    private void tb_svMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_svMouseClicked
        tbClick(); 
    }//GEN-LAST:event_tb_svMouseClicked
    private void tbClick() {
        int row = tb_sv.getSelectedRow();
        txtmasv.setText(listsv.get(row).getMasv());
        txttensv.setText(listsv.get(row).getTensv());
        txtemail.setText(listsv.get(row).getEmail());
        txtsdt.setText(listsv.get(row).getSdt());
        ngaysinh.setDate(listsv.get(row).getNgaysinh());
        cblop.getModel().setSelectedItem(listsv.get(row).getLop());
        String gt = listsv.get(row).getGioitinh();
        rbnu.setSelected(true);
        if(gt.equals("Nam"))
            rbnam.setSelected(true); 
    }
    private void lamlai(){
        txtmasv.setText("");
        txtmasv.requestFocus();
        txttensv.setText("");
        txtemail.setText("");
        txtsdt.setText("");
    }
    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        if(txtmasv.getText().equals("") || txttensv.getText().equals("") || txtsdt.getText().equals("") || txtemail.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Hãy nhập đầy đủ thông tin");
        }
        else if (!(Common.isTenDigitNumber(txtmasv.getText()))) {
            JOptionPane.showMessageDialog(null,"MSSV không hợp lệ");
        }
        else if (!(Common.isValidEmail(txtemail.getText()))) {
            JOptionPane.showMessageDialog(null,"Email không hợp lệ");
        }
        else if (!(Common.isTenDigitNumber(txtsdt.getText()))) {
            JOptionPane.showMessageDialog(null,"Số điện thoại không hợp lệ");
        }       
        else {    
            try {
                String masv = txtmasv.getText();
                String tensv = txttensv.getText();
                String email = txtemail.getText();
                String sdt = txtsdt.getText();
                Lop lop = (Lop) cblop.getModel().getSelectedItem();
                java.sql.Date ns = new java.sql.Date(ngaysinh.getDate().getTime());               
                String gt = "Nam";
                if(rbnu.isSelected())
                    gt = "Nữ";
                String s = "select malop from sinhvien where masv = '"+masv+"'";
                
                ResultSet rs = CommonSql.querySlect(s, con);               
                if(rs.next()) {
                    if(rs.getString("malop").equals(lop.getMalop())) {
                        String sql = "update sinhvien set tensv = N'"+tensv+"', gioitinh = N'"+gt+"', email = '"+email+"', sodienthoai = '"+sdt+"', ngaysinh = '"+ns+"' where masv = '"+masv+"'";
                        int kq = CommonSql.iud_Sql(sql, con);
                        if(kq>0) {                    
                            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                            listsv.clear();
                            showTable("");
                        }                                          
                        else { 
                            JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
                        }
                    }
                    else {
                        String sql = "update sinhvien set tensv = N'"+tensv+"', email = '"+email+"', sodienthoai = '"+sdt+"', gioitinh = N'"+gt+"', ngaysinh = '"+ns+"', malop = '"+lop.getMalop()+"' where masv = '"+masv+"'";
                        int kq = CommonSql.iud_Sql(sql, con);
                        if(kq>0) {                    
                            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                            updateSoluongSVgiam(rs.getString("malop"));
                            updateSoluongSVtang(lop.getMalop());
                            listsv.clear();
                            showTable("");
                        }                                          
                        else { 
                            JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy MSSV trùng khớp");
                }                                             
            } catch (SQLException ex) {
                Logger.getLogger(FormSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnlamlaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlamlaiActionPerformed
        lamlai();
    }//GEN-LAST:event_btnlamlaiActionPerformed

    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed
        dispose();
    }//GEN-LAST:event_btnthoatActionPerformed

    private void txtsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsKeyReleased
        String s = txts.getText();
        listsv.clear();
        showTable(s);
    }//GEN-LAST:event_txtsKeyReleased

    private void cblopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cblopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cblopActionPerformed
    private void xoaSV(String masv) {
        String malop = "";
        try {
            String sql = """
                         SELECT malop
                         FROM sinhvien
                         WHERE masv = '"""+masv+"'";
            ResultSet rs = CommonSql.querySlect(sql, con);
            if(rs.next()) {
                malop = rs.getString("malop");
            }                    
        } catch (SQLException ex) {
            Logger.getLogger(FormSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateSoluongSVgiam(malop);
    }
    private void updateSoluongSVgiam(String malop) {
        try {
            String sql = "select soluongsv from lop where malop = '"+malop+"'";
            ResultSet rs = CommonSql.querySlect(sql, con);
            if(rs.next()) {
                String soluong = rs.getString("soluongsv");
                update(malop,Integer.parseInt(soluong)-1);
            }                    
        } catch (SQLException ex) {
            Logger.getLogger(FormSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void updateSoluongSVtang(String malop) {
        try {
            String sql = "select soluongsv from lop where malop = '"+malop+"'";
            ResultSet rs = CommonSql.querySlect(sql, con);
            if(rs.next()) {
                String soluong = rs.getString("soluongsv");
                update(malop,Integer.parseInt(soluong)+1);
            }                    
        } catch (SQLException ex) {
            Logger.getLogger(FormSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void update(String malop, int soluong) {
        try {
            String sql = "update lop set soluongsv = '"+soluong+"' where malop = '"+malop+"'";
            CommonSql.iud_Sql(sql, con);                
        } catch (SQLException ex) {
            Logger.getLogger(FormSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
            java.util.logging.Logger.getLogger(FormSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btngroup;
    private javax.swing.JButton btnlamlai;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnthoat;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<Lop> cblop;
    private javax.swing.JLabel jLabel1;
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
    private com.toedter.calendar.JDateChooser ngaysinh;
    private javax.swing.JRadioButton rbnam;
    private javax.swing.JRadioButton rbnu;
    private javax.swing.JTable tb_sv;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtmasv;
    private javax.swing.JLabel txtnum;
    private javax.swing.JTextField txts;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txttensv;
    // End of variables declaration//GEN-END:variables
}
