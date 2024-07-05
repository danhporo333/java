package com.mycompany.quanlysinhvien.model;

import java.sql.Date;

public class SinhVien {
    private String masv;
    private String tensv;
    private String gioitinh;
    private Date ngaysinh;
    private String email;
    private String sdt;
    private Lop lop;
    private String tennganh;
    @Override
    public String toString() {
        return masv + " " + tensv;
    }
     
    public SinhVien() {
    }
    
    public SinhVien(String masv, String tensv, String gioitinh, Date ngaysinh, String email, String sdt, Lop lop, String tennganh) {
        this.masv = masv;
        this.tensv = tensv;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.email = email;
        this.sdt = sdt;
        this.lop = lop;
        this.tennganh = tennganh;
    }

    public String getTennganh() {
        return tennganh;
    }

    public void setTennganh(String tennganh) {
        this.tennganh = tennganh;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }
    
    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
