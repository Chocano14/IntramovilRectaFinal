package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Dia {
    public int ID;
    public char DIA_SEMANA;

    public Dia(int id, char dia_semana) {
        this.ID = id;
        this.DIA_SEMANA = dia_semana;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public char getDIA_SEMANA() {
        return DIA_SEMANA;
    }

    public void setDIA_SEMANA(char DIA_SEMANA) {
        this.DIA_SEMANA = DIA_SEMANA;
    }
}
