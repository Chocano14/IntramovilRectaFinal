package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Asignatura {
    public int ID;
    public String NOMBRE;
    public int HORAS;

    public Asignatura(int id, String nombre, int horas) {
        this.ID = id;
        this.NOMBRE = nombre;
        this.HORAS = horas;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public int getHORAS() {
        return HORAS;
    }

    public void setHORAS(int HORAS) {
        this.HORAS = HORAS;
    }
}
