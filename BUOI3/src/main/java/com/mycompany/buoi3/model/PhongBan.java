/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.buoi3.model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class PhongBan {
    private String mapb;
    private String tenpb;
    private Date ngaynhanchucDate;
    private NhanVien nv;

    public PhongBan() {
    }

    public PhongBan(String mapb, String tenpb) {
        this.mapb = mapb;
        this.tenpb = tenpb;
    }

    public PhongBan(String mapb, String tenpb, Date ngaynhanchucDate, NhanVien nv) {
        this.mapb = mapb;
        this.tenpb = tenpb;
        this.ngaynhanchucDate = ngaynhanchucDate;
        this.nv = nv;
    }

    public String getMapb() {
        return mapb;
    }

    public void setMapb(String mapb) {
        this.mapb = mapb;
    }

    public String getTenpb() {
        return tenpb;
    }

    public void setTenpb(String tenpb) {
        this.tenpb = tenpb;
    }

    public Date getNgaynhanchucDate() {
        return ngaynhanchucDate;
    }

    public void setNgaynhanchucDate(Date ngaynhanchucDate) {
        this.ngaynhanchucDate = ngaynhanchucDate;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    @Override
    public String toString() {
        return mapb + " " + tenpb;
    }
    
    
}
