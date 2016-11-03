package com.example.hgmovil.intramovil.view;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hgmovil.intramovil.R;
import com.example.hgmovil.intramovil.sqlite.BDIntraMovil;

import java.util.ArrayList;

public class MenuSala extends AppCompatActivity implements View.OnClickListener {
    private Button btn;
    private Spinner spn;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_sala);

        btn = (Button) findViewById(R.id.btnBusqueda);
        spn = (Spinner) findViewById(R.id.spnSala);


        ArrayList<String> emp = ListaSala();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, emp);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        cargaSala();
        Toast.makeText(getApplicationContext(), "Operación realizada...", Toast.LENGTH_SHORT).show();

    }

    public void cargaSala() {
        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        String ss = spn.getSelectedItem().toString();
        helper.openDataBase();
        Cursor c = db.rawQuery("SELECT piso FROM sala WHERE Nombre='" + ss + "';", null);
        try {
            if (c.moveToFirst()) {
                String pi = c.getString(0);
                if (pi.equals("3")) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.piso33);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("4")) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.piso4);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("5")) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.piso5);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
            }
            c.close();
            helper.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            helper.close();
        }
    }

    public ArrayList<String> ListaSala() {
        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        ArrayList<String> dev = null;
        try {
            helper.openDataBase();
            dev = new ArrayList<String>();
            Cursor c = db.rawQuery("SELECT nombre FROM sala ORDER BY nombre ASC", null);
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
}

