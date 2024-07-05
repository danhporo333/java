
package com.mycompany.qlsv;

import com.mycompany.qlsv.gui.FromLogin;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;


public class QLSV {

    public static void main(String[] args) throws SQLException {
        FromLogin m = new FromLogin();
        Image iconImage = Toolkit.getDefaultToolkit().getImage(".\\images\\login.png");
        m.setIconImage(iconImage);
        m.setVisible(true);
    }
}
