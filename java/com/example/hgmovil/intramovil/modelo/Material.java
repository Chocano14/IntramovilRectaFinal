package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Material {
    public int ID;
    public char ARCHIVO;
    public int ASIGNATURA_ID;

    public Material(int id, char archivo, int asignatura_id) {
        this.ID = id;
        this.ARCHIVO = archivo;
        this.ASIGNATURA_ID = asignatura_id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public char getARCHIVO() {
        return ARCHIVO;
    }

    public void setARCHIVO(char ARCHIVO) {
        this.ARCHIVO = ARCHIVO;
    }

    public int getASIGNATURA_ID() {
        return ASIGNATURA_ID;
    }

    public void setASIGNATURA_ID(int ASIGNATURA_ID) {
        this.ASIGNATURA_ID = ASIGNATURA_ID;
    }
}
