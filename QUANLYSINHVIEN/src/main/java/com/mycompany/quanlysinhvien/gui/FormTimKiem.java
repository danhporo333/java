package com.mycompany.quanlysinhvien.gui;
import com.mycompany.quanlysinhvien.model.Lop;
import com.mycompany.quanlysinhvien.model.Nganh;
import connect.CommonSql;
import connect.KetNoiSqlServer;
import constance.Constance;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormTimKiem extends javax.swing.JFrame {
    private final Connection con = KetNoiSqlServer.getConnection(Constance.DB_URL, Constance.USER_NAME, Constance.PASSWORD);
    public FormTimKiem() {
        initComponents();
        showComboboxLop();
        showComboboxKhoa();
        showComboboxNganh();
    }
    private void showComboboxLop() {
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
            Logger.getLogger(FormTimKiem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void showComboboxKhoa() {
        cbkhoa.addItem("K18");
        cbkhoa.addItem("K19");
        cbkhoa.addItem("K20");         
    }
    private void showComboboxNganh() {
        try { 
            String sql = """
                            SELECT manganh, tennganh
                            FROM nganh""";
            ResultSet rs = CommonSql.querySlect(sql, con);
            while(rs.next()) {
                String manganh = rs.getString("manganh");
                String tennganh = rs.getString("tennganh");                
                Nganh n = new Nganh(manganh, tennganh);
                cbnganh.addItem(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormTimKiem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void showTableLop(String s) {
        tblop.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {                       
                },
                new String [] {
                    "MSSV","Họ tên", "Ngày sinh", "Lớp", "Ngành", "Khóa", "Giới tính", "Email", "SĐT"
                }
            ));  
        try {       
            String sql;
            if(s.equals("all")) 
                sql = """
                        SELECT sinhvien.masv, sinhvien.tensv, sinhvien.gioitinh, sinhvien.ngaysinh, sinhvien.email, sinhvien.sodienthoai,lop.malop, lop.tenlop, lop.khoa, nganh.tennganh
                        FROM sinhvien INNER JOIN
                        lop ON sinhvien.malop = lop.malop INNER JOIN
                        nganh ON lop.manganh = nganh.manganh
                        where sinhvien.status = '1'""";
            else 
                sql = """
                        SELECT sinhvien.masv, sinhvien.tensv, sinhvien.gioitinh, sinhvien.ngaysinh, sinhvien.email, sinhvien.sodienthoai,lop.malop, lop.tenlop, lop.khoa, nganh.tennganh
                        FROM sinhvien INNER JOIN
                        lop ON sinhvien.malop = lop.malop INNER JOIN
                        nganh ON lop.manganh = nganh.manganh
                        where sinhvien.malop = '"""+s+"' and sinhvien.status = '1'";
                         
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
                String khoa = rs.getString("khoa");
                Lop lop = new Lop(malop, tenlop);
                String a[]=new String[]{masv, tensv, ns.toString(), lop.getTenlop(), tennganh, khoa, gioitinh, email, sdt};
                ((DefaultTableModel)tblop.getModel()).addRow(a);
            }                                      
            tong1.setText("Tổng: "+tblop.getRowCount());
        } catch (SQLException ex) {
            Logger.getLogger(FormTimKiem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showTableKhoa(String s) {
        tbkhoa.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {                       
                },
                new String [] {
                    "MSSV","Họ tên", "Ngày sinh", "Lớp", "Ngành", "Khóa", "Giới tính", "Email", "SĐT"
                }
            ));  
        try {       
            String sql;
            if(s.equals("all")) 
                sql = """
                        SELECT sinhvien.masv, sinhvien.tensv, sinhvien.gioitinh, sinhvien.ngaysinh, sinhvien.email, sinhvien.sodienthoai,lop.malop, lop.tenlop, lop.khoa, nganh.tennganh
                        FROM sinhvien INNER JOIN
                        lop ON sinhvien.malop = lop.malop INNER JOIN
                        nganh ON lop.manganh = nganh.manganh
                        where sinhvien.status = '1'""";
            else 
                sql = """
                        SELECT sinhvien.masv, sinhvien.tensv, sinhvien.gioitinh, sinhvien.ngaysinh, sinhvien.email, sinhvien.sodienthoai,lop.malop, lop.tenlop, lop.khoa, nganh.tennganh
                        FROM sinhvien INNER JOIN
                        lop ON sinhvien.malop = lop.malop INNER JOIN
                        nganh ON lop.manganh = nganh.manganh
                        where lop.khoa = '"""+s+"' and sinhvien.status = '1'";
                         
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
                String khoa = rs.getString("khoa");
                Lop lop = new Lop(malop, tenlop);
                String a[]=new String[]{masv, tensv, ns.toString(), lop.getTenlop(), tennganh, khoa, gioitinh, email, sdt};
                ((DefaultTableModel)tbkhoa.getModel()).addRow(a);
            }                                      
            tong2.setText("Tổng: "+tbkhoa.getRowCount());
        } catch (SQLException ex) {
            Logger.getLogger(FormTimKiem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showTableNganh(String s) {
        tbnganh.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {                       
                },
                new String [] {
                    "MSSV","Họ tên", "Ngày sinh", "Lớp", "Ngành", "Khóa", "Giới tính", "Email", "SĐT"
                }
            ));  
        try {       
            String sql;
            if(s.equals("all")) 
                sql = """
                        SELECT sinhvien.masv, sinhvien.tensv, sinhvien.gioitinh, sinhvien.ngaysinh, sinhvien.email, sinhvien.sodienthoai,lop.malop, lop.tenlop, lop.khoa, nganh.tennganh
                        FROM sinhvien INNER JOIN
                        lop ON sinhvien.malop = lop.malop INNER JOIN
                        nganh ON lop.manganh = nganh.manganh
                        where sinhvien.status = '1'""";
            else 
                sql = """
                        SELECT sinhvien.masv, sinhvien.tensv, sinhvien.gioitinh, sinhvien.ngaysinh, sinhvien.email, sinhvien.sodienthoai,lop.malop, lop.tenlop, lop.khoa, nganh.tennganh
                        FROM sinhvien INNER JOIN
                        lop ON sinhvien.malop = lop.malop INNER JOIN
                        nganh ON lop.manganh = nganh.manganh
                        where lop.manganh = '"""+s+"' and sinhvien.status = '1'";
                         
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
                String khoa = rs.getString("khoa");
                Lop lop = new Lop(malop, tenlop);
                String a[]=new String[]{masv, tensv, ns.toString(), lop.getTenlop(), tennganh, khoa, gioitinh, email, sdt};
                ((DefaultTableModel)tbnganh.getModel()).addRow(a);
            }                                      
            tong3.setText("Tổng: "+tbnganh.getRowCount());
        } catch (SQLException ex) {
            Logger.getLogger(FormTimKiem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chonfile = new javax.swing.JFileChooser();
        tab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblop = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cblop = new javax.swing.JComboBox<>();
        tong1 = new javax.swing.JLabel();
        btnexcel1 = new javax.swing.JButton();
        btnxemtatca1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbkhoa = new javax.swing.JTable();
        btnexcel2 = new javax.swing.JButton();
        tong2 = new javax.swing.JLabel();
        cbkhoa = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnxemtatca2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbnganh = new javax.swing.JTable();
        btnexcel3 = new javax.swing.JButton();
        tong3 = new javax.swing.JLabel();
        cbnganh = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnxemtatca3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtfile = new java.awt.TextArea();
        jLabel2 = new javax.swing.JLabel();
        mofile = new javax.swing.JButton();
        ghifile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tìm sinh viên");
        setResizable(false);

        tab.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabFocusGained(evt);
            }
        });
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabMouseReleased(evt);
            }
        });

        tblop.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblop);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Chọn lớp");

        cblop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cblop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cblopItemStateChanged(evt);
            }
        });
        cblop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cblopKeyReleased(evt);
            }
        });

        tong1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tong1.setText("Tổng: 0");

        btnexcel1.setBackground(new java.awt.Color(102, 102, 255));
        btnexcel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnexcel1.setForeground(new java.awt.Color(255, 255, 255));
        btnexcel1.setText("Xuất File Excel");
        btnexcel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcel1ActionPerformed(evt);
            }
        });

        btnxemtatca1.setBackground(new java.awt.Color(0, 255, 255));
        btnxemtatca1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnxemtatca1.setText("XEM TẤT CẢ");
        btnxemtatca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxemtatca1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cblop, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tong1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnexcel1)
                        .addGap(18, 18, 18)
                        .addComponent(btnxemtatca1)
                        .addGap(0, 366, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cblop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tong1)
                    .addComponent(btnexcel1)
                    .addComponent(btnxemtatca1))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab.addTab("Tìm theo lớp", jPanel1);

        tbkhoa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tbkhoa);

        btnexcel2.setBackground(new java.awt.Color(102, 102, 255));
        btnexcel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnexcel2.setText("Xuất File Excel");
        btnexcel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcel2ActionPerformed(evt);
            }
        });

        tong2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tong2.setText("Tổng: 0");

        cbkhoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbkhoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbkhoaItemStateChanged(evt);
            }
        });
        cbkhoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbkhoaKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Chọn khóa");

        btnxemtatca2.setBackground(new java.awt.Color(102, 255, 255));
        btnxemtatca2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnxemtatca2.setForeground(new java.awt.Color(255, 255, 255));
        btnxemtatca2.setText("XEM TẤT CẢ");
        btnxemtatca2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxemtatca2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbkhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tong2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnexcel2)
                        .addGap(18, 18, 18)
                        .addComponent(btnxemtatca2)
                        .addGap(0, 366, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbkhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tong2)
                    .addComponent(btnexcel2)
                    .addComponent(btnxemtatca2))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab.addTab("Tìm theo khóa", jPanel2);

        tbnganh.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tbnganh);

        btnexcel3.setBackground(new java.awt.Color(255, 51, 51));
        btnexcel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnexcel3.setForeground(new java.awt.Color(255, 255, 255));
        btnexcel3.setText("Xuất File Excel");
        btnexcel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcel3ActionPerformed(evt);
            }
        });

        tong3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tong3.setText("Tổng: 0");

        cbnganh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbnganh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbnganhItemStateChanged(evt);
            }
        });
        cbnganh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbnganhKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Chọn ngành");

        btnxemtatca3.setBackground(new java.awt.Color(102, 102, 255));
        btnxemtatca3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnxemtatca3.setForeground(new java.awt.Color(255, 255, 255));
        btnxemtatca3.setText("XEM TẤT CẢ");
        btnxemtatca3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxemtatca3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbnganh, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tong3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnexcel3)
                        .addGap(18, 18, 18)
                        .addComponent(btnxemtatca3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbnganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tong3)
                    .addComponent(btnexcel3)
                    .addComponent(btnxemtatca3))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab.addTab("Tìm theo ngành", jPanel3);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nội dung");

        mofile.setBackground(new java.awt.Color(102, 255, 255));
        mofile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mofile.setText("Mở File");
        mofile.setBorderPainted(false);
        mofile.setFocusPainted(false);
        mofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mofileActionPerformed(evt);
            }
        });

        ghifile.setBackground(new java.awt.Color(102, 255, 255));
        ghifile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ghifile.setText("Ghi File");
        ghifile.setBorderPainted(false);
        ghifile.setFocusPainted(false);
        ghifile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ghifileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtfile, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mofile)
                        .addGap(18, 18, 18)
                        .addComponent(ghifile)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mofile)
                    .addComponent(ghifile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfile, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab.addTab("Đọc và ghi File", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabFocusGained
        if(tab.getSelectedIndex()==0) {
            showTableLop("all");
        }
        if(tab.getSelectedIndex()==1) {            
            showTableKhoa("all");
        }
        if(tab.getSelectedIndex()==2) {           
            showTableNganh("all");
        }  
    }//GEN-LAST:event_tabFocusGained
    
    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
        if(tab.getSelectedIndex()==0) {
            showTableLop("all");
        }
        if(tab.getSelectedIndex()==1) {            
            showTableKhoa("all");
        }
        if(tab.getSelectedIndex()==2) {           
            showTableNganh("all");
        }  
    }//GEN-LAST:event_tabMouseClicked

    // ----------------TAB TIM THEO LOP ---------------------//
    //                                                         //             
    //                                                         //         
    private void cblopItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cblopItemStateChanged
        Lop lop = (Lop) cblop.getSelectedItem();
        showTableLop(lop.getMalop());
    }//GEN-LAST:event_cblopItemStateChanged

    private void cblopKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cblopKeyReleased
        Lop lop = (Lop) cblop.getSelectedItem();
        showTableLop(lop.getMalop());
    }//GEN-LAST:event_cblopKeyReleased

    private void btnxemtatca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxemtatca1ActionPerformed
        showTableLop("all");
    }//GEN-LAST:event_btnxemtatca1ActionPerformed

    private void btnexcel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcel1ActionPerformed
        try {
            if(tblop.getRowCount()==0)
                JOptionPane.showMessageDialog(null, "Bảng dữ liệu trống");
            else {
                
                Path currentRelativePath = Paths.get("");
                String s = currentRelativePath.toAbsolutePath().toString();
                String path=s+"\\log\\sinhvientheolop.csv";
                com.opencsv.CSVWriter writer = new com.opencsv.CSVWriter(new FileWriter(path));
                String line1[] = {"MSSV", "Họ tên", "Ngày sinh", "Lớp", "Ngành", "Khóa"};
                writer.writeNext(line1);
                String dataexcel[] = new String[6];
                for(int i = 0; i<tblop.getRowCount(); i++) {
                    dataexcel[0] = tblop.getValueAt(i, 0).toString();
                    dataexcel[1] = tblop.getValueAt(i, 1).toString();
                    dataexcel[2] = tblop.getValueAt(i, 2).toString();
                    dataexcel[3] = tblop.getValueAt(i, 3).toString();
                    dataexcel[4] = tblop.getValueAt(i, 4).toString();
                    dataexcel[5] = tblop.getValueAt(i, 5).toString();
                    writer.writeNext(dataexcel);
                }
                writer.flush();
                System.out.println("Data entered");
                JOptionPane.showMessageDialog(null, "Xuất File thành công");
            }           
        } 
        catch (HeadlessException | IOException ex) {            
        }
    }//GEN-LAST:event_btnexcel1ActionPerformed

    // ----------------TAB TIM THEO KHOA ---------------------//
    //                                                         //             
    //                                                         //  
    private void cbkhoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbkhoaItemStateChanged
        showTableKhoa(cbkhoa.getSelectedItem().toString());
    }//GEN-LAST:event_cbkhoaItemStateChanged

    private void cbkhoaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbkhoaKeyReleased
        showTableKhoa(cbkhoa.getSelectedItem().toString());
    }//GEN-LAST:event_cbkhoaKeyReleased

    private void btnxemtatca2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxemtatca2ActionPerformed
        showTableKhoa("all");
    }//GEN-LAST:event_btnxemtatca2ActionPerformed

    private void btnexcel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcel2ActionPerformed
        try {
            if(tbkhoa.getRowCount()==0)
                JOptionPane.showMessageDialog(null, "Bảng dữ liệu trống");
            else {
                
                Path currentRelativePath = Paths.get("");
                String s = currentRelativePath.toAbsolutePath().toString();
                String path=s+"\\log\\sinhvientheokhoa.csv";
                com.opencsv.CSVWriter writer = new com.opencsv.CSVWriter(new FileWriter(path));
                String line1[] = {"MSSV", "Họ tên", "Ngày sinh", "Lớp", "Ngành", "Khóa"};
                writer.writeNext(line1);
                String dataexcel[] = new String[6];
                for(int i = 0; i<tbkhoa.getRowCount(); i++) {
                    dataexcel[0] = tbkhoa.getValueAt(i, 0).toString();
                    dataexcel[1] = tbkhoa.getValueAt(i, 1).toString();
                    dataexcel[2] = tbkhoa.getValueAt(i, 2).toString();
                    dataexcel[3] = tbkhoa.getValueAt(i, 3).toString();
                    dataexcel[4] = tbkhoa.getValueAt(i, 4).toString();
                    dataexcel[5] = tbkhoa.getValueAt(i, 5).toString();
                    writer.writeNext(dataexcel);
                }
                writer.flush();
                System.out.println("Data entered");
                JOptionPane.showMessageDialog(null, "Xuất File thành công");
            }           
        } 
        catch (HeadlessException | IOException ex) {            
        }
    }//GEN-LAST:event_btnexcel2ActionPerformed
    
    // ----------------TAB TIM THEO NGANH ---------------------//
    //                                                         //             
    //                                                         //
    private void cbnganhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbnganhItemStateChanged
        Nganh nganh = (Nganh) cbnganh.getSelectedItem();
        showTableNganh(nganh.getManganh());
    }//GEN-LAST:event_cbnganhItemStateChanged

    private void cbnganhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbnganhKeyReleased
        Nganh nganh = (Nganh) cbnganh.getSelectedItem();
        showTableNganh(nganh.getManganh());
    }//GEN-LAST:event_cbnganhKeyReleased

    private void btnxemtatca3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxemtatca3ActionPerformed
        showTableNganh("all");
    }//GEN-LAST:event_btnxemtatca3ActionPerformed

    private void btnexcel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcel3ActionPerformed
        try {
            if(tbnganh.getRowCount()==0)
                JOptionPane.showMessageDialog(null, "Bảng dữ liệu trống");
            else {
                
                Path currentRelativePath = Paths.get("");
                String s = currentRelativePath.toAbsolutePath().toString();
                String path=s+"\\log\\sinhvientheonganh.csv";
                com.opencsv.CSVWriter writer = new com.opencsv.CSVWriter(new FileWriter(path));
                String line1[] = {"MSSV", "Họ tên", "Ngày sinh", "Lớp", "Ngành", "Khóa"};
                writer.writeNext(line1);
                String dataexcel[] = new String[6];
                for(int i = 0; i<tbnganh.getRowCount(); i++) {
                    dataexcel[0] = tbnganh.getValueAt(i, 0).toString();
                    dataexcel[1] = tbnganh.getValueAt(i, 1).toString();
                    dataexcel[2] = tbnganh.getValueAt(i, 2).toString();
                    dataexcel[3] = tbnganh.getValueAt(i, 3).toString();
                    dataexcel[4] = tbnganh.getValueAt(i, 4).toString();
                    dataexcel[5] = tbnganh.getValueAt(i, 5).toString();
                    writer.writeNext(dataexcel);
                }
                writer.flush();
                System.out.println("Data entered");
                JOptionPane.showMessageDialog(null, "Xuất File thành công");
            }           
        } 
        catch (HeadlessException | IOException ex) {            
        }
    }//GEN-LAST:event_btnexcel3ActionPerformed

    private void tabMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseReleased
        if(tab.getSelectedIndex()==0) {
            showTableLop("all");
        }
        if(tab.getSelectedIndex()==1) {            
            showTableKhoa("all");
        }
        if(tab.getSelectedIndex()==2) {           
            showTableNganh("all");
        }  
    }//GEN-LAST:event_tabMouseReleased

    private void mofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mofileActionPerformed
        int result= chonfile.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION) {
            Path path = chonfile.getSelectedFile().toPath();
            try {
                String content = "";
                for(String s : Files.readAllLines(path, StandardCharsets.UTF_8))
                content += s+"\n";
                txtfile.setText(content);
            }
            catch(IOException e) {
            }
        }
    }//GEN-LAST:event_mofileActionPerformed

    private void ghifileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ghifileActionPerformed
        int result = chonfile.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION) {
            File target = chonfile.getSelectedFile();
            try {
                if(!target.exists()) {
                    target.createNewFile();
                }
                try (FileWriter fw = new FileWriter(target)) {
                    fw.write(txtfile.getText());
                }
            }
            catch(IOException e) {
            }
        }
    }//GEN-LAST:event_ghifileActionPerformed

    
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
            java.util.logging.Logger.getLogger(FormTimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTimKiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexcel1;
    private javax.swing.JButton btnexcel2;
    private javax.swing.JButton btnexcel3;
    private javax.swing.JButton btnxemtatca1;
    private javax.swing.JButton btnxemtatca2;
    private javax.swing.JButton btnxemtatca3;
    private javax.swing.JComboBox<String> cbkhoa;
    private javax.swing.JComboBox<Lop> cblop;
    private javax.swing.JComboBox<Nganh> cbnganh;
    private javax.swing.JFileChooser chonfile;
    private javax.swing.JButton ghifile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton mofile;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable tbkhoa;
    private javax.swing.JTable tblop;
    private javax.swing.JTable tbnganh;
    private javax.swing.JLabel tong1;
    private javax.swing.JLabel tong2;
    private javax.swing.JLabel tong3;
    private java.awt.TextArea txtfile;
    // End of variables declaration//GEN-END:variables
}
