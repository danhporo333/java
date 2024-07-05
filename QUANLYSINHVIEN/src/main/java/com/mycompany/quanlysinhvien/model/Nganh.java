package com.mycompany.quanlysinhvien.model;

public class Nganh {
    private String manganh;
    private String tennganh;

    public Nganh(String manganh, String tennganh) {
        this.manganh = manganh;
        this.tennganh = tennganh;
    }

    public Nganh() {
    }

    @Override
    public String toString() {
        return ""+tennganh;
    }

    public String getManganh() {
        return manganh;
    }

    public void setManganh(String manganh) {
        this.manganh = manganh;
    }

    public String getTennganh() {
        return tennganh;
    }

    public void setTennganh(String tennganh) {
        this.tennganh = tennganh;
    }
    
}
