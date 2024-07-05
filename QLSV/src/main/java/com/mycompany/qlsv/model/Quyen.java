
package com.mycompany.qlsv.model;


public class Quyen {
    public int idq;
    public String nameq;

    public Quyen() {
    }

    public Quyen(int idq, String nameq) {
        this.idq = idq;
        this.nameq = nameq;
    }

    public int getIdq() {
        return idq;
    }

    public void setIdq(int idq) {
        this.idq = idq;
    }

    public String getNameq() {
        return nameq;
    }

    public void setNameq(String nameq) {
        this.nameq = nameq;
    }

    @Override
    public String toString() {
        return idq+ "  "+nameq;
    }
    
}
