package com.example.hgmovil.intramovil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.hgmovil.intramovil.R;

public class MenuCorreo extends AppCompatActivity {

    private ImageButton btnEnviar;
    private String ry, nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_correo);

        ry = getIntent().getStringExtra("RuttMenu");
        nm = getIntent().getStringExtra("Nombre");

        btnEnviar = (ImageButton) findViewById(R.id.BtnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent formnuevo1 = new Intent(MenuCorreo.this, EnviarCorreo.class);
                startActivity(formnuevo1);
                PasarvarCorreo();
            }
        });
    }

    public void PasarvarCorreo() {
        String rt = getIntent().getStringExtra("RuttMenu");
        Intent rt2 = new Intent(this, EnviarCorreo.class);
        rt2.putExtra("Ruttt", rt);
        rt2.putExtra("Nombree", nm);
        startActivity(rt2);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(MenuCorreo.this, com.example.hgmovil.intramovil.view.Menu.class);
        i.putExtra("Nomb", nm);
        i.putExtra("Rutt", ry);
        startActivity(i);
    }
}
