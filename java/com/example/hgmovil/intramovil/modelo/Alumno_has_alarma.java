package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Alumno_has_alarma {
    public char Alumno_Rut;
    public int Alarma_Id;
    public int Id;

    public Alumno_has_alarma(char alumno_rut, int alarma_Id, int Id) {
        this.Alumno_Rut = alumno_rut;
        this.Alarma_Id = alarma_Id;
        this.Id = Id;
    }

    public char getAlumno_Rut() {
        return Alumno_Rut;
    }

    public void setAlumno_Rut(char alumno_Rut) {
        Alumno_Rut = alumno_Rut;
    }

    public int getAlarma_Id() {
        return Alarma_Id;
    }

    public void setAlarma_Id(int alarma_Id) {
        Alarma_Id = alarma_Id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}

