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
public class TestModel3 {
    public static void main(String[] args) {
        NhanVien nv = new NhanVien("210","Danh",false,"0345715248");
        nv.setTennv("dung");
        nv.XuatNV();
    }
}
