/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.buoi3;

import connect.ketnoiSQLsever;
import constance.Constance;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class TestKetNoiSQL {
    public static void main(String[] args) throws SQLException {
        
        Connection conn  = ketnoiSQLsever.getConnection(Constance.DB_URL, Constance.USER_NAME, Constance.PASSWORD);
        if(conn!=null){
            System.out.println("ket noi thanh cong");
        } else {
            System.out.println("ket noi khong thanh cong");
        }
    }
}
