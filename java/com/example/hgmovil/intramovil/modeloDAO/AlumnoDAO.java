package com.example.hgmovil.intramovil.modeloDAO;

import android.content.Context;
import android.database.Cursor;

import com.example.hgmovil.intramovil.sqlite.BDIntraMovil;

/**
 * Created by pablo on 06-07-2016.
 */
public class AlumnoDAO extends BDIntraMovil {
    public AlumnoDAO(Context context) {
        super(context);
    }

    public String searchPass(String rut) {
        db = this.getReadableDatabase();
        String query = "select Rut, Contraseña from alumno";
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "No encontrado";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);
                if (a.equals(rut)) {
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }
}

