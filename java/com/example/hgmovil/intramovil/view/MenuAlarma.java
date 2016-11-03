package com.example.hgmovil.intramovil.view;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import android.app.TimePickerDialog;
import android.widget.TimePicker;

import com.example.hgmovil.intramovil.R;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by pablo on 04-05-2016.
 */
public class MenuAlarma extends AppCompatActivity {
    private EditText textoAlar;
    private EditText fechaAlar;
    private EditText horaAlarm;
    private Button btnAlarma;
    private Button btnCRear;
    private int año, añoac;
    private int dia, diaac;
    private int mes, mesac;
    private int mHour, mMinute;
    private Button btnHoras;
    private static final int TIPO_DIALOGO = 0;
    String ala, textoAlarma;
    private static DatePickerDialog.OnDateSetListener SelectFecha;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_alarma);
        textoAlar = (EditText) findViewById(R.id.txtTxAlar);
        fechaAlar = (EditText) findViewById(R.id.txtFechaAlar);
        horaAlarm = (EditText) findViewById(R.id.txtHoraAlar);
        btnAlarma = (Button) findViewById(R.id.btnCAlarma);
        btnHoras = (Button) findViewById(R.id.btnHora);
        Calendar calendario = Calendar.getInstance();
        año = calendario.get(Calendar.YEAR);
        añoac = calendario.get(Calendar.YEAR);
        mesac = calendario.get(Calendar.MONTH);
        diaac = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH);

        dia = calendario.get(Calendar.DAY_OF_MONTH);


        mostraFecha();
        SelectFecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                año = year;
                dia = dayOfMonth;
                mes = monthOfYear;
                mostraFecha();

            }
        };


    }

    ;

    public void onClickHora(View v) {
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR);
        mMinute = c.get(Calendar.MINUTE);
        if (v == btnHoras) {


            TimePickerDialog tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

                @Override
                public void onTimeSet(TimePicker view, int hour,
                                      int minute) {

                    horaAlarm.setText(hour + ":" + minute);
                }
            }, mHour, mMinute, false);

            tpd.show();
        }
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 0:
                return new DatePickerDialog(this, SelectFecha, año, mes, dia);
        }

        return null;

    }

    public void mostrarCalendario(View view) {
        showDialog(TIPO_DIALOGO);


    }

    public void mostraFecha() {

        fechaAlar.setText(dia + "/" + (mes + 1) + "/" + año);


    }


    public void onClickAcptar(View v) {
        textoAlarma = textoAlar.getText().toString();
        if (btnAlarma == v) {

            if (dia == diaac && mes + 1 == mesac + 1 && año == añoac) {
                doNotefy();
            }
            final AlertDialog.Builder asitencias = new AlertDialog.Builder(MenuAlarma.this);
            asitencias.setTitle("Alarma Creada");
            asitencias.setMessage("Asunto: " + textoAlarma + "\n" +
                    "Fecha de Alarma: " + dia + "/" + (mes + 1) + "/" + año + "\n" +
                    "Hora de Alarma: " + mHour + ":" + mMinute);
            asitencias.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            asitencias.show();
        }
    }

    public void doNotefy() {
        String t = String.valueOf(textoAlar);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(android.R.drawable.stat_sys_warning);
        mBuilder.setVibrate(new long[]{0, 500, 0, 500});
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        mBuilder.setSound(uri);

        mBuilder.setLargeIcon((((BitmapDrawable) getResources().getDrawable(R.drawable.icono)).getBitmap()));
        mBuilder.setContentTitle("Alarma");
        mBuilder.setContentText(textoAlarma);
        mBuilder.setTicker("Alerta!");


        Intent notIntent =
                new Intent(this, Menu.class);

        PendingIntent contIntent = PendingIntent.getActivity(this, 0, notIntent, 0);
        mBuilder.setContentIntent(contIntent);

        NotificationManager notifManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        int notif_ref = 1;

        notifManager.notify(notif_ref, mBuilder.build());
    }
}
