package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Asistencia {
    public int ID;
    public int HORASASIST;
    public char ALUMNO_RUT;
    public int ALUMNO_HAS_SECCION_ID;

    public Asistencia(int id, int horasasit, char alumno_rut, int alumno_has_seccion_id) {
        this.ID = id;
        this.HORASASIST = horasasit;
        this.ALUMNO_RUT = alumno_rut;
        this.ALUMNO_HAS_SECCION_ID = alumno_has_seccion_id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getHORASASIST() {
        return HORASASIST;
    }

    public void setHORASASIST(int HORASASIST) {
        this.HORASASIST = HORASASIST;
    }

    public char getALUMNO_RUT() {
        return ALUMNO_RUT;
    }

    public void setALUMNO_RUT(char ALUMNO_RUT) {
        this.ALUMNO_RUT = ALUMNO_RUT;
    }

    public int getALUMNO_HAS_SECCION_ID() {
        return ALUMNO_HAS_SECCION_ID;
    }

    public void setALUMNO_HAS_SECCION_ID(int ALUMNO_HAS_SECCION_ID) {
        this.ALUMNO_HAS_SECCION_ID = ALUMNO_HAS_SECCION_ID;
    }
}
