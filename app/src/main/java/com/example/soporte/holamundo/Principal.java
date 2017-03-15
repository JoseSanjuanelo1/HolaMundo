package com.example.soporte.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    private EditText cajaNombre;
    private EditText cajaApellido;
    private Intent i;
    private Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaApellido = (EditText)findViewById(R.id.txtApellido);
        i = new Intent(this,Saludo.class);
        b= new Bundle();

    }


    public void saludar(View v){
        String nom,apel;
        //Se toma el valor que la usuario ingreso tanto en nombra y apellida
        if (validar()){
            nom= cajaNombre.getText().toString();
            apel=cajaApellido.getText().toString();
            //encapsula las valoras tomadas
            b.putString("Nombre", nom);
            b.putString("Apellido",apel);

            i.putExtras(b);
            startActivity(i);
        }


    }

    public boolean validar(){

        if (cajaNombre.getText().toString().isEmpty()){
            cajaNombre.setError(getResources().getString(R.string.error_1));
            //Toast.makeText(getApplicationContext(),"Digite por favor el nombre",Toast.LENGTH_SHORT).show();
            return false;
        }

        if (cajaApellido.getText().toString().isEmpty()){
            cajaApellido.setError(getResources().getString(R.string.error_2));
            //Toast.makeText(getApplicationContext(),"Digite por favor el apellido",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}















