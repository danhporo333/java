/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.buoi3.gui.nhoma;


import com.mycompany.buoi3.model.NhanVien;
import com.mycompany.buoi3.model.PhongBan;
import connect.CommonSQL;
import connect.ketnoiSQLsever;
import constance.Constance;
import java.awt.Image;
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
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class FrmPhongBan extends javax.swing.JFrame {
    Connection conn  = ketnoiSQLsever.getConnection(Constance.DB_URL, Constance.USER_NAME, Constance.PASSWORD);
    int flag =0;
    int pos = -1;
    ArrayList<PhongBan> list_pb;
    /**
     * Creates new form FrmPhongBan
     */
    public FrmPhongBan() throws SQLException {
         
        initComponents();
        ////////////////
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
            if(a[2].equals("2")){
                btnxoa.setVisible(false);
                btnsua.setVisible(false);
            }
            ///////////////////////////////
        tb_phongban.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {                       
                    },
                    new String [] {
                        "Mã PB","Tên Phòng Ban","Nhân viên quãn lý","Ngày nhận chức"
                    }
        ));
         conn  = ketnoiSQLsever.getConnection(Constance.DB_URL, Constance.USER_NAME, Constance.PASSWORD);
        if(conn!=null){
            txtconnect.setText("kết nối SQL thành công");
        } else {
            txtconnect.setText("kết nối không thành công");
        }
        showCombobox();
        list_pb = new ArrayList<>();
        showTableDataFormSQL("");
//        setIcon();
        ImageIcon icon = new ImageIcon(getClass().getResource("/resource/logo.png"));
        Image image = icon.getImage();
        setIconImage(image);
    }
//    private void setIcon(){
//        Path currentRelativePath = Paths.get("");
//        String s = currentRelativePath.toAbsolutePath().toString();
//        System.out.println("s"+s);
//        String path=s+"\\images\\logo.png";
//        System.out.println(""+path);
//        ImageIcon img=new ImageIcon(path);
//       // ImageIcon img=new ImageIcon("c:\\logo.png");
//        setIconImage(img.getImage());
//    }
    private void showCombobox(){
        String sql = "SELECT manv, honv, lotnv, tennv, gt, namsinh, mapb FROM nhanvien";
        try {
             ResultSet rs = CommonSQL.querySlect(sql, conn);
             while(rs.next()){
                String manv= rs.getString("manv");
                String honv= rs.getString("honv");
                String chulot= rs.getString("lotnv");
                String tennv= rs.getString("tennv");
                NhanVien nv=new NhanVien(manv,honv,chulot,tennv);
                cbnhanvien.addItem(nv);
            }
        } catch (SQLException e) {
             Logger.getLogger(FrmPhongBan.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void showTableDataFormSQL(String s){
        tb_phongban.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {                       
                    },
                    new String [] {
                        "Mã PB","Tên Phòng Ban","Nhân viên quãn lý","Ngày nhận chức"
                    }
        ));
        String sql = "SELECT phong.mapb, phong.tenpb, phong.trgpb, phong.nnc, nhanvien.manv, nhanvien.honv, nhanvien.lotnv, nhanvien.tennv "
                + "FROM nhanvien ,phong "
                + "WHERE nhanvien.manv = phong.trgpb AND phong.trgpb LIKE '%" + s + "%'";
        ResultSet rs;
        try {
            rs = CommonSQL.querySlect(sql, conn);
            while (rs.next()){
                String maphg= rs.getString("mapb");
                String tenpb= rs.getString("tenpb");
                Date ngaynhamchuc= rs.getDate("nnc");
                String manv= rs.getString("manv");
                String honv= rs.getString("honv");
                String chulot= rs.getString("lotnv");
                String tennv= rs.getString("tennv");
                NhanVien nv=new NhanVien(manv,honv,chulot,tennv);
                list_pb.add(new PhongBan(maphg,tenpb,ngaynhamchuc,nv));
            }
        } catch (Exception e) {
            Logger.getLogger(FrmPhongBan.class.getName()).log(Level.SEVERE, null, e);
        }
         for(PhongBan pb:list_pb){
            String a[]=new String[]{pb.getMapb(),pb.getTenpb(),pb.getNv().getManv()+" "+pb.getNv().getTennv(),pb.getNgaynhanchucDate().toString()};
            ((DefaultTableModel)tb_phongban.getModel()).addRow(a);
         }
           txtNum.setText(""+list_pb.size());
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
        txtmapb = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txttenpb = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnthem = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnluu = new javax.swing.JButton();
        btnlamlai = new javax.swing.JButton();
        txtngaynhamchuc = new com.toedter.calendar.JDateChooser();
        cbnhanvien = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtconnect = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txts = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_phongban = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtNum = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Điền Thông tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel1.setText("Mã Phòng Ban");

        jLabel2.setText("Tên Phòng Ban");

        jLabel3.setText("Trưởng Phòng");

        jLabel4.setText("Ngày Nhậm Chức");

        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnxoa.setText("xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnluu.setText("Lưu");
        btnluu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnluuActionPerformed(evt);
            }
        });

        btnlamlai.setText("Làm Lại");
        btnlamlai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlamlaiActionPerformed(evt);
            }
        });

        txtconnect.setText("lỗi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnthem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnxoa)
                                .addGap(18, 18, 18)
                                .addComponent(btnsua)
                                .addGap(18, 18, 18)
                                .addComponent(btnluu)
                                .addGap(18, 18, 18)
                                .addComponent(btnlamlai))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtmapb)
                                    .addComponent(txttenpb)
                                    .addComponent(txtngaynhamchuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbnhanvien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtconnect)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtmapb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txttenpb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtngaynhamchuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnxoa)
                    .addComponent(btnsua)
                    .addComponent(btnluu)
                    .addComponent(btnlamlai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(11, 11, 11)
                .addComponent(txtconnect)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 0, 0), new java.awt.Color(51, 0, 51), null, null));

        jLabel5.setText("Nhập Thông Tin Cần Tìm");

        txts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsActionPerformed(evt);
            }
        });
        txts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsKeyReleased(evt);
            }
        });

        jButton6.setText("Tìm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        tb_phongban.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_phongban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_phongbanMouseClicked(evt);
            }
        });
        tb_phongban.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_phongbanKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_phongban);

        jLabel6.setText("Tổng số phòng ban");

        txtNum.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txts, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNum))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        btnthem.setEnabled(false);
        btnsua.setEnabled(false);
        txtmapb.requestFocus();
        txtmapb.setText("");
        txttenpb.setText("");
        flag=1;
        cbnhanvien.setSelectedIndex(0);
        Date d = new Date();
        txtngaynhamchuc.setDate(d);
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        btnthem.setEnabled(false);
        btnsua.setEnabled(false);
        flag=2;
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnlamlaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlamlaiActionPerformed
        btnthem.setEnabled(true);
        btnsua.setEnabled(true);
        txtmapb.requestFocus();
        txtmapb.setText("");
        txttenpb.setText("");
        flag=0;
        Date d = new Date();
        txtngaynhamchuc.setDate(d);
    }//GEN-LAST:event_btnlamlaiActionPerformed

    private void btnluuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnluuActionPerformed
        String mapb =txtmapb.getText();
        String tenpb=txttenpb.getText();
        NhanVien nv = (NhanVien)cbnhanvien.getSelectedItem();
        java.sql.Date ngaynhamchuc = new java.sql.Date(txtngaynhamchuc.getDate().getTime());
