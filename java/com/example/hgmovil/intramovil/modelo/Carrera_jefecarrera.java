package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Carrera_jefecarrera {
    public int CARRERA_ID;
    public int JEFECARRERA_ID;
    public int ID;

    public Carrera_jefecarrera(int carrera_id, int jefecarrera, int id) {
        this.CARRERA_ID = carrera_id;
        this.JEFECARRERA_ID = jefecarrera;
        this.ID = id;
    }

    public int getCARRERA_ID() {
        return CARRERA_ID;
    }

    public void setCARRERA_ID(int CARRERA_ID) {
        this.CARRERA_ID = CARRERA_ID;
    }

    public int getJEFECARRERA_ID() {
        return JEFECARRERA_ID;
    }

    public void setJEFECARRERA_ID(int JEFECARRERA_ID) {
        this.JEFECARRERA_ID = JEFECARRERA_ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

