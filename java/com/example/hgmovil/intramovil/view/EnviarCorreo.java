package com.example.hgmovil.intramovil.view;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hgmovil.intramovil.R;
import com.example.hgmovil.intramovil.sqlite.BDIntraMovil;


public class EnviarCorreo extends Activity implements OnClickListener {

    Session session = null;
    ProgressDialog pdialog = null;
    Context context = null;
    EditText reciep, sub, msg;
    String rec, subject, textMessage, correoSelec, rt, contra, correo, nm;
    Spinner spin;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enviar_correo);
        rt = getIntent().getStringExtra("Ruttt");
        nm = getIntent().getStringExtra("Nombree");


        context = this;

        Button login = (Button) findViewById(R.id.btn_submit);
        // reciep = (EditText) findViewById(R.id.et_to);
        sub = (EditText) findViewById(R.id.et_sub);
        msg = (EditText) findViewById(R.id.et_text);
        spin = (Spinner) findViewById(R.id.spnCorreo);

        ArrayList<String> emp = ListaCorreo();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, emp);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        helper.openDataBase();
        correoSelec = spin.getSelectedItem().toString();
        //rec = reciep.getText().toString();
        subject = sub.getText().toString();
        textMessage = msg.getText().toString();

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Cursor c = db.rawQuery("SELECT correo, contraseña FROM alumno where rut ='" + rt + "'", null);
        try {
            if (c.moveToFirst()) {
                correo = c.getString(0);
                contra = c.getString(1);
            }
            c.close();
            helper.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            helper.close();
        }


        session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(correo, contra);
            }
        });

        pdialog = ProgressDialog.show(context, "", "Enviando correo...", true);

        RetreiveFeedTask task = new RetreiveFeedTask();
        task.execute();
    }

    class RetreiveFeedTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("testfrom354@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoSelec));
                message.setSubject(subject);
                message.setContent(textMessage, "text/html; charset=utf-8");
                Transport.send(message);
            } catch (MessagingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            pdialog.dismiss();
            // reciep.setText("");
            msg.setText("");
            sub.setText("");
            Toast.makeText(getApplicationContext(), "Mensaje enviado", Toast.LENGTH_LONG).show();
        }
    }

    public ArrayList<String> ListaCorreo() {
        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        ArrayList<String> dev = null;
        try {
            helper.openDataBase();
            dev = new ArrayList<String>();
            Cursor c = db.rawQuery("SELECT jc.correo\n" +
                    "FROM jefecarrera as jc\n" +
                    "JOIN carrera_jefecarrera as cjc\n" +
                    "ON jc.id = cjc.jefecarrera_id\n" +
                    "JOIN carrera as carr\n" +
                    "ON cjc.carrera_id = carr.id\n" +
                    "JOIN alumno as alum\n" +
                    "ON carr.id = alum.carrera_id\n" +
                    "WHERE alum.rut = '" + rt + "'\n" +
                    "UNION all\n" +
                    "SELECT DISTINCT doc.correo\n" +
                    "FROM docente as doc \n" +
                    "JOIN seccion as sec\n" +
                    "ON doc.id = sec.docente_id\n" +
                    "JOIN alumno_has_seccion as ahs\n" +
                    "ON sec.id = ahs.seccion_id\n" +
                    "JOIN alumno as alum\n" +
                    "ON ahs.alumno_rut = alum.rut\n" +
                    "WHERE alum.rut = '" + rt + "'ORDER by doc.correo asc", null);
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
        Intent i = new Intent(EnviarCorreo.this, com.example.hgmovil.intramovil.view.MenuCorreo.class);
        i.putExtra("Nombre", nm);
        i.putExtra("RuttMenu", rt);
        startActivity(i);
    }
}