/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class NhanVien {
    private String manv;
    private String tennv;
    private boolean gt;
    private String sodt;

    public NhanVien() {
    }

    public NhanVien(String manv, String tennv, boolean gt, String sodt) {
        this.manv = manv;
        this.tennv = tennv;
        this.gt = gt;
        this.sodt = sodt;
    }
    
    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
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
    //định nghĩa 1 hàm
    public void XuatNV(){
        System.out.println("Manv: "+this.getManv());
        System.out.println("Ten: "+this.getTennv());
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
            return "Ma NV: "+manv+"\nTen NV: "+tennv+"\nGioi tinh: nam"+"\nSDT: "+sodt;
        }
        else {
            return "Ma NV: "+manv+"\nTen NV: "+tennv+"\nGioi tinh: nu"+"\nSDT: "+sodt;
        }
    }
    
}
