/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC DELL
 */
public class KetNoiSqlServer {
    public static Connection getConnection(String dbURL, String userName, String password) {
            Connection con = null;
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(dbURL, userName, password);                
            } catch (ClassNotFoundException  ex ) {
                System.out.println("connect failure!"+ex.getMessage());
            } catch (SQLException ex) {
            Logger.getLogger(KetNoiSqlServer.class.getName()).log(Level.SEVERE, null, ex);
        }
            return con;
        }
}
