package com.example.hgmovil.intramovil.view;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hgmovil.intramovil.R;
import com.example.hgmovil.intramovil.sqlite.BDIntraMovil;

import java.util.ArrayList;

public class MenuHorario extends AppCompatActivity implements View.OnClickListener {
    private Button btn;
    private Spinner spnHora;
    private ArrayAdapter adapter;
    private String ry, nm;
    private TextView asig1, asig2, asig3, asig4, asig5, asig6, asig7, asig8,
            sala1, sala2, sala3, sala4, sala5, sala6, sala7, sala8,
            hora1, hora2, hora3, hora4, hora5, hora6, hora7, hora8;
    private GridLayout grid1, grid2, grid3, grid4, grid5, grid6, grid7, grid8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_horario);
        btn = (Button) findViewById(R.id.btnBuscar);

        ry = getIntent().getStringExtra("RuttMenu");
        nm = getIntent().getStringExtra("Nombre");

        spnHora = (Spinner) findViewById(R.id.spnHorario);
        asig1 = (TextView) findViewById(R.id.txtAsig1);
        asig2 = (TextView) findViewById(R.id.txtAsig2);
        asig3 = (TextView) findViewById(R.id.txtAsig3);
        asig4 = (TextView) findViewById(R.id.txtAsig4);
        asig5 = (TextView) findViewById(R.id.txtAsig5);
        asig6 = (TextView) findViewById(R.id.txtAsig6);
        asig7 = (TextView) findViewById(R.id.txtAsig7);
        asig8 = (TextView) findViewById(R.id.txtAsig8);

        sala1 = (TextView) findViewById(R.id.txtSala1);
        sala2 = (TextView) findViewById(R.id.txtSala2);
        sala3 = (TextView) findViewById(R.id.txtSala3);
        sala4 = (TextView) findViewById(R.id.txtSala4);
        sala5 = (TextView) findViewById(R.id.txtSala5);
        sala6 = (TextView) findViewById(R.id.txtSala6);
        sala7 = (TextView) findViewById(R.id.txtSala7);
        sala8 = (TextView) findViewById(R.id.txtSala8);

        hora1 = (TextView) findViewById(R.id.txtHora1);
        hora2 = (TextView) findViewById(R.id.txtHora2);
        hora3 = (TextView) findViewById(R.id.txtHora3);
        hora4 = (TextView) findViewById(R.id.txtHora4);
        hora5 = (TextView) findViewById(R.id.txtHora5);
        hora6 = (TextView) findViewById(R.id.txtHora6);
        hora7 = (TextView) findViewById(R.id.txtHora7);
        hora8 = (TextView) findViewById(R.id.txtHora8);

        grid1 = (GridLayout) findViewById(R.id.gd1);
        grid2 = (GridLayout) findViewById(R.id.gd2);
        grid3 = (GridLayout) findViewById(R.id.gd3);
        grid4 = (GridLayout) findViewById(R.id.gd4);
        grid5 = (GridLayout) findViewById(R.id.gd5);
        grid6 = (GridLayout) findViewById(R.id.gd6);
        grid7 = (GridLayout) findViewById(R.id.gd7);
        grid8 = (GridLayout) findViewById(R.id.gd8);

        ArrayList<String> emp = ListaHorario();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, emp);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnHora.setAdapter(adapter);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "Operación realizada...", Toast.LENGTH_SHORT).show();
        cargarHorario();
    }

    public void cargarHorario() {
        String diaSelec = spnHora.getSelectedItem().toString();
        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        helper.openDataBase();
        Cursor c = db.rawQuery("SELECT asig.Nombre, hora.HoraInicio, hora.HoraFin, sal.Nombre, d.dia_semana FROM asignatura as asig JOIN seccion as sec ON asig.Id = sec.asignatura_Id JOIN horario_seccion as hs ON sec.Id = hs.Seccion_Id JOIN sala as sal ON hs.Sala_Id = sal.Id JOIN horario as hora ON hs.Horario_Id = hora.Id JOIN dia as d ON hora.dia_id = d.id JOIN alumno_has_seccion as ahs ON sec.Id = ahs.seccion_id JOIN alumno as al ON al.rut = ahs.alumno_rut WHERE d.dia_semana = '" + diaSelec + "' and al.rut='" + ry + "';", null);
        asig1.setText("");
        asig2.setText("");
        asig3.setText("");
        asig4.setText("");
        asig5.setText("");
        asig6.setText("");
        asig7.setText("");
        asig8.setText("");
        sala1.setText("");
        sala2.setText("");
        sala3.setText("");
        sala4.setText("");
        sala5.setText("");
        sala6.setText("");
        sala7.setText("");
        sala8.setText("");
        hora1.setText("");
        hora2.setText("");
        hora3.setText("");
        hora4.setText("");
        hora5.setText("");
        hora6.setText("");
        hora7.setText("");
        hora8.setText("");
        grid1.setVisibility(View.INVISIBLE);
        grid2.setVisibility(View.INVISIBLE);
        grid3.setVisibility(View.INVISIBLE);
        grid4.setVisibility(View.INVISIBLE);
        grid5.setVisibility(View.INVISIBLE);
        grid6.setVisibility(View.INVISIBLE);
        grid7.setVisibility(View.INVISIBLE);
        grid8.setVisibility(View.INVISIBLE);

        try {
            if (c.moveToFirst()) {
                String asigna1 = c.getString(0);
                String sal1 = c.getString(3);
                String hi1 = c.getString(1);
                String hf1 = c.getString(2);
                asig1.setText(asigna1);
                sala1.setText(sal1);
                hora1.setText(hi1 + "-" + hf1 + " HRS");
                grid1.setVisibility(View.VISIBLE);
                if (c.moveToNext()) {
                    String asigna2 = c.getString(0);
                    String sal2 = c.getString(3);
                    String hi2 = c.getString(1);
                    String hf2 = c.getString(2);
                    asig2.setText(asigna2);
                    sala2.setText(sal2);
                    hora2.setText(hi2 + "-" + hf2 + " HRS");
                    grid2.setVisibility(View.VISIBLE);
                    if (c.moveToNext()) {
                        String asigna3 = c.getString(0);
                        String sal3 = c.getString(3);
                        String hi3 = c.getString(1);
                        String hf3 = c.getString(2);
                        asig3.setText(asigna3);
                        sala3.setText(sal3);
                        hora3.setText(hi3 + "-" + hf3 + " HRS");
                        grid3.setVisibility(View.VISIBLE);
                        if (c.moveToNext()) {
                            String asigna4 = c.getString(0);
                            String sal4 = c.getString(3);
                            String hi4 = c.getString(1);
                            String hf4 = c.getString(2);
                            asig4.setText(asigna4);
                            sala4.setText(sal4);
                            hora4.setText(hi4 + "-" + hf4 + " HRS");
                            grid4.setVisibility(View.VISIBLE);
                            if (c.moveToNext()) {
                                String asigna5 = c.getString(0);
                                String sal5 = c.getString(3);
                                String hi5 = c.getString(1);
                                String hf5 = c.getString(2);
                                asig5.setText(asigna5);
                                sala5.setText(sal5);
                                hora5.setText(hi5 + "-" + hf5 + " HRS");
                                grid5.setVisibility(View.VISIBLE);
                                if (c.moveToNext()) {
                                    String asigna6 = c.getString(0);
                                    String sal6 = c.getString(3);
                                    String hi6 = c.getString(1);
                                    String hf6 = c.getString(2);
                                    asig6.setText(asigna6);
                                    sala6.setText(sal6);
                                    hora6.setText(hi6 + "-" + hf6 + " HRS");
                                    grid6.setVisibility(View.VISIBLE);
                                    if (c.moveToNext()) {
                                        String asigna7 = c.getString(0);
                                        String sal7 = c.getString(3);
                                        String hi7 = c.getString(1);
                                        String hf7 = c.getString(2);
                                        asig7.setText(asigna7);
                                        sala7.setText(sal7);
                                        hora7.setText(hi7 + "-" + hf7 + " HRS");
                                        grid7.setVisibility(View.VISIBLE);
                                        if (c.moveToNext()) {
                                            String asigna8 = c.getString(0);
                                            String sal8 = c.getString(3);
                                            String hi8 = c.getString(1);
                                            String hf8 = c.getString(2);
                                            asig8.setText(asigna8);
                                            sala8.setText(sal8);
                                            hora8.setText(hi8 + "-" + hf8 + " HRS");
                                            grid8.setVisibility(View.VISIBLE);
                                        }
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

    public ArrayList<String> ListaHorario() {
        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        ArrayList<String> dev = null;
        try {
            helper.openDataBase();
            dev = new ArrayList<String>();
            Cursor c = db.rawQuery("SELECT dia_semana FROM dia", null);
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
        Intent i = new Intent(MenuHorario.this, com.example.hgmovil.intramovil.view.Menu.class);
        i.putExtra("Nomb", nm);
        i.putExtra("Rutt", ry);
        startActivity(i);
    }
}
