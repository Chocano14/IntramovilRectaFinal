package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Carrera_asignatura {
    public int CARRERA_ID;
    public int ASIGNATURA_ID;
    public int ID;

    public Carrera_asignatura(int carrera_id, int asignatura_id, int id) {
        this.CARRERA_ID = carrera_id;
        this.ASIGNATURA_ID = asignatura_id;
        this.ID = id;
    }

    public int getCARRERA_ID() {
        return CARRERA_ID;
    }

    public void setCARRERA_ID(int CARRERA_ID) {
        this.CARRERA_ID = CARRERA_ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getASIGNATURA_ID() {
        return ASIGNATURA_ID;
    }

    public void setASIGNATURA_ID(int ASIGNATURA_ID) {
        this.ASIGNATURA_ID = ASIGNATURA_ID;
    }
}

