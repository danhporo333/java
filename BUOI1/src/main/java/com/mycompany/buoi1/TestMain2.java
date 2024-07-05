/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.buoi1;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class TestMain2 {
    public static void main(String[] args){
        try{
            Scanner in = new Scanner(System.in);
        System.out.println("Nhap a:");
        String hsa = in.nextLine();
        System.out.println("Nhap b: ");
        String hsb = in.nextLine();
        int a = Integer.parseInt(hsa);
        int b = Integer.parseInt(hsb);
        int c=a+b;
        
        System.out.println("c="+c);
        System.out.println(a+"+"+b+"="+c);
        System.out.println(a+"-"+b+"="+(a-b));
        System.out.println(a+"*"+b+"="+(a*b));
        System.out.println(a+"/"+b+"="+((float)a/b));
        System.out.println(a+"//"+b+"="+(int)(a/b));
        System.out.println(a+"%"+b+"="+(int)(a%b));
        }catch(NumberFormatException e) {
            System.out.println("a va b phai la so");
        }
    }
}
