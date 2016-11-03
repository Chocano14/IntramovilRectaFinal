package com.example.hgmovil.intramovil.modelo;

import java.sql.Time;

/**
 * Created by pablo on 04-07-2016.
 */
public class Horario {
    public int ID;
    public Time HORAINICIO;
    public Time HORAFIN;
    public int DIA_ID;

    public Horario(int id, Time horainicio, Time horafin, int dia_id) {
        this.ID = id;
        this.HORAINICIO = horainicio;
        this.HORAFIN = horafin;
        this.DIA_ID = dia_id;
    }

    public Time getHORAINICIO() {
        return HORAINICIO;
    }

    public void setHORAINICIO(Time HORAINICIO) {
        this.HORAINICIO = HORAINICIO;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Time getHORAFIN() {
        return HORAFIN;
    }

    public void setHORAFIN(Time HORAFIN) {
        this.HORAFIN = HORAFIN;
    }

    public int getDIA_ID() {
        return DIA_ID;
    }

    public void setDIA_ID(int DIA_ID) {
        this.DIA_ID = DIA_ID;
    }
}
