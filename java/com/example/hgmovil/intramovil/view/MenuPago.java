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

public class MenuPago extends AppCompatActivity implements View.OnClickListener {
    private Button btnVer;
    private TextView est1, est2, est3, est4, est5, est6, est7, est8,
            con1, con2, con3, con4, con5, con6, con7, con8,
            mon1, mon2, mon3, mon4, mon5, mon6, mon7, mon8,
            fech1, fech2, fech3, fech4, fech5, fech6, fech7, fech8;
    private String rutPago, nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_pago);
        rutPago = getIntent().getStringExtra("RuttMenu");
        nm = getIntent().getStringExtra("Nombre");


        btnVer = (Button) findViewById(R.id.btnVer);
        est1 = (TextView) findViewById(R.id.est1);
        est2 = (TextView) findViewById(R.id.est2);
        est3 = (TextView) findViewById(R.id.est3);
        est4 = (TextView) findViewById(R.id.est4);
        est5 = (TextView) findViewById(R.id.est5);
        est6 = (TextView) findViewById(R.id.est6);
        est7 = (TextView) findViewById(R.id.est7);
        est8 = (TextView) findViewById(R.id.est8);

        con1 = (TextView) findViewById(R.id.con1);
        con2 = (TextView) findViewById(R.id.con2);
        con3 = (TextView) findViewById(R.id.con3);
        con4 = (TextView) findViewById(R.id.con4);
        con5 = (TextView) findViewById(R.id.con5);
        con6 = (TextView) findViewById(R.id.con6);
        con7 = (TextView) findViewById(R.id.con7);
        con8 = (TextView) findViewById(R.id.con8);

        mon1 = (TextView) findViewById(R.id.mon1);
        mon2 = (TextView) findViewById(R.id.mon2);
        mon3 = (TextView) findViewById(R.id.mon3);
        mon4 = (TextView) findViewById(R.id.mon4);
        mon5 = (TextView) findViewById(R.id.mon5);
        mon6 = (TextView) findViewById(R.id.mon6);
        mon7 = (TextView) findViewById(R.id.mon7);
        mon8 = (TextView) findViewById(R.id.mon8);

        fech1 = (TextView) findViewById(R.id.fech1);
        fech2 = (TextView) findViewById(R.id.fech2);
        fech3 = (TextView) findViewById(R.id.fech3);
        fech4 = (TextView) findViewById(R.id.fech4);
        fech5 = (TextView) findViewById(R.id.fech5);
        fech6 = (TextView) findViewById(R.id.fech6);
        fech7 = (TextView) findViewById(R.id.fech7);
        fech8 = (TextView) findViewById(R.id.fech8);

        btnVer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        CargarPago();
        Toast.makeText(getApplicationContext(), "Operación realizada...", Toast.LENGTH_SHORT).show();
    }

    public void CargarPago() {
        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        helper.openDataBase();
        Cursor c = db.rawQuery("SELECT  estado, fechavenc, concepto, monto FROM pago as pg JOIN alumno as al ON pg.Alumno_Rut = al.Rut WHERE al.Rut='" + rutPago + "';", null);
        est1.setText("");
        est2.setText("");
        est3.setText("");
        est4.setText("");
        est5.setText("");
        est6.setText("");
        est7.setText("");
        est8.setText("");
        fech1.setText("");
        fech2.setText("");
        fech3.setText("");
        fech4.setText("");
        fech5.setText("");
        fech6.setText("");
        fech7.setText("");
        fech8.setText("");
        con1.setText("");
        con2.setText("");
        con3.setText("");
        con4.setText("");
        con5.setText("");
        con6.setText("");
        con7.setText("");
        con8.setText("");
        mon1.setText("");
        mon2.setText("");
        mon3.setText("");
        mon4.setText("");
        mon5.setText("");
        mon6.setText("");
        mon7.setText("");
        mon8.setText("");

        try {
            if (c.moveToFirst()) {
                String estado1 = c.getString(0);
                String fecha1 = c.getString(1);
                String conce1 = c.getString(2);
                String monto1 = c.getString(3);

                est1.setText(estado1);
                fech1.setText(fecha1);
                con1.setText(conce1);
                mon1.setText("$" + monto1);

                if (c.moveToNext()) {
                    String estado2 = c.getString(0);
                    String fecha2 = c.getString(1);
                    String conce2 = c.getString(2);
                    String monto2 = c.getString(3);

                    est2.setText(estado2);
                    fech2.setText(fecha2);
                    con2.setText(conce2);
                    mon2.setText("$" + monto2);

                    if (c.moveToNext()) {
                        String estado3 = c.getString(0);
                        String fecha3 = c.getString(1);
                        String conce3 = c.getString(2);
                        String monto3 = c.getString(3);

                        est3.setText(estado3);
                        fech3.setText(fecha3);
                        con3.setText(conce3);
                        mon3.setText("$" + monto3);

                        if (c.moveToNext()) {
                            String estado4 = c.getString(0);
                            String fecha4 = c.getString(1);
                            String conce4 = c.getString(2);
                            String monto4 = c.getString(3);

                            est4.setText(estado4);
                            fech4.setText(fecha4);
                            con4.setText(conce4);
                            mon4.setText("$" + monto4);

                            if (c.moveToNext()) {
                                String estado5 = c.getString(0);
                                String fecha5 = c.getString(1);
                                String conce5 = c.getString(2);
                                String monto5 = c.getString(3);

                                est5.setText(estado5);
                                fech5.setText(fecha5);
                                con5.setText(conce5);
                                mon5.setText("$" + monto5);

                                if (c.moveToNext()) {
                                    String estado6 = c.getString(0);
                                    String fecha6 = c.getString(1);
                                    String conce6 = c.getString(2);
                                    String monto6 = c.getString(3);

                                    est6.setText(estado6);
                                    fech6.setText(fecha6);
                                    con6.setText(conce6);
                                    mon6.setText("$" + monto6);

                                    if (c.moveToNext()) {
                                        String estado7 = c.getString(0);
                                        String fecha7 = c.getString(1);
                                        String conce7 = c.getString(2);
                                        String monto7 = c.getString(3);

                                        est7.setText(estado7);
                                        fech7.setText(fecha7);
                                        con7.setText(conce7);
                                        mon7.setText("$" + monto7);

                                        if (c.moveToNext()) {
                                            String estado8 = c.getString(0);
                                            String fecha8 = c.getString(1);
                                            String conce8 = c.getString(2);
                                            String monto8 = c.getString(3);

                                            est8.setText(estado8);
                                            fech8.setText(fecha8);
                                            con8.setText(conce8);
                                            mon8.setText("$" + monto8);
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

    @Override
    public void onBackPressed() {
        Intent i = new Intent(MenuPago.this, com.example.hgmovil.intramovil.view.Menu.class);
        i.putExtra("Nomb", nm);
        i.putExtra("Rutt", rutPago);
        startActivity(i);
    }
}