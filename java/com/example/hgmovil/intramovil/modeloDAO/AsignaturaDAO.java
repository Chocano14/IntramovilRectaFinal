package com.example.hgmovil.intramovil.modeloDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.hgmovil.intramovil.modelo.Asignatura;
import com.example.hgmovil.intramovil.sqlite.BDIntraMovil;

import java.util.ArrayList;

/**
 * Created by pablo on 05-07-2016.
 */
public class AsignaturaDAO extends BDIntraMovil {

    String tabla = "asignatura";

    public AsignaturaDAO(Context context) {
        super(context);
    }

    public boolean insertar(String nombre, String horas) {
        ContentValues valores = new ContentValues();
        valores.put("Nombre", nombre);
        valores.put("Horas", horas);
        try {
            openDataBase();
            db.insert(tabla, null, valores);
            close();
            return true;
        } catch (Exception ex) {
            close();
            return false;
        }
    }

    public Asignatura buscar(int id) {
        Asignatura dev = null;
        try {

            openDataBase();
            String[] campos = {"Nombre"};
            Cursor c = db.query(tabla, campos, "Id=" + id, null, null, null, null, null);
            if (c != null) {
                c.moveToFirst();
            }
            dev = new Asignatura(id, c.getString(0), c.getInt(0));
            c.close();
            close();
        } catch (Exception ex) {
            close();
            return null;
        }
        return dev;
    }

    public ArrayList<String> listadoAsigxCarrera() {
        ArrayList<String> dev = null;
        try {
            openDataBase();
            dev = new ArrayList<String>();
            String query = "SELECT a.Nombre  FROM asignatura as a JOIN carrera_asignatura as ca ON   a.Id = ca.Asignatura_Id Where ca.Carrera_Id = \"1\";";
            Cursor c = db.rawQuery(query, null);
            if (c.moveToFirst()) {
                do {
                    String nombre = c.getString(0);
                    dev.add(nombre);
                } while (c.moveToNext());
            }
            c.close();
            close();

        } catch (Exception ex) {
            ex.printStackTrace();
            close();
            return null;
        }
        return dev;
    }
}

