package com.example.hgmovil.intramovil.view;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hgmovil.intramovil.R;
import com.example.hgmovil.intramovil.sqlite.BDIntraMovil;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MenuAsist extends AppCompatActivity implements View.OnClickListener {
    private Spinner spnenr;
    private String ry, nm;
    private ArrayAdapter adapter;
    private TextView totalhAsig, totalhAsistidas, porcentaje;
    private Button btnes;
    public String horas;
    public String horasig;
    public double horalum, horasaisg, total;
    public int horalum1, horasaisg1, total1;
    public String totalentrgar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_asist);
        ry = getIntent().getStringExtra("RuttMenu");
        nm = getIntent().getStringExtra("Nombre");

        spnenr = (Spinner) findViewById(R.id.spnAsis);
        btnes = (Button) findViewById(R.id.btnAsist);

        totalhAsig = (TextView) findViewById(R.id.txtTHAsig);
        totalhAsistidas = (TextView) findViewById(R.id.txtTHAsis);
        porcentaje = (TextView) findViewById(R.id.txtPDA);

        btnes.setOnClickListener(this);
        ArrayList<String> emp = listadoAsigxCarrera2();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, emp);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnenr.setAdapter(adapter);
    }

    public void onClick(View v) {
        TotalHoras();
        HorasAsis();
        porcentajecom();
        Toast.makeText(getApplicationContext(), "Operación realizada...", Toast.LENGTH_SHORT).show();

    }

    public void TotalHoras() {
        String asignaturaSelec = spnenr.getSelectedItem().toString();
        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        helper.openDataBase();
        Cursor c = db.rawQuery("SELECT Horas FROM asignatura WHERE Nombre='" + asignaturaSelec + "';", null);
        try {
            if (c.moveToFirst()) {

                horasig = c.getString(0);
                totalhAsig.setText(horasig + " HRS");


            }
            c.close();
            helper.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            helper.close();
        }
    }

    public void HorasAsis() {
        String asignaturaSelec = spnenr.getSelectedItem().toString();
        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        helper.openDataBase();
        Cursor c = db.rawQuery("SELECT sum(asis.HorasAsist)\n" +
                "FROM asistencia as asis\n" +
                "JOIN alumno_has_Seccion as ahs\n" +
                "ON asis.Alumno_has_Seccion_Id = ahs.Id\n" +
                "JOIN alumno as alum\n" +
                "ON ahs.Alumno_Rut = alum.Rut\n" +
                "JOIN seccion as sec\n" +
                "ON ahs.Seccion_Id = sec.Id\n" +
                "JOIN asignatura as asig\n" +
                "ON sec.Asignatura_Id = asig.Id\n" +
                "WHERE alum.Rut = '" + ry + "'and asig.Nombre ='" + asignaturaSelec + "';", null);
        try {
            if (c.moveToFirst()) {
                horas = c.getString(0);
                if (c.isNull(0)) {
                    totalhAsistidas.setText("0 HRS");
                } else {
                    totalhAsistidas.setText(horas + " HRS");
                }
            }
            c.close();
            helper.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            helper.close();
        }

    }

    public ArrayList<String> listadoAsigxCarrera2() {
        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        ArrayList<String> dev = null;
        try {
            helper.openDataBase();
            dev = new ArrayList<String>();
            Cursor c = db.rawQuery("SELECT a.Nombre\n" +
                    "FROM asignatura as a\n" +
                    "JOIN seccion as sec\n" +
                    "ON a.Id=sec.Asignatura_Id\n" +
                    "JOIN Alumno_has_Seccion as ahs\n" +
                    "ON sec.Id= ahs.Seccion_Id\n" +
                    "JOIN Alumno as alum\n" +
                    "ON ahs.Alumno_Rut = alum.Rut\n" +
                    "WHERE alum.Rut='" + ry + "'ORDER BY a.Nombre ASC", null);
            if (c.moveToFirst()) {
                do {
                    String nombre = c.getString(0);
                    dev.add(nombre);

                } while (c.moveToNext());
            }
            c.close();
            helper.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            helper.close();
            return null;
        }
        return dev;
    }

    public void porcentajecom() {
        if (horas == null) {
            porcentaje.setText("0%");
        } else {
            horalum = Double.parseDouble(horas.trim());
            horasaisg = Double.parseDouble(horasig.trim());
            total = horalum * 100 / horasaisg;
            totalentrgar = String.valueOf(total);
            DecimalFormat df = new DecimalFormat("#.#");
            porcentaje.setText(String.valueOf(Double.valueOf(df.format(total))) + "%");
            ;
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(MenuAsist.this, com.example.hgmovil.intramovil.view.Menu.class);
        i.putExtra("Nomb", nm);
        i.putExtra("Rutt", ry);
        startActivity(i);
    }
}
