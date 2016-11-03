package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Carrera {
    public int ID;
    public char NOMBRE;
    public int MONTOANUAL;

    public Carrera(int id, char nombre, int montoanual) {
        this.ID = id;
        this.NOMBRE = nombre;
        this.MONTOANUAL = montoanual;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMONTOANUAL() {
        return MONTOANUAL;
    }

    public void setMONTOANUAL(int MONTOANUAL) {
        this.MONTOANUAL = MONTOANUAL;
    }

    public char getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(char NOMBRE) {
        this.NOMBRE = NOMBRE;
    }
}
