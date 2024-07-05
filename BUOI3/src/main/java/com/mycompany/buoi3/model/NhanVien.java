/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.buoi3.model;

/**
 *
 * @author ADMIN
 */
public class NhanVien {
    private String manv;
    private String honv;
    private String holot;
    private String tennv;
    private String gt;
    private String sdt;
    private String ngaysinh;

    public NhanVien() {
    }

    

    public NhanVien(String manv, String honv, String holot, String tennv) {
        this.manv = manv;
        this.honv = honv;
        this.holot = holot;
        this.tennv = tennv;
    }



    public NhanVien(String manv, String honv, String holot, String tennv, String gt, String sdt, String ngaysinh) {
        this.manv = manv;
        this.honv = honv;
        this.holot = holot;
        this.tennv = tennv;
        this.gt = gt;
        this.sdt = sdt;
        this.ngaysinh = ngaysinh;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHonv() {
        return honv;
    }

    public void setHonv(String honv) {
        this.honv = honv;
    }

    public String getHolot() {
        return holot;
    }

    public void setHolot(String holot) {
        this.holot = holot;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    @Override
    public String toString() {
        return manv+ " " +honv+ " " +holot+ " " +tennv;
    }
    
}
