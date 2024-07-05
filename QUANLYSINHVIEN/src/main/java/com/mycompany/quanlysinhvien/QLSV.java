package com.mycompany.quanlysinhvien;

import com.mycompany.quanlysinhvien.gui.FormLogin;
import java.awt.Image;
import java.awt.Toolkit;

public class QLSV {

    public static void main(String[] args) {
        FormLogin fm = new FormLogin();
        Image iconImage = Toolkit.getDefaultToolkit().getImage(".\\images\\login.png");
        fm.setIconImage(iconImage);
        fm.setVisible(true);
    }
}
