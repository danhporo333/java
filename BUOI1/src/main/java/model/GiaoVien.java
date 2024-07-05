/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class GiaoVien extends Person{
    private String magv;
    private String ngayvl;
    private int namsinh;

    public GiaoVien() {
    }

    public GiaoVien(String magv, String name, boolean gt, int tuoi, String ngayvl) {
        super(name, gt, tuoi);
        this.magv = magv;
        this.ngayvl = ngayvl;
    }

    public GiaoVien(String magv, String ngayvl, int namsinh, String name, boolean gt, int tuoi) {
        super(name, gt, tuoi);
        this.magv = magv;
        this.ngayvl = ngayvl;
        this.namsinh = namsinh;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    
    public String getMagv() {
        return magv;
    }

    public void setMagv(String magv) {
        this.magv = magv;
    }

    public String getNgayvl() {
        return ngayvl;
    }

    public void setNgayvl(String ngayvl) {
        this.ngayvl = ngayvl;
    }
    
    @Override
     public String toString() {
        return "Ma Gv: " + magv + "\nTen GV: " + name + "\nGioi Tinh: " + (this.gt ? "Nam" : "Nu") + "\nTuoi: " + (2024 - namsinh + 1);
    }
     
     public void XuatGV(){
        System.out.println("Manv: "+this.getMagv());
        System.out.println("Ten: "+this.getName());
        if(this.isGt()){
            System.out.println("Gioi tinh: Nam");
        }
        else {
            System.out.println("Gioi tinh: nu");
        }
         System.out.println("Tuoi: "+(2024 - namsinh + 1));
        System.out.println("nam sinh: "+this.getNamsinh());
        System.out.println("ngay vao lam: "+this.getNgayvl());
    }
     public static void XuatDS(ArrayList<GiaoVien> listgv){
         for (int i = 0;i<listgv.size();i++){
            listgv.get(i).XuatGV();
        }
     }
}
