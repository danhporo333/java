
package com.mycompany.quanlysinhvien.model;

/**
 *
 * @author ADMIN
 */
public class Nienkhoa {
    private int idkhoa;
    private String makhoa;

    public Nienkhoa() {
    }

    public Nienkhoa(String makhoa) {
        this.makhoa = makhoa;
    }
    

    public Nienkhoa(int idkhoa, String makhoa) {
        this.idkhoa = idkhoa;
        this.makhoa = makhoa;
    }

    public int getIdkhoa() {
        return idkhoa;
    }

    public void setIdkhoa(int idkhoa) {
        this.idkhoa = idkhoa;
    }

    public String getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }

    @Override
    public String toString() {
        return "" +makhoa;
    }
    
    
}
