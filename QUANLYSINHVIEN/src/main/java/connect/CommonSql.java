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

public class CommonSql {
    public static ResultSet querySlect(String sql,Connection con) throws SQLException{
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rslt = stmt.executeQuery(sql);
        return rslt;        
    }
    public static int iud_Sql(String sql, Connection con) throws SQLException {
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        int kq = 0;
        try {
            kq = stmt.executeUpdate(sql);
        }
        catch(SQLException ex) {
            kq = 0;
        }
        finally {
//            con.close();
        }
        return kq;
    }
    public static void writeFile(String path,String u,String p,int q){
        try {
            try (FileWriter myWriter = new FileWriter(path)) {
                myWriter.write(u+";"+p+";"+q);
            }
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    public static String readFile(String path){
        try {
            File myObj = new File(path);
            String data;
            try (Scanner myReader = new Scanner(myObj)) {
                data = myReader.nextLine();
            }
            return data;
        } 
        catch (FileNotFoundException e) {
                return ";;0";    
        }    
    }
}
