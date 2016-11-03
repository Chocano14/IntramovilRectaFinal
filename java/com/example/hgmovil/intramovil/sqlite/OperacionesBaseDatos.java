package com.example.hgmovil.intramovil.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hgmovil.intramovil.sqlite.BDIntraMovil;
import com.example.hgmovil.intramovil.modelo.Seccion;
import com.example.hgmovil.intramovil.modelo.Sala;
import com.example.hgmovil.intramovil.modelo.Pago;
import com.example.hgmovil.intramovil.modelo.Alarma;
import com.example.hgmovil.intramovil.modelo.Alumno;
import com.example.hgmovil.intramovil.modelo.Alumno_has_alarma;
import com.example.hgmovil.intramovil.modelo.Alumno_has_seccion;
import com.example.hgmovil.intramovil.modelo.Asignatura;
import com.example.hgmovil.intramovil.modelo.Asistencia;
import com.example.hgmovil.intramovil.modelo.Carrera;
import com.example.hgmovil.intramovil.modelo.Carrera_asignatura;
import com.example.hgmovil.intramovil.modelo.Carrera_jefecarrera;
import com.example.hgmovil.intramovil.modelo.Dia;
import com.example.hgmovil.intramovil.modelo.Docente;
import com.example.hgmovil.intramovil.modelo.Horario;
import com.example.hgmovil.intramovil.modelo.Horario_seccion;
import com.example.hgmovil.intramovil.modelo.Jefecarrera;
import com.example.hgmovil.intramovil.modelo.Material;
import com.example.hgmovil.intramovil.modelo.Nota;

/**
 * Created by pablo on 04-07-2016.
 */

public final class OperacionesBaseDatos {

    private static BDIntraMovil baseDatos;

    private static OperacionesBaseDatos instancia = new OperacionesBaseDatos();

    public OperacionesBaseDatos() {
    }

    public static OperacionesBaseDatos obtenerInstancia(Context contexto) {
        if (baseDatos == null) {
            baseDatos = new BDIntraMovil(contexto);
        }
        return instancia;
    }
}