//        String ngaynhanchuc = (PhongBan)txtngaynhamchuc.getSelectedItem();
        if (mapb.isEmpty() || tenpb.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
        return; 
    }
        if(flag==1){
           try { 
            list_pb.add(new PhongBan(mapb,tenpb,ngaynhamchuc,nv));
           //Đoạn lệnh để dữ liệu thêm vào Jtable
            String sql = "INSERT INTO phong values('"+mapb+"',N'"+tenpb+"','"+nv.getManv()+"','"+ngaynhamchuc+"')";
            
                int kq = CommonSQL.insert_update_deleteSQL(sql, conn);
                if(kq>0){
                    list_pb.clear();
                    showTableDataFormSQL("");
                } else {
                    JOptionPane.showMessageDialog(null, "thêm thất bại");
                }
//            String a[]=new String[]{mapb,tenpb,nv.getManv()+" "+nv.getHonv()+" "+nv.getHolot()+" "+nv.getTennv(),ngaynhamchuc.toString()};
//            ((DefaultTableModel)tb_phongban.getModel()).addRow(a);
//            txtNum.setText(""+list_pb.size());
            } catch (SQLException ex) {
                Logger.getLogger(FrmPhongBan.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (flag==2) {
//            list_pb.remove(pos);
//            showTable(list_pb);
//            JOptionPane.showMessageDialog(null, "Đang thực hiện thao tác sửa");
            try {
                 list_pb.add(new PhongBan(mapb,tenpb,ngaynhamchuc,nv));
                String sql = "update phong set tenpb=N'"+tenpb+"', trgpb='"+nv.getManv()+"', nnc='"+ngaynhamchuc+"' where mapb ='"+mapb+"'";
                int kq = CommonSQL.insert_update_deleteSQL(sql, conn);
                if(kq>0){
                    list_pb.clear();
                    showTableDataFormSQL("");
                } else {
                    JOptionPane.showMessageDialog(null, "sửa thất bại");
                }
            } catch (SQLException e) {
                Logger.getLogger(FrmPhongBan.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn thao tác");
        }
    }//GEN-LAST:event_btnluuActionPerformed
    
    private void showTable(ArrayList<PhongBan> list_pb){
         tb_phongban.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {                       
                    },
                    new String [] {
                        "Mã PB","Tên Phòng Ban","Nhân viên quãn lý","Ngày nhận chức"
                    }
            ));
            for(PhongBan pb:list_pb){
                String a[]=new String[]{pb.getMapb(),pb.getTenpb(),pb.getNv().getManv()+" "+pb.getNv().getTennv()+" "+pb.getNv().getHolot()+" "+pb.getNv().getTennv(),pb.getNgaynhanchucDate().toString()};
                ((DefaultTableModel)tb_phongban.getModel()).addRow(a);
            }
            txtNum.setText(""+list_pb.size());
    }
    
    private void tb_phongbanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_phongbanMouseClicked
        // TODO add your handling code here:
        int row = tb_phongban.getSelectedRow();
        System.err.println("row"+row+list_pb.get(row).getTenpb());
        txtmapb.setText(list_pb.get(row).getMapb());
        txttenpb.setText(list_pb.get(row).getTenpb());
        cbnhanvien.getModel().setSelectedItem(list_pb.get(row).getNv());
        txtngaynhamchuc.setDate(list_pb.get(row).getNgaynhanchucDate());
        btnsua.setEnabled(true);
        pos=row;
    }//GEN-LAST:event_tb_phongbanMouseClicked

    private void tb_phongbanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_phongbanKeyReleased
        int row = tb_phongban.getSelectedRow();
        pos=row;
        System.err.println("row"+row+list_pb.get(row).getTenpb());
        txtmapb.setText(list_pb.get(row).getMapb());
        txttenpb.setText(list_pb.get(row).getTenpb());
        cbnhanvien.getModel().setSelectedItem(list_pb.get(row).getNv());
        txtngaynhamchuc.setDate(list_pb.get(row).getNgaynhanchucDate());
        btnsua.setEnabled(true);
    }//GEN-LAST:event_tb_phongbanKeyReleased

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        String mapb = txtmapb.getText();
        String tenpb = txttenpb.getText();
        txtNum.setText(""+list_pb.size());
        String[] options={"Đồng ý","Không đồng ý"};
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("s"+s);
        String path=s+"\\images\\exit.png";
        int choose=JOptionPane.showOptionDialog(null,
                "Bạn có chắc xóa phòng ban" +tenpb+" không? ","Thông báo",
                JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, 
                new ImageIcon(path), options, options[0]);
        System.out.println(""+choose);
        try {
            if(choose==0){
//            for(PhongBan pb:list_pb){
//                if(pb.getMapb().equals(mapb)){
//                    list_pb.remove(pb);
//                    break;
//                }
//            }
//            showTable(list_pb);
            String sql =  "delete from phong where mapb='"+mapb+"'";
            int kq = CommonSQL.insert_update_deleteSQL(sql, conn);
            list_pb.clear();
            showTableDataFormSQL("");
        }else{
            JOptionPane.showMessageDialog(null, "xóa thất bại");
        }
        } catch (Exception e) {
            Logger.getLogger(FrmPhongBan.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String s = txts.getText();
            if (s.equals("")) {
                showTable(list_pb);
            }else {
                for(PhongBan pb:list_pb){
                    if(pb.getTenpb().equalsIgnoreCase(s) || pb.getMapb().equalsIgnoreCase(s)){
                    tb_phongban.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {                       
                    },
                    new String [] {
                        "Mã PB","Tên Phòng Ban","Nhân viên quãn lý","Ngày nhận chức"
                    }
            ));
                String a[]=new String[]{pb.getMapb(),pb.getTenpb(),pb.getNv().getManv()+" "+pb.getNv().getTennv()+" "+pb.getNv().getHolot()+" "+pb.getNv().getTennv(),pb.getNgaynhanchucDate().toString()};
                ((DefaultTableModel)tb_phongban.getModel()).addRow(a);
                }
              }
            }
            
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsActionPerformed
        
    }//GEN-LAST:event_txtsActionPerformed

    private void txtsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            String s=txts.getText();
            showTableDataFormSQL(s);
