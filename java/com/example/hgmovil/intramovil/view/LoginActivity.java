package com.example.hgmovil.intramovil.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hgmovil.intramovil.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends Activity {

    EditText rut, contraseña;
    String Rut, Contraseña;
    Context ctx = this;
    ProgressDialog pdialog = null;
    String NOMBRE = null;
    Context context = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        rut = (EditText) findViewById(R.id.main_name);
        contraseña = (EditText) findViewById(R.id.main_password);
        context = this;
    }

    // public void main_register(View v){
    //   startActivity(new Intent(this,Register.class));
    //}

    public void main_login(View v) {
        Rut = rut.getText().toString();
        Contraseña = contraseña.getText().toString();
        BackGround b = new BackGround();
        if (Rut.equals("") || Contraseña.equals("")) {
            Toast.makeText(ctx, "Inserte campos validos", Toast.LENGTH_LONG).show();

        } else {
            b.execute(Rut, Contraseña);
            pdialog = ProgressDialog.show(context, "", "CONECTANDO...", true);
        }


    }

    class BackGround extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            String rut1 = params[0];
            String contraseña1 = params[1];
            String data = "";
            int tmp;

            try {
                URL url = new URL("http://www.intramovil.hol.es/login.php");
                String urlParams = "name=" + rut1 + "&password=" + contraseña1;
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                os.write(urlParams.getBytes());
                os.flush();
                os.close();

                InputStream is = httpURLConnection.getInputStream();
                while ((tmp = is.read()) != -1) {
                    data += (char) tmp;
                }

                is.close();
                httpURLConnection.disconnect();

                return data;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {

            String RUT = null, CONTRASEÑA = null;
            pdialog.dismiss();
            try {
                JSONObject root = new JSONObject(s);
                JSONObject user_data = root.getJSONObject("user_data");
                NOMBRE = user_data.getString("nombre");
                RUT = user_data.getString("rut");
                CONTRASEÑA = user_data.getString("contraseña");

                if (RUT.equals("") || CONTRASEÑA.equals("") || RUT.equals(null) || CONTRASEÑA.equals(null)) {

                    Toast.makeText(ctx, "Rut y contraseña incorrectos ", Toast.LENGTH_LONG).show();

                } else {

                    Intent i = new Intent(ctx, Menu.class);
                    i.putExtra("Nomb", NOMBRE);
                    i.putExtra("Rutt", RUT);
                    startActivity(i);
                }


                //CORREO= user_data.getString("correo");
                //CARRERA_ID= user_data.getString("carrera_id");
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(ctx, "Rut y contraseña incorrectos ", Toast.LENGTH_LONG).show();
            }


        }
    }

}

