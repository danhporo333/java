/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.buoi3.model;

/**
 *
 * @author ADMIN
 */
public class Account {
    private String username;
    private String password;
    private String fullname;
    private String gender;
    private Quyen q;

    public Account() {
    }

    public Account(String username, String fullname, String gender, Quyen q) {
        this.username = username;
        this.fullname = fullname;
        this.gender = gender;
        this.q = q;
    }

    public Account(String username, String password, String fullname, String gender, Quyen q) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.gender = gender;
        this.q = q;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Quyen getQ() {
        return q;
    }

    public void setQ(Quyen q) {
        this.q = q;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", fullname=" + fullname + ", gender=" + gender + ", q=" + q + '}';
    }
    
    
}