//            if(s.equals("")){
//                showTable(list_pb);
//            }else{
//              for(PhongBan pb:list_pb){
//                    if(pb.getTenpb().equalsIgnoreCase(s) || pb.getMapb().equalsIgnoreCase(s)){
//                         tb_phongban.setModel(new javax.swing.table.DefaultTableModel(
//                        new Object [][] {                       
//                        },
//                        new String [] {
//                            "Mã PB","Tên Phòng Ban","Nhân viên quãn lý","Ngày nhận chức"
//                        }
//                ));
//                         String a[]=new String[]{pb.getMapb(),pb.getTenpb(),pb.getNv().getManv()+" "+pb.getNv().getTennv()+" "+pb.getNv().getHolot()+" "+pb.getNv().getTennv(),pb.getNgaynhanchucDate().toString()};
//                    ((DefaultTableModel)tb_phongban.getModel()).addRow(a);
//                    }
//                }
//            }
            txtNum.setText(""+list_pb.size());
        }
    }//GEN-LAST:event_txtsKeyReleased

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
            java.util.logging.Logger.getLogger(FrmPhongBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPhongBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPhongBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPhongBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmPhongBan().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmPhongBan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlamlai;
    private javax.swing.JButton btnluu;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<NhanVien> cbnhanvien;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_phongban;
    private javax.swing.JLabel txtNum;
    private javax.swing.JLabel txtconnect;
    private javax.swing.JTextField txtmapb;
    private com.toedter.calendar.JDateChooser txtngaynhamchuc;
    private javax.swing.JTextField txts;
    private javax.swing.JTextField txttenpb;
    // End of variables declaration//GEN-END:variables
}
