package com.example.hgmovil.intramovil.modelo;

import java.util.Date;

/**
 * Created by pablo on 04-07-2016.
 */
public class Pago {
    public int ID;
    public char ESTADO;
    public Date FENCHAVENC;
    public char CONCEPTO;
    public int MONTO;
    public char ALUMNO_RUT;

    public Pago(int id, char estado, Date fenchavenc, char concepto, int monto, char alumno_rut) {
        this.ID = id;
        this.ESTADO = estado;
        this.FENCHAVENC = fenchavenc;
        this.CONCEPTO = concepto;
        this.MONTO = monto;
        this.ALUMNO_RUT = alumno_rut;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getFENCHAVENC() {
        return FENCHAVENC;
    }

    public void setFENCHAVENC(Date FENCHAVENC) {
        this.FENCHAVENC = FENCHAVENC;
    }

    public char getCONCEPTO() {
        return CONCEPTO;
    }

    public void setCONCEPTO(char CONCEPTO) {
        this.CONCEPTO = CONCEPTO;
    }

    public char getESTADO() {
        return ESTADO;
    }

    public void setESTADO(char ESTADO) {
        this.ESTADO = ESTADO;
    }

    public int getMONTO() {
        return MONTO;
    }

    public void setMONTO(int MONTO) {
        this.MONTO = MONTO;
    }

    public char getALUMNO_RUT() {
        return ALUMNO_RUT;
    }

    public void setALUMNO_RUT(char ALUMNO_RUT) {
        this.ALUMNO_RUT = ALUMNO_RUT;
    }
}
