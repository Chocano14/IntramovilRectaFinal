package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Alumno {
    public String Rut;
    public String Nombre;
    public String Contraseña;
    public String Correo;
    public int CarerraID;

    public Alumno(String rut, String nombre, String contraseña, String correo, int carreraID) {

        this.Rut = rut;
        this.Nombre = nombre;
        this.Contraseña = contraseña;
        this.Correo = correo;
        this.CarerraID = carreraID;
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String rut) {
        Rut = rut;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public int getCarerraID() {
        return CarerraID;
    }

    public void setCarerraID(int carerraID) {
        CarerraID = carerraID;
    }
}
