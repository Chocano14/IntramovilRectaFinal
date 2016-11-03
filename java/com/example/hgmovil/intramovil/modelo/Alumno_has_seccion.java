package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Alumno_has_seccion {
    public int ID;
    public int SECCION_ID;
    public char ALUMNO_RUT;

    public Alumno_has_seccion(int id, int seccion_id, char alumno_rut) {
        this.ID = id;
        this.SECCION_ID = seccion_id;
        this.ALUMNO_RUT = alumno_rut;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public char getALUMNO_RUT() {
        return ALUMNO_RUT;
    }

    public void setALUMNO_RUT(char ALUMNO_RUT) {
        this.ALUMNO_RUT = ALUMNO_RUT;
    }

    public int getSECCION_ID() {
        return SECCION_ID;
    }

    public void setSECCION_ID(int SECCION_ID) {
        this.SECCION_ID = SECCION_ID;
    }
}
