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
public class TestModel1 {
    public static void main(String[] args) {
        NhanVien nv = new NhanVien();
        System.out.println("Manv: "+nv.getManv());
        System.out.println("Tên:"+nv.getTennv());
        System.out.println("giới tính:"+nv.isGt());
        System.out.println("số điện thoại:"+nv.getSodt());
        nv.setManv("210");
        nv.setTennv("danh");
        nv.setGt(true);
        nv.setSodt("123456789");
        System.out.println("Manv: "+nv.getManv());
        System.out.println("Tên:"+nv.getTennv());
        System.out.println("giới tính:"+nv.isGt());
        System.out.println("số điện thoại:"+nv.getSodt());
        //gọi hàm constructor
    }
}
