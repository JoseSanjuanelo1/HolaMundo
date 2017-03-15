package com.example.soporte.holamundo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Saludo extends AppCompatActivity {

    private TextView saludo;
    private Bundle b;
    private String aux, nom, apell;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);
        saludo = (TextView)findViewById(R.id.txtSaludo);
        b = getIntent().getExtras();
        nom = b.getString("Nombre");
        apell = b.getString("Apellido");
        res = this.getResources();

        aux= res.getString(R.string.parte_saludo)+" "+nom+" "+apell+" "+res.getString(R.string.parte_saludo2);
        saludo.setText(aux);


    }
}
