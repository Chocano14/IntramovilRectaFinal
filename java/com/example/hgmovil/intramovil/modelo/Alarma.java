package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Alarma {
    public int Id;
    public char Asunto;
    public char Dia_Hora;

    public Alarma(int id, char asunto, char dia_hora) {
        this.Id = id;
        this.Asunto = asunto;
        this.Dia_Hora = dia_hora;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public char getAsunto() {
        return Asunto;
    }

    public void setAsunto(char asunto) {
        Asunto = asunto;
    }

    public char getDia_Hora() {
        return Dia_Hora;
    }

    public void setDia_Hora(char dia_Hora) {
        Dia_Hora = dia_Hora;
    }
}
