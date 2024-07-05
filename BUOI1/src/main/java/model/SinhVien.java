/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class SinhVien {
    public String masv;
    public String tensv;
    public boolean gt;
    public String sodt;

    public SinhVien() {
    }

    public SinhVien(String masv, String tensv, boolean gt, String sodt) {
        this.masv = masv;
        this.tensv = tensv;
        this.gt = gt;
        this.sodt = sodt;
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

    public boolean isGt() {
        return gt;
    }

    public void setGt(boolean gt) {
        this.gt = gt;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }
    
    public void XuatSV(){
        System.out.println("Manv: "+this.getMasv());
        System.out.println("Ten: "+this.getTensv());
        if(this.isGt()){
            System.out.println("Gioi tinh: Nam");
        }
        else {
            System.out.println("Gioi tinh: nu");
        }
        System.out.println("so dien thoai: "+this.getSodt());
    }

    @Override
    public String toString() {
        if(gt){
            return "Ma NV: "+masv+"\nTen NV: "+tensv+"\nGioi tinh: nam"+"\nSDT: "+sodt;
        }
        else {
            return "Ma NV: "+masv+"\nTen NV: "+tensv+"\nGioi tinh: nu"+"\nSDT: "+sodt;
        }
    }
    
    
}
