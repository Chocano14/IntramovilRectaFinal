package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Horario_seccion {
    public int ID;
    public int HORARIO_ID;
    public int SECCION_ID;
    public int SALA_ID;

    public Horario_seccion(int id, int horario_id, int seccion_id, int sala_id) {
        this.ID = id;
        this.HORARIO_ID = horario_id;
        this.SECCION_ID = seccion_id;
        this.SALA_ID = sala_id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSECCION_ID() {
        return SECCION_ID;
    }

    public void setSECCION_ID(int SECCION_ID) {
        this.SECCION_ID = SECCION_ID;
    }

    public int getHORARIO_ID() {
        return HORARIO_ID;
    }

    public void setHORARIO_ID(int HORARIO_ID) {
        this.HORARIO_ID = HORARIO_ID;
    }

    public int getSALA_ID() {
        return SALA_ID;
    }

    public void setSALA_ID(int SALA_ID) {
        this.SALA_ID = SALA_ID;
    }
}
