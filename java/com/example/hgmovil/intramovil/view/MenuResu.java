package com.example.hgmovil.intramovil.view;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hgmovil.intramovil.R;
import com.example.hgmovil.intramovil.sqlite.BDIntraMovil;

public class MenuResu extends AppCompatActivity implements View.OnClickListener {
    private Button btn;
    private TextView Asis, Asis1, Asis2, Asis3, Asis4, Asis5, Asis6;
    private TextView Promedio, Promedio1, Promedio2, Promedio3, Promedio4, Promedio5, Promedio6;
    private TextView Situacion, Situacion1, Situacion2, Situacion3, Situacion4, Situacion5, Situacion6;
    private TextView Asignatura, Asignatura1, Asignatura2, Asignatura3, Asignatura4, Asignatura5, Asignatura6;
    private TextView txtA1, txtA2, txtA3, txtA4, txtA5, txtA6, txtA7;
    private TextView txtP1, txtP2, txtP3, txtP4, txtP5, txtP6, txtP7;
    private TextView txtS1, txtS2, txtS3, txtS4, txtS5, txtS6, txtS7;
    private String ry, nm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_resu);
        ry = getIntent().getStringExtra("RuttMenu");
        nm = getIntent().getStringExtra("Nombre");

        btn = (Button) findViewById(R.id.btnResum);
        txtA1 = (TextView) findViewById(R.id.txt1Asis);
        txtA2 = (TextView) findViewById(R.id.txt2Asis);
        txtA3 = (TextView) findViewById(R.id.txt3Asis);
        txtA4 = (TextView) findViewById(R.id.txt4Asis);
        txtA5 = (TextView) findViewById(R.id.txt5Asis);
        txtA6 = (TextView) findViewById(R.id.txt6Asis);
        txtA7 = (TextView) findViewById(R.id.txt7Asis);

        txtP1 = (TextView) findViewById(R.id.txt1Prome);
        txtP2 = (TextView) findViewById(R.id.txt2Prome);
        txtP3 = (TextView) findViewById(R.id.txt3Prome);
        txtP4 = (TextView) findViewById(R.id.txt4Prome);
        txtP5 = (TextView) findViewById(R.id.txt5Prome);
        txtP6 = (TextView) findViewById(R.id.txt6Prome);
        txtP7 = (TextView) findViewById(R.id.txt7Prome);

        txtS1 = (TextView) findViewById(R.id.txt1Situ);
        txtS2 = (TextView) findViewById(R.id.txt2Situ);
        txtS3 = (TextView) findViewById(R.id.txt3Situ);
        txtS4 = (TextView) findViewById(R.id.txt4Situ);
        txtS5 = (TextView) findViewById(R.id.txt5Situ);
        txtS6 = (TextView) findViewById(R.id.txt6Situ);
        txtS7 = (TextView) findViewById(R.id.txt7Situ);


        Asignatura = (TextView) findViewById(R.id.Asignatura);
        Asis = (TextView) findViewById(R.id.txtAsisten);
        Promedio = (TextView) findViewById(R.id.txtProm);
        Situacion = (TextView) findViewById(R.id.txtSitu);

        Asignatura1 = (TextView) findViewById(R.id.Asignatura1);
        Asis1 = (TextView) findViewById(R.id.txtAsisten1);
        Promedio1 = (TextView) findViewById(R.id.txtProm1);
        Situacion1 = (TextView) findViewById(R.id.txtSitu1);

        Asignatura2 = (TextView) findViewById(R.id.Asignatura2);
        Asis2 = (TextView) findViewById(R.id.txtAsisten2);
        Promedio2 = (TextView) findViewById(R.id.txtProm2);
        Situacion2 = (TextView) findViewById(R.id.txtSitu2);

        Asignatura3 = (TextView) findViewById(R.id.Asignatura3);
        Asis3 = (TextView) findViewById(R.id.txtAsisten3);
        Promedio3 = (TextView) findViewById(R.id.txtProm3);
        Situacion3 = (TextView) findViewById(R.id.txtSitu3);

        Asignatura4 = (TextView) findViewById(R.id.Asignatura4);
        Asis4 = (TextView) findViewById(R.id.txtAsisten4);
        Promedio4 = (TextView) findViewById(R.id.txtProm4);
        Situacion4 = (TextView) findViewById(R.id.txtSitu4);

        Asignatura5 = (TextView) findViewById(R.id.Asignatura5);
        Asis5 = (TextView) findViewById(R.id.txtAsisten5);
        Promedio5 = (TextView) findViewById(R.id.txtProm5);
        Situacion5 = (TextView) findViewById(R.id.txtSitu5);

        Asignatura6 = (TextView) findViewById(R.id.Asignatura6);
        Asis6 = (TextView) findViewById(R.id.txtAsisten6);
        Promedio6 = (TextView) findViewById(R.id.txtProm6);
        Situacion6 = (TextView) findViewById(R.id.txtSitu6);
        btn.setOnClickListener(this);
    }

    @Override

    public void onClick(View v) {
        Promedioramo();
        Toast.makeText(getApplicationContext(), "Operación realizada...", Toast.LENGTH_SHORT).show();

    }

    public void Promedioramo() {

        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        helper.openDataBase();
        Cursor a = db.rawQuery("SELECT a.Nombre\n" +
                "FROM asignatura as a\n" +
                "JOIN seccion as sec\n" +
                "ON a.Id=sec.Asignatura_Id\n" +
                "JOIN Alumno_has_Seccion as ahs\n" +
                "ON sec.Id= ahs.Seccion_Id\n" +
                "JOIN Alumno as alum\n" +
                "ON ahs.Alumno_Rut = alum.Rut\n" +
                "WHERE alum.Rut='" + ry + "'ORDER BY a.Nombre ASC;", null);
        try {
            if (a.moveToFirst()) {
                String Asig = a.getString(0);
                Asignatura.setText(Asig);
                Asignatura.setVisibility(View.VISIBLE);
                txtA1.setVisibility(View.VISIBLE);
                Cursor c = db.rawQuery("SELECT AVG(n.Nota)\n" +
                        "FROM nota as n  \n" +
                        "LEFT JOIN seccion as sec \n" +
                        "ON n.Seccion_Id = sec.Id \n" +
                        "JOIN asignatura as asig \n" +
                        "ON sec.Asignatura_Id =asig.Id \n" +
                        "JOIN alumno as al \n" +
                        "ON n.Alumno_Rut = al.Rut \n" +
                        "WHERE asig.Nombre ='" + Asig + "'and al.Rut='" + ry + "';", null);
                if (c.moveToLast()) {
                    String Nota = c.getString(0);
                    Promedio.setText(Nota);
                    Promedio.setVisibility(View.VISIBLE);
                    txtP1.setVisibility(View.VISIBLE);
                    Cursor x = db.rawQuery("SELECT Horas FROM asignatura WHERE Nombre='" + Asig + "';", null);
                    Cursor z = db.rawQuery("SELECT sum(asis.HorasAsist)\n" +
                            "FROM asistencia as asis\n" +
                            "JOIN alumno_has_Seccion as ahs\n" +
                            "ON asis.Alumno_has_Seccion_Id = ahs.Id\n" +
                            "JOIN alumno as alum\n" +
                            "ON ahs.Alumno_Rut = alum.Rut\n" +
                            "JOIN seccion as sec\n" +
                            "ON ahs.Seccion_Id = sec.Id\n" +
                            "JOIN asignatura as asig\n" +
                            "ON sec.Asignatura_Id = asig.Id\n" +
                            "WHERE alum.Rut ='" + ry + "'AND asig.Nombre ='" + Asig + "';", null);

                    if (z.moveToFirst() && x.moveToFirst()) {
                        String promeRam = x.getString(0);
                        String prome = z.getString(0);
                        if (c.isNull(0)) {
                            prome = "0";
                        }
                        Asis.setText(prome + "HRS" + "/" + promeRam + "HRS");
                        double contendor = Double.parseDouble(Nota.trim());
                        if (contendor > 4.0) {
                            Situacion.setText("Sin Riesgo");
                            txtS1.setVisibility(View.VISIBLE);
                        } else {
                            Situacion.setText("Riesgo");
                            txtS1.setVisibility(View.VISIBLE);
                        }


                    }
                }

                if (a.moveToNext()) {
                    String Asig1 = a.getString(0);
                    Asignatura1.setText(Asig1);
                    Asignatura1.setVisibility(View.VISIBLE);
                    txtA2.setVisibility(View.VISIBLE);

                    Cursor cc = db.rawQuery("SELECT AVG(n.Nota)\n" +
                            "FROM nota as n  \n" +
                            "LEFT JOIN seccion as sec \n" +
                            "ON n.Seccion_Id = sec.Id \n" +
                            "JOIN asignatura as asig \n" +
                            "ON sec.Asignatura_Id =asig.Id \n" +
                            "JOIN alumno as al \n" +
                            "ON n.Alumno_Rut = al.Rut \n" +
                            "WHERE asig.Nombre ='" + Asig1 + "'and al.Rut='" + ry + "';", null);

                    if (cc.moveToLast()) {
                        String Nota1 = cc.getString(0);
                        Promedio1.setText(Nota1);
                        Promedio1.setVisibility(View.VISIBLE);
                        txtP2.setVisibility(View.VISIBLE);

                        Cursor xx = db.rawQuery("SELECT Horas FROM asignatura WHERE Nombre='" + Asig1 + "';", null);
                        Cursor zz = db.rawQuery("SELECT sum(asis.HorasAsist)\n" +
                                "FROM asistencia as asis\n" +
                                "JOIN alumno_has_Seccion as ahs\n" +
                                "ON asis.Alumno_has_Seccion_Id = ahs.Id\n" +
                                "JOIN alumno as alum\n" +
                                "ON ahs.Alumno_Rut = alum.Rut\n" +
                                "JOIN seccion as sec\n" +
                                "ON ahs.Seccion_Id = sec.Id\n" +
                                "JOIN asignatura as asig\n" +
                                "ON sec.Asignatura_Id = asig.Id\n" +
                                "WHERE alum.Rut ='" + ry + "'AND asig.Nombre ='" + Asig1 + "';", null);

                        if (zz.moveToFirst() && xx.moveToFirst()) {
                            String promeRam1 = xx.getString(0);
                            String prome1 = zz.getString(0);
                            if (zz.isNull(0)) {
                                prome1 = "0";
                            }
                            Asis1.setText(prome1 + "HRS" + "/" + promeRam1 + "HRS");
                            double contendor1 = Double.parseDouble(Nota1.trim());
                            if (contendor1 > 4.0) {
                                Situacion1.setText("Sin Riesgo");
                                txtS2.setVisibility(View.VISIBLE);
                            } else {
                                Situacion1.setText("Riesgo");
                                txtS2.setVisibility(View.VISIBLE);
                            }

                        }

                        if (a.moveToNext()) {
                            String Asig2 = a.getString(0);
                            Asignatura2.setText(Asig2);
                            Asignatura2.setVisibility(View.VISIBLE);
                            txtA3.setVisibility(View.VISIBLE);
                            Cursor cc2 = db.rawQuery("SELECT AVG(n.Nota)\n" +
                                    "FROM nota as n  \n" +
                                    "LEFT JOIN seccion as sec \n" +
                                    "ON n.Seccion_Id = sec.Id \n" +
                                    "JOIN asignatura as asig \n" +
                                    "ON sec.Asignatura_Id =asig.Id \n" +
                                    "JOIN alumno as al \n" +
                                    "ON n.Alumno_Rut = al.Rut \n" +
                                    "WHERE asig.Nombre ='" + Asig2 + "'and al.Rut='" + ry + "';", null);

                            if (cc2.moveToLast()) {
                                String Nota2 = cc2.getString(0);
                                Promedio2.setText(Nota2);
                                Promedio2.setVisibility(View.VISIBLE);
                                txtP3.setVisibility(View.VISIBLE);

                                Cursor xx2 = db.rawQuery("SELECT Horas FROM asignatura WHERE Nombre='" + Asig2 + "';", null);
                                Cursor zz2 = db.rawQuery("SELECT sum(asis.HorasAsist)\n" +
                                        "FROM asistencia as asis\n" +
                                        "JOIN alumno_has_Seccion as ahs\n" +
                                        "ON asis.Alumno_has_Seccion_Id = ahs.Id\n" +
                                        "JOIN alumno as alum\n" +
                                        "ON ahs.Alumno_Rut = alum.Rut\n" +
                                        "JOIN seccion as sec\n" +
                                        "ON ahs.Seccion_Id = sec.Id\n" +
                                        "JOIN asignatura as asig\n" +
                                        "ON sec.Asignatura_Id = asig.Id\n" +
                                        "WHERE alum.Rut ='" + ry + "'AND asig.Nombre ='" + Asig2 + "';", null);

                                if (zz2.moveToFirst() && xx2.moveToFirst()) {
                                    String promeRam2 = xx2.getString(0);
                                    String prome2 = zz2.getString(0);
                                    if (zz2.isNull(0)) {
                                        prome2 = "0";
                                    }
                                    Asis2.setText(prome2 + "HRS" + "/" + promeRam2 + "HRS");
                                    double contendor = Double.parseDouble(Nota2.trim());
                                    if (contendor > 4.0) {
                                        Situacion2.setText("Sin Riesgo");
                                        txtS3.setVisibility(View.VISIBLE);
                                    } else {
                                        Situacion2.setText("Riesgo");
                                        txtS3.setVisibility(View.VISIBLE);
                                    }

                                }
                            }
                            if (a.moveToNext()) {
                                String Asig3 = a.getString(0);
                                Asignatura3.setText(Asig3);
                                Asignatura3.setVisibility(View.VISIBLE);
                                txtA4.setVisibility(View.VISIBLE);
                                Cursor cc3 = db.rawQuery("SELECT AVG(n.Nota)\n" +
                                        "FROM nota as n  \n" +
                                        "LEFT JOIN seccion as sec \n" +
                                        "ON n.Seccion_Id = sec.Id \n" +
                                        "JOIN asignatura as asig \n" +
                                        "ON sec.Asignatura_Id =asig.Id \n" +
                                        "JOIN alumno as al \n" +
                                        "ON n.Alumno_Rut = al.Rut \n" +
                                        "WHERE asig.Nombre ='" + Asig3 + "'and al.Rut='" + ry + "';", null);
                                if (cc3.moveToLast()) {
                                    String Nota3 = cc3.getString(0);
                                    Promedio3.setText(Nota3);
                                    Promedio3.setVisibility(View.VISIBLE);
                                    txtP4.setVisibility(View.VISIBLE);

                                    Cursor xx3 = db.rawQuery("SELECT Horas FROM asignatura WHERE Nombre='" + Asig3 + "';", null);
                                    Cursor zz3 = db.rawQuery("SELECT sum(asis.HorasAsist)\n" +
                                            "FROM asistencia as asis\n" +
                                            "JOIN alumno_has_Seccion as ahs\n" +
                                            "ON asis.Alumno_has_Seccion_Id = ahs.Id\n" +
                                            "JOIN alumno as alum\n" +
                                            "ON ahs.Alumno_Rut = alum.Rut\n" +
                                            "JOIN seccion as sec\n" +
                                            "ON ahs.Seccion_Id = sec.Id\n" +
                                            "JOIN asignatura as asig\n" +
                                            "ON sec.Asignatura_Id = asig.Id\n" +
                                            "WHERE alum.Rut ='" + ry + "'AND asig.Nombre ='" + Asig3 + "';", null);

                                    if (zz3.moveToFirst() && xx3.moveToFirst()) {
                                        String promeRam3 = xx3.getString(0);
                                        String prome3 = zz3.getString(0);
                                        if (zz3.isNull(0)) {
                                            prome3 = "0";
                                        }
                                        Asis3.setText(prome3 + "HRS" + "/" + promeRam3 + "HRS");
                                        double contendor = Double.parseDouble(Nota3.trim());
                                        if (contendor > 4.0) {
                                            Situacion3.setText("Sin Riesgo");
                                            txtS4.setVisibility(View.VISIBLE);
                                        } else {
                                            Situacion3.setText("Riesgo");
                                            txtS4.setVisibility(View.VISIBLE);
                                        }

                                    }
                                }

                                if (a.moveToNext()) {
                                    String Asig4 = a.getString(0);
                                    Asignatura4.setText(Asig4);
                                    Asignatura4.setVisibility(View.VISIBLE);
                                    txtA5.setVisibility(View.VISIBLE);
                                    Cursor cc4 = db.rawQuery("SELECT AVG(n.Nota)\n" +
                                            "FROM nota as n  \n" +
                                            "LEFT JOIN seccion as sec \n" +
                                            "ON n.Seccion_Id = sec.Id \n" +
                                            "JOIN asignatura as asig \n" +
                                            "ON sec.Asignatura_Id =asig.Id \n" +
                                            "JOIN alumno as al \n" +
                                            "ON n.Alumno_Rut = al.Rut \n" +
                                            "WHERE asig.Nombre ='" + Asig4 + "'and al.Rut='" + ry + "';", null);
                                    if (cc4.moveToLast()) {
                                        String Nota4 = cc4.getString(0);
                                        Promedio4.setText(Nota4);
                                        Promedio4.setVisibility(View.VISIBLE);
                                        txtP5.setVisibility(View.VISIBLE);

                                        Cursor xx4 = db.rawQuery("SELECT Horas FROM asignatura WHERE Nombre='" + Asig4 + "';", null);
                                        Cursor zz4 = db.rawQuery("SELECT sum(asis.HorasAsist)\n" +
                                                "FROM asistencia as asis\n" +
                                                "JOIN alumno_has_Seccion as ahs\n" +
                                                "ON asis.Alumno_has_Seccion_Id = ahs.Id\n" +
                                                "JOIN alumno as alum\n" +
                                                "ON ahs.Alumno_Rut = alum.Rut\n" +
                                                "JOIN seccion as sec\n" +
                                                "ON ahs.Seccion_Id = sec.Id\n" +
                                                "JOIN asignatura as asig\n" +
                                                "ON sec.Asignatura_Id = asig.Id\n" +
                                                "WHERE alum.Rut ='" + ry + "'AND asig.Nombre ='" + Asig4 + "';", null);

                                        if (zz4.moveToFirst() && xx4.moveToFirst()) {
                                            String promeRam4 = xx4.getString(0);
                                            String prome4 = zz4.getString(0);
                                            if (zz4.isNull(0)) {
                                                prome4 = "0";
                                            }
                                            Asis4.setText(prome4 + "HRS" + "/" + promeRam4 + "HRS");
                                            double contendor = Double.parseDouble(Nota4.trim());
                                            if (contendor > 4.0) {
                                                Situacion4.setText("Sin Riesgo");
                                                txtS5.setVisibility(View.VISIBLE);
                                            } else {
                                                Situacion4.setText("Riesgo");
                                                txtS5.setVisibility(View.VISIBLE);
                                            }

                                        }
                                        if (a.moveToNext()) {
                                            String Asig5 = a.getString(0);
                                            Asignatura5.setText(Asig5);
                                            Asignatura5.setVisibility(View.VISIBLE);
                                            txtA6.setVisibility(View.VISIBLE);
                                            Cursor cc5 = db.rawQuery("SELECT AVG(n.Nota)\n" +
                                                    "FROM nota as n  \n" +
                                                    "LEFT JOIN seccion as sec \n" +
                                                    "ON n.Seccion_Id = sec.Id \n" +
                                                    "JOIN asignatura as asig \n" +
                                                    "ON sec.Asignatura_Id =asig.Id \n" +
                                                    "JOIN alumno as al \n" +
                                                    "ON n.Alumno_Rut = al.Rut \n" +
                                                    "WHERE asig.Nombre ='" + Asig5 + "'and al.Rut='" + ry + "';", null);
                                            if (cc5.moveToLast()) {
                                                String Nota5 = cc5.getString(0);
                                                Promedio5.setText(Nota5);
                                                Promedio5.setVisibility(View.VISIBLE);
                                                txtP6.setVisibility(View.VISIBLE);

                                                Cursor xx5 = db.rawQuery("SELECT Horas FROM asignatura WHERE Nombre='" + Asig5 + "';", null);
                                                Cursor zz5 = db.rawQuery("SELECT sum(asis.HorasAsist)\n" +
                                                        "FROM asistencia as asis\n" +
                                                        "JOIN alumno_has_Seccion as ahs\n" +
                                                        "ON asis.Alumno_has_Seccion_Id = ahs.Id\n" +
                                                        "JOIN alumno as alum\n" +
                                                        "ON ahs.Alumno_Rut = alum.Rut\n" +
                                                        "JOIN seccion as sec\n" +
                                                        "ON ahs.Seccion_Id = sec.Id\n" +
                                                        "JOIN asignatura as asig\n" +
                                                        "ON sec.Asignatura_Id = asig.Id\n" +
                                                        "WHERE alum.Rut ='" + ry + "'AND asig.Nombre ='" + Asig5 + "';", null);

                                                if (zz5.moveToFirst() && xx5.moveToFirst()) {
                                                    String promeRam5 = xx5.getString(0);
                                                    String prome5 = zz5.getString(0);
                                                    if (zz5.isNull(0)) {
                                                        prome5 = "0";
                                                    }
                                                    Asis5.setText(prome5 + "HRS" + "/" + promeRam5 + "HRS");
                                                    double contendor = Double.parseDouble(Nota5.trim());
                                                    if (contendor > 4.0) {
                                                        Situacion5.setText("Sin Riesgo");
                                                        txtS6.setVisibility(View.VISIBLE);
                                                    } else {
                                                        Situacion5.setText("Riesgo");
                                                        txtS6.setVisibility(View.VISIBLE);
                                                    }

                                                }
                                                if (a.moveToNext()) {
                                                    String Asig6 = a.getString(0);
                                                    Asignatura6.setText(Asig6);
                                                    Asignatura6.setVisibility(View.VISIBLE);
                                                    txtA7.setVisibility(View.VISIBLE);
                                                    Cursor cc6 = db.rawQuery("SELECT AVG(n.Nota)\n" +
                                                            "FROM nota as n  \n" +
                                                            "LEFT JOIN seccion as sec \n" +
                                                            "ON n.Seccion_Id = sec.Id \n" +
                                                            "JOIN asignatura as asig \n" +
                                                            "ON sec.Asignatura_Id =asig.Id \n" +
                                                            "JOIN alumno as al \n" +
                                                            "ON n.Alumno_Rut = al.Rut \n" +
                                                            "WHERE asig.Nombre ='" + Asig6 + "'and al.Rut='" + ry + "';", null);
                                                    if (cc6.moveToLast()) {
                                                        String Nota6 = cc5.getString(0);
                                                        Promedio6.setText(Nota6);
                                                        Promedio6.setVisibility(View.VISIBLE);
                                                        txtP7.setVisibility(View.VISIBLE);

                                                        Cursor xx6 = db.rawQuery("SELECT Horas FROM asignatura WHERE Nombre='" + Asig6 + "';", null);
                                                        Cursor zz6 = db.rawQuery("SELECT sum(asis.HorasAsist)\n" +
                                                                "FROM asistencia as asis\n" +
                                                                "JOIN alumno_has_Seccion as ahs\n" +
                                                                "ON asis.Alumno_has_Seccion_Id = ahs.Id\n" +
                                                                "JOIN alumno as alum\n" +
                                                                "ON ahs.Alumno_Rut = alum.Rut\n" +
                                                                "JOIN seccion as sec\n" +
                                                                "ON ahs.Seccion_Id = sec.Id\n" +
                                                                "JOIN asignatura as asig\n" +
                                                                "ON sec.Asignatura_Id = asig.Id\n" +
                                                                "WHERE alum.Rut ='" + ry + "'AND asig.Nombre ='" + Asig6 + "';", null);

                                                        if (zz6.moveToFirst() && xx6.moveToFirst()) {
                                                            String promeRam6 = xx6.getString(0);
                                                            String prome6 = zz6.getString(0);
                                                            if (zz6.isNull(0)) {
                                                                prome6 = "0";
                                                            }
                                                            Asis6.setText(prome6 + "HRS" + "/" + promeRam6 + "HRS");
                                                            double contendor = Double.parseDouble(Nota6.trim());
                                                            if (contendor > 4.0) {
                                                                Situacion6.setText("Sin Riesgo");
                                                                txtS7.setVisibility(View.VISIBLE);
                                                            } else {
                                                                Situacion6.setText("Riesgo");
                                                                txtS7.setVisibility(View.VISIBLE);
                                                            }

                                                        }


                                                    }
                                                }
                                            }
                                        }

                                    }
                                }
                            }
                        }

                    }

                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            helper.close();
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(MenuResu.this, com.example.hgmovil.intramovil.view.Menu.class);
        i.putExtra("Nomb", nm);
        i.putExtra("Rutt", ry);
        startActivity(i);
    }
}
