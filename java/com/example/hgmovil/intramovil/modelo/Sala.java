package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Sala {
    public int ID;
    public char NOMBRE;
    public int PISO;

    public Sala(int id, char nombre, int piso) {
        this.ID = id;
        this.NOMBRE = nombre;
        this.PISO = piso;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public char getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(char NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public int getPISO() {
        return PISO;
    }

    public void setPISO(int PISO) {
        this.PISO = PISO;
    }
}
