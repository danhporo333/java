/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class CommonSQL {
    public static ResultSet querySlect(String sql, Connection conn) throws SQLException{
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
         ResultSet rslt = stmt.executeQuery(sql);
         return rslt;
    }
    
    public static int insert_update_deleteSQL(String sql, Connection conn) throws SQLException{
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        int kq = 0;
            try {
                kq = stmt.executeUpdate(sql);
            } catch (SQLException e) {
                kq = 0;
            } finally {
                
            }
        return kq;
    }
    
    public static void writeFile(String path,String u,String p,int q){    
        try {
          FileWriter myWriter = new FileWriter(path);
          myWriter.write(u+";"+p+";"+q);
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }
    
     public static String readFile(String path){
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            myReader.close();
            return data;
        } catch (FileNotFoundException e) {
                return ";;0";
    
        }    
    }
}


