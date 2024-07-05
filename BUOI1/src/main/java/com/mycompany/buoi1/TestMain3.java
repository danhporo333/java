/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.buoi1;

import Common.Common;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class TestMain3 {
    public static void main(String[] args){
        try{
        Scanner in =new Scanner(System.in);
        System.out.println("Nhap a:");
        String hsa = in.nextLine();
        System.out.println("Nhap b:");
        String hsb = in.nextLine();
        //cải tiến
        System.out.println("Nhap dau (+:cong,-:tru,*:nhan,/:Chia,#:Nguyen,%:Du");
        String sign = in.next();
        int a=Integer.parseInt(hsa);
        int b=Integer.parseInt(hsb);
        
        String cong=Common.phepToan(a, b, sign.charAt(0));
        System.out.println(a+""+(sign.charAt(0))+b+"="+cong);
        }catch(Exception e){
            System.out.println("a và b phải là số");
     }
    }
}
