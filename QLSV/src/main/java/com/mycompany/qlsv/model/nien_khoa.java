/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlsv.model;

/**
 *
 * @author ADMIN
 */
public class nien_khoa {
    private int idkhoa;
    private String tenkhoa;

    public nien_khoa() {
    }

    public nien_khoa(int idkhoa, String tenkhoa) {
        this.idkhoa = idkhoa;
        this.tenkhoa = tenkhoa;
    }

    public int getIdkhoa() {
        return idkhoa;
    }

    public void setIdkhoa(int idkhoa) {
        this.idkhoa = idkhoa;
    }

    public String getTenkhoa() {
        return tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }
    
    
}
