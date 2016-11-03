package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Seccion {
    public int ID;
    public int NUMERO;
    public int DOCENTE_ID;
    public int ASIGNATURA_ID;

    public Seccion(int id, int numero, int docente_id, int asignatura_id) {
        this.ID = id;
        this.NUMERO = numero;
        this.DOCENTE_ID = docente_id;
        this.ASIGNATURA_ID = asignatura_id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDOCENTE_ID() {
        return DOCENTE_ID;
    }

    public void setDOCENTE_ID(int DOCENTE_ID) {
        this.DOCENTE_ID = DOCENTE_ID;
    }

    public int getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(int NUMERO) {
        this.NUMERO = NUMERO;
    }

    public int getASIGNATURA_ID() {
        return ASIGNATURA_ID;
    }

    public void setASIGNATURA_ID(int ASIGNATURA_ID) {
        this.ASIGNATURA_ID = ASIGNATURA_ID;
    }
}
