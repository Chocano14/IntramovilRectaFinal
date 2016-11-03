package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Jefecarrera {
    public int ID;
    public char NOMBRE;
    public char CORREO;

    public Jefecarrera(int id, char nombre, char correo) {
        this.ID = id;
        this.NOMBRE = nombre;
        this.CORREO = correo;
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

    public char getCORREO() {
        return CORREO;
    }

    public void setCORREO(char CORREO) {
        this.CORREO = CORREO;
    }
}
