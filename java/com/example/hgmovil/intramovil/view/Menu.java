package com.example.hgmovil.intramovil.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hgmovil.intramovil.R;

/**
 * Created by pablo on 27-04-2016.
 */
public class Menu extends AppCompatActivity {
    private ImageButton BtnNot;
    private ImageButton BtnAsis;
    private ImageButton BtnHora;
    private ImageButton BtnCorr;
    private ImageButton BtnBusc;
    private ImageButton BtnAlarm;
    private ImageButton BtnREsumen;
    private ImageButton BtnPag;
    private ImageButton BtnMat;
    private Button btnLogOut;
    final String TAG = this.getClass().getName();
    private boolean twice = false;
    private String nom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        BtnNot = (ImageButton) findViewById(R.id.BtnNotas);
        nom = getIntent().getStringExtra("Nomb");

        TextView tv = (TextView) findViewById(R.id.txtUser);
        tv.setText(nom);


        BtnNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menunotas = new Intent(Menu.this, MenuNot.class);
                startActivity(menunotas);
                PasarvarMenunot();
            }
        });

        BtnAsis = (ImageButton) findViewById(R.id.BtnAsistencia);

        BtnAsis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent menuasis = new Intent(Menu.this, MenuAsist.class);
                startActivity(menuasis);
                PasarvarMenuasit();
            }
        });
        BtnREsumen = (ImageButton) findViewById(R.id.BtnResAc);
        BtnREsumen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent formnuevo5 = new Intent(Menu.this, MenuResu.class);
                startActivity(formnuevo5);
                PasarvarMenuResu();
            }
        });

        BtnHora = (ImageButton) findViewById(R.id.BtnHorario);

        BtnHora.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent formnuevo1 = new Intent(Menu.this, MenuHorario.class);
                startActivity(formnuevo1);
                PasarvarMenuHorario();
            }
        });
        BtnCorr = (ImageButton) findViewById(R.id.BtnCorreos);
        BtnCorr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent formnuevo2 = new Intent(Menu.this, MenuCorreo.class);
                startActivity(formnuevo2);
                PasarvarCorreo();
            }
        });
        BtnBusc = (ImageButton) findViewById(R.id.BtnBusquet);
        BtnBusc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent formnuevo3 = new Intent(Menu.this, MenuSala.class);
                startActivity(formnuevo3);
            }
        });
        BtnAlarm = (ImageButton) findViewById(R.id.BtnAlam);
        BtnAlarm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent formnuevo4 = new Intent(Menu.this, MenuAlarma.class);
                startActivity(formnuevo4);
            }
        });

        BtnPag = (ImageButton) findViewById(R.id.BtnPag);
        BtnPag.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent formnuevo6 = new Intent(Menu.this, MenuPago.class);
                startActivity(formnuevo6);
                PasarvarMenuPago();
            }
        });
        BtnMat = (ImageButton) findViewById(R.id.BtnMateriales);
        BtnMat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent formnuevo7 = new Intent(Menu.this, MenuMat.class);
                startActivity(formnuevo7);
                PasarvarMenuMat();
            }
        });

        btnLogOut = (Button) findViewById(R.id.btnSalir);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final AlertDialog.Builder asitencias = new AlertDialog.Builder(Menu.this);
                asitencias.setTitle("ADVERTENCIA");
                asitencias.setMessage("Esta seguro que quieres" + "\n" + "cerrar sesion");
                asitencias.setPositiveButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setNegativeButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent frmnuevo8 = new Intent(Menu.this, LoginActivity.class);
                        startActivity(frmnuevo8);
                    }
                });
                asitencias.show();
            }
        });

    }

    public void PasarvarMenunot() {
        String rt = getIntent().getStringExtra("Rutt");
        Intent rt2 = new Intent(this, MenuNot.class);
        rt2.putExtra("RuttMenu", rt);
        rt2.putExtra("Nombre", nom);
        startActivity(rt2);

    }

    @Override
    public void onBackPressed() {
        if (twice == true) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(intent.CATEGORY_HOME);
            intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);
        }

        Log.d(TAG, "twice: " + twice);

        Toast.makeText(getApplicationContext(), "Pulse atras nuevamente para salir", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                twice = false;
                Log.d(TAG, "twice " + twice);
            }
        }, 3000);
        twice = true;
    }

    public void PasarvarMenuasit() {
        String rt = getIntent().getStringExtra("Rutt");
        Intent rt2 = new Intent(this, MenuAsist.class);
        rt2.putExtra("RuttMenu", rt);
        rt2.putExtra("Nombre", nom);
        startActivity(rt2);

    }

    public void PasarvarMenuResu() {
        String rt = getIntent().getStringExtra("Rutt");
        Intent rt2 = new Intent(this, MenuResu.class);
        rt2.putExtra("RuttMenu", rt);
        rt2.putExtra("Nombre", nom);
        startActivity(rt2);
    }

    public void PasarvarMenuPago() {
        String rt = getIntent().getStringExtra("Rutt");
        Intent rt2 = new Intent(this, MenuPago.class);
        rt2.putExtra("RuttMenu", rt);
        rt2.putExtra("Nombre", nom);
        startActivity(rt2);
    }

    public void PasarvarMenuHorario() {
        String rt = getIntent().getStringExtra("Rutt");
        Intent rt2 = new Intent(this, MenuHorario.class);
        rt2.putExtra("RuttMenu", rt);
        rt2.putExtra("Nombre", nom);
        startActivity(rt2);
    }

    public void PasarvarMenuMat() {
        String rt = getIntent().getStringExtra("Rutt");
        Intent rt2 = new Intent(this, MenuMat.class);
        rt2.putExtra("RuttMenu", rt);
        rt2.putExtra("Nombre", nom);
        startActivity(rt2);
    }

    public void PasarvarCorreo() {
        String rt = getIntent().getStringExtra("Rutt");
        Intent rt2 = new Intent(this, MenuCorreo.class);
        rt2.putExtra("RuttMenu", rt);
        rt2.putExtra("Nombre", nom);
        startActivity(rt2);
    }
}
