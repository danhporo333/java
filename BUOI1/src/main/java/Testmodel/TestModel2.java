/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Testmodel;

import model.NhanVien;

/**
 *
 * @author ADMIN
 */
public class TestModel2 {
    public static void main(String[] args) {
        NhanVien nv = new NhanVien("210","Danh",true,"0345715248");
        System.out.println("Manv: "+nv.getManv());
        System.out.println("Ten: "+nv.getTennv());
        System.out.println("gioi tinh: "+nv.isGt());
        System.out.println("so dien thoai: "+nv.getSodt());
        nv.setTennv("Dung");
        System.out.println("Manv: "+nv.getManv());
        System.out.println("Ten: "+nv.getTennv());
        System.out.println("gioi tinh: "+nv.isGt());
        System.out.println("so dien thoai: "+nv.getSodt());
    }
}
