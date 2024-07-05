
package com.mycompany.quanlysinhvien.model;

public class Lop {
    private String malop;
    private String tenlop;
    private Nganh nganh;
    private String khoa;
    private String soluong;

    @Override
    public String toString() {
        return "" + tenlop;
    }
    

    public Lop(String khoa) {
        this.khoa = khoa;
    }

    public Lop(String malop, String tenlop) {
        this.malop = malop;
        this.tenlop = tenlop;
    }
    
    public Lop(String malop, String tenlop, Nganh nganh, String khoa, String soluong) {
        this.malop = malop;
        this.tenlop = tenlop;
        this.nganh = nganh;
        this.khoa = khoa;
        this.soluong = soluong;
    }

    public Lop() {
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public Nganh getNganh() {
        return nganh;
    }

    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }
    
}
