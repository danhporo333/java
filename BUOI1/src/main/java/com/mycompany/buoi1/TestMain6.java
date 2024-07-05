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
public class TestMain6 {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Nhap X");
            String hsx = in.nextLine();
            System.out.println("Nhap n");
            String hsn = in.nextLine();
            float x=Float.parseFloat(hsx);
            int n= Integer.parseInt(hsn);
            String c = Common.xn(x,n);
            System.out.println(x+"^"+n+"="+c);
        } catch (Exception e) {
            System.out.println("loi");
        }
    }
}
