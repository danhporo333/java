/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Testmodel;

import java.util.ArrayList;
import model.GiaoVien;

/**
 *
 * @author ADMIN
 */
public class TestKeThua {
    public static void main(String[] args) {
        GiaoVien gv1 = new GiaoVien("001","An",true,20,"10/10/2024");
        GiaoVien gv2 = new GiaoVien("002","dung",true,21,"10/10/2024");
        gv1.setNamsinh(2000);
//        gv1.XuatGV();
//        System.out.println("*********************************************");
        ArrayList<GiaoVien> listgv = new ArrayList<>();
        listgv.add(gv1);
//        listgv.add(gv2);
//        System.out.println("xuat thong tin giao vien: ");
//        for (int i = 0;i<listgv.size();i++){
//            listgv.get(i).XuatGV();
//        }
//        listgv.remove(gv2);
//        System.out.println("xuat thong tin giao vien: ");
//        for (int i = 0;i<listgv.size();i++){
//            listgv.get(i).XuatGV();
//        }
        System.out.println("\n--------------\nXuat thong tin giao vien:Cách 2"+listgv.size());
        GiaoVien.XuatDS(listgv);
    }
}
