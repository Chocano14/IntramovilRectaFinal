package com.example.hgmovil.intramovil.view;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hgmovil.intramovil.R;
import com.example.hgmovil.intramovil.modeloDAO.AsignaturaDAO;
import com.example.hgmovil.intramovil.sqlite.BDIntraMovil;

import java.util.ArrayList;
import java.util.List;

public class MenuNot extends AppCompatActivity implements View.OnClickListener {
    private Button btn;
    private Spinner spn;
    public TextView Nota, Nota1, Nota2, Nota3, Nota4, Nota5, Nota6;
    private TextView Ponderacion, Ponderacion1, Ponderacion2, Ponderacion3, Ponderacion4, Ponderacion5, Ponderacion6;
    private TextView Fecha, Fecha1, Fecha2, Fecha3, Fecha4, Fecha5, Fecha6;
    private String ry, nm;

    private ArrayAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_not);
        ry = getIntent().getStringExtra("RuttMenu");
        nm = getIntent().getStringExtra("Nombre");

        btn = (Button) findViewById(R.id.btn);
        spn = (Spinner) findViewById(R.id.spnAsig);

        //listNot = (ListView)findViewById(R.id.lv);

        Nota = (TextView) findViewById(R.id.txtNota);
        Ponderacion = (TextView) findViewById(R.id.txtPon);
        Fecha = (TextView) findViewById(R.id.txtFecha);

        Nota1 = (TextView) findViewById(R.id.txtNota1);
        Ponderacion1 = (TextView) findViewById(R.id.txtPon1);
        Fecha1 = (TextView) findViewById(R.id.txtFecha1);

        Nota2 = (TextView) findViewById(R.id.txtNota2);
        Ponderacion2 = (TextView) findViewById(R.id.txtPon2);
        Fecha2 = (TextView) findViewById(R.id.txtFecha2);

        Nota3 = (TextView) findViewById(R.id.txtNota3);
        Ponderacion3 = (TextView) findViewById(R.id.txtPon3);
        Fecha3 = (TextView) findViewById(R.id.txtFecha3);

        Nota4 = (TextView) findViewById(R.id.txtNota4);
        Ponderacion4 = (TextView) findViewById(R.id.txtPon4);
        Fecha4 = (TextView) findViewById(R.id.txtFecha4);

        Nota5 = (TextView) findViewById(R.id.txtNota5);
        Ponderacion5 = (TextView) findViewById(R.id.txtPon5);
        Fecha5 = (TextView) findViewById(R.id.txtFecha5);

        Nota6 = (TextView) findViewById(R.id.txtNota6);
        Ponderacion6 = (TextView) findViewById(R.id.txtPon6);
        Fecha6 = (TextView) findViewById(R.id.txtFecha6);

        btn.setOnClickListener(this);

        ArrayList<String> emp = listadoAsigxCarrera2();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, emp);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);
    }

    @Override
    public void onClick(View v)

    {
        cargar();
        Toast.makeText(getApplicationContext(), "Operación realizada...", Toast.LENGTH_SHORT).show();

    }

    public void cargar() {
        String asignaturaSelec = spn.getSelectedItem().toString();
        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        helper.openDataBase();
        Cursor c = db.rawQuery("SELECT n.Nota, n.Ponderacion, n.Fecha FROM nota as n  LEFT JOIN seccion as sec ON n.Seccion_Id = sec.Id JOIN asignatura as asig ON sec.Asignatura_Id =asig.Id JOIN alumno as al ON n.Alumno_Rut = al.Rut WHERE asig.Nombre ='" + asignaturaSelec + "'and al.Rut='" + ry + "';", null);
        Nota.setText("");
        Nota1.setText("");
        Nota2.setText("");
        Nota3.setText("");
        Nota4.setText("");
        Nota5.setText("");
        Nota6.setText("");
        Ponderacion.setText("");
        Ponderacion1.setText("");
        Ponderacion2.setText("");
        ;
        Ponderacion3.setText("");
        Ponderacion4.setText("");
        ;
        Ponderacion5.setText("");
        Ponderacion6.setText("");
        Fecha.setText("");
        Fecha1.setText("");
        Fecha2.setText("");
        ;
        Fecha3.setText("");
        Fecha4.setText("");
        ;
        Fecha5.setText("");
        Fecha6.setText("");

        try {
            if (c.moveToFirst()) {
                String nota = c.getString(0);
                String ponderacion = c.getString(1);
                String fecha = c.getString(2);
                Nota.setText(nota);
                Ponderacion.setText(ponderacion + "%");
                Fecha.setText(fecha);
                if (c.moveToNext()) {
                    String nota1 = c.getString(0);
                    String ponderacion1 = c.getString(1);
                    String fecha1 = c.getString(2);

                    Nota1.setText(nota1);
                    Ponderacion1.setText(ponderacion1 + "%");
                    Fecha1.setText(fecha1);
                    if (c.moveToNext()) {
                        String nota2 = c.getString(0);
                        String ponderacion2 = c.getString(1);
                        String fecha2 = c.getString(2);

                        Nota2.setText(nota2);
                        Ponderacion2.setText(ponderacion2 + "%");
                        Fecha2.setText(fecha2);
                        if (c.moveToNext()) {
                            String nota3 = c.getString(0);
                            String ponderacion3 = c.getString(1);
                            String fecha3 = c.getString(2);

                            Nota3.setText(nota3);
                            Ponderacion3.setText(ponderacion3 + "%");
                            Fecha3.setText(fecha3);
                            if (c.moveToNext()) {
                                String nota4 = c.getString(0);
                                String ponderacion4 = c.getString(1);
                                String fecha4 = c.getString(2);

                                Nota4.setText(nota4);
                                Ponderacion4.setText(ponderacion4 + "%");
                                Fecha4.setText(fecha4);
                                if (c.moveToNext()) {
                                    String nota5 = c.getString(0);
                                    String ponderacion5 = c.getString(1);
                                    String fecha5 = c.getString(2);

                                    Nota5.setText(nota5);
                                    Ponderacion5.setText(ponderacion5 + "%");
                                    Fecha5.setText(fecha5);
                                    if (c.moveToNext()) {
                                        String nota6 = c.getString(0);
                                        String ponderacion6 = c.getString(1);
                                        String fecha6 = c.getString(2);

                                        Nota6.setText(nota6);
                                        Ponderacion6.setText(ponderacion6 + "%");
                                        Fecha6.setText(fecha6);
                                    }
                                }
                            }
                        }
                    }
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

    @Override
    public void onBackPressed() {
        Intent i = new Intent(MenuNot.this, com.example.hgmovil.intramovil.view.Menu.class);
        i.putExtra("Nomb", nm);
        i.putExtra("Rutt", ry);
        startActivity(i);
    }
}