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
public class TestMain4 {
    public static void main(String[] args){
    try{
        Scanner in =new Scanner(System.in);
        System.out.println("Nhap a:");
        String hsa = in.nextLine();
        System.out.println("Nhap b:");
        String hsb = in.nextLine();
        float a= Float.parseFloat(hsa);
        float b= Float.parseFloat(hsb);
        String x = Common.PTB1(a, b);
        System.out.println(a+"x+"+b+"=0");
        System.out.println("x="+x);
        }catch(Exception e){
            System.out.println("a và b phải là số");
     }
    }
}
