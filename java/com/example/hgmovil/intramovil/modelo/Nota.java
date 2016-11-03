package com.example.hgmovil.intramovil.modelo;

import java.util.Date;

/**
 * Created by pablo on 04-07-2016.
 */
public class Nota {
    public int ID;
    public float NOTA;
    public int PONDERACION;
    public Date FECHA;
    public char ALUMNO_RUT;
    public int SECCION_ID;

    public Nota(int id, float nota, int ponderacion, Date fecha, char alumno_rut, int seccion_id) {
        this.ID = id;
        this.NOTA = nota;
        this.PONDERACION = ponderacion;
        this.FECHA = fecha;
        this.ALUMNO_RUT = alumno_rut;
        this.SECCION_ID = seccion_id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getNOTA() {
        return NOTA;
    }

    public void setNOTA(float NOTA) {
        this.NOTA = NOTA;
    }

    public int getPONDERACION() {
        return PONDERACION;
    }

    public void setPONDERACION(int PONDERACION) {
        this.PONDERACION = PONDERACION;
    }

    public Date getFECHA() {
        return FECHA;
    }

    public void setFECHA(Date FECHA) {
        this.FECHA = FECHA;
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
