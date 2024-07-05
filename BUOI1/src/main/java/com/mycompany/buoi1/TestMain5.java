/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.buoi1;

import static Common.Common.PTB2;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class TestMain5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueSolving = true;
        while (continueSolving) {
            try {
                System.out.print("Nhap a: ");
                float a = scanner.nextFloat();

                System.out.print("Nhap b: ");
                float b = scanner.nextFloat();

                System.out.print("Nhap c: ");
                float c = scanner.nextFloat();

                String result = PTB2(a, b, c);
                System.out.println(a + "x^2 + " + b + "x + " + c + " = 0");
                System.out.println("Ket qua: " + result);
            } catch (Exception e) {
                System.out.println("a, b và c phải là số");
                continue; // Bắt đầu lại vòng lặp
            }

            // Hỏi người dùng có muốn tiếp tục không
            System.out.print("Ban co muon tiep tuc khong? (yes/no): ");
            String userResponse = scanner.next();
            if (!userResponse.equalsIgnoreCase("yes")) {
                continueSolving = false;
            }
        }
        System.out.println("Chuong trinh ket thc.");
    }
}

