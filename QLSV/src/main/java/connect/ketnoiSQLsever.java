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
 * @author ADMIN
 */
public class ketnoiSQLsever {
    public static Connection getConnection(String dbURL, String userName, String password) throws SQLException {
            Connection conn = null;
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(dbURL, userName, password);
                System.out.println("connect successfully!");
            } catch (ClassNotFoundException  ex ) {
                System.out.println("connect failure!"+ex.getMessage());
            } catch (SQLException ex) {
            Logger.getLogger(ketnoiSQLsever.class.getName()).log(Level.SEVERE, null, ex);
        }
            return conn;
    }
}
