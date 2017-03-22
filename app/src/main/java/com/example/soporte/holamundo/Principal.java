package com.example.soporte.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Principal extends AppCompatActivity {

    private EditText cajaNombre;
    private EditText cajaApellido;
    private Spinner comboGenero;
    private RadioButton r1, r2, r3;
    private ArrayAdapter<String>adapter;
    private String[] opc;
    private Intent i;
    private Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaApellido = (EditText)findViewById(R.id.txtApellido);
        comboGenero = (Spinner) findViewById(R.id.cmbGenero);
        r1 = (RadioButton)findViewById(R.id.r1);
        r2 = (RadioButton)findViewById(R.id.r2);
        r3 = (RadioButton)findViewById(R.id.r3);

        i = new Intent(this,Saludo.class);
        //encapsula
        b= new Bundle();

        //String []opc ={"Masculino","Femenino"};
        opc = this.getResources().getStringArray(R.array.generos);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc);
        comboGenero.setAdapter(adapter);

    }


    public void saludar(View v){
        String nom,apel, genero, estado_civil="";
        //Se toma el valor que la usuario ingreso tanto en nombra y apellida
        if (validar()){
            nom= cajaNombre.getText().toString();
            apel=cajaApellido.getText().toString();
            //encapsula las valoras tomadas

            genero= comboGenero.getSelectedItem().toString();

            if(r1.isChecked()) estado_civil = getResources().getString(R.string.soltero);
            if(r2.isChecked()) estado_civil = getResources().getString(R.string.casado);
            if(r3.isChecked()) estado_civil = getResources().getString(R.string.divorciado);

            b.putString("Nombre", nom);
            b.putString("Apellido",apel);
            b.putString("Genero",genero);
            b.putString("Estado_civil",estado_civil);

            i.putExtras(b);
            startActivity(i);
        }


    }

    public void borrar(View v){
        cajaNombre.setText("");
        cajaNombre.requestFocus();
        cajaApellido.setText("");
        comboGenero.setSelection(0);
        r1.setChecked(true);
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















