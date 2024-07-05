/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.buoi3.model;

/**
 *
 * @author ADMIN
 */
public class Quyen {
    private int idq;
    private String nameq;

    public Quyen() {
    }

    public Quyen(int idq, String nameq) {
        this.idq = idq;
        this.nameq = nameq;
    }

   

    public int getIdg() {
        return idq;
    }

    public void setIdg(int idg) {
        this.idq = idg;
    }

    public String getNameq() {
        return nameq;
    }

    public void setNameq(String nameq) {
        this.nameq = nameq;
    }

    @Override
    public String toString() {
        return "idq =" + idq + ", " + nameq  ;
    }  
        
}
