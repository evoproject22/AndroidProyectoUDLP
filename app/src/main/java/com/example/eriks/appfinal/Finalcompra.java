package com.example.eriks.appfinal;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Finalcompra extends Activity implements View.OnClickListener{

    Bundle bundle;
    ContentValues DatosInsertar;
    BD acceso;
    SQLiteDatabase BD;
    EditText nombre, apellidos, email, dni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalcompra);
        bundle = getIntent().getExtras();
        if (bundle == null){
            bundle = new Bundle();
        }

        Button cesta = (Button)findViewById(R.id.cesta);
        Button facturar = (Button)findViewById(R.id.factura);
        nombre = (EditText) findViewById(R.id.nombre);
        apellidos = (EditText) findViewById(R.id.apellidos);
        email = (EditText) findViewById(R.id.email);
        dni = (EditText) findViewById(R.id.dni);
        TextView dinero = (TextView)findViewById(R.id.dinero);

        cesta.setOnClickListener(this);
        facturar.setOnClickListener(this);
        nombre.setOnClickListener(this);
        apellidos.setOnClickListener(this);
        email.setOnClickListener(this);
        dni.setOnClickListener(this);

        dinero.setText(String.valueOf(bundle.getInt("total")) + "€");


        //VAMOS CON LA BD
        acceso = new BD(this);
        BD = acceso.getWritableDatabase();
        DatosInsertar = new ContentValues();



    }

    @Override
    public void onClick(View v) {

        Intent paso = new Intent (this, comprar.class);


        switch (v.getId()){
            case R.id.cesta:
                paso.putExtras(bundle);
                startActivity(paso);
                finish();
                break;
            case R.id.factura:
                if (String.valueOf(nombre.getText()).equals("")) {
                    Toast.makeText(getApplicationContext(), "Inserte su nombre", Toast.LENGTH_LONG).show();
                } else if(String.valueOf(dni.getText()).equals("")){
                    Toast.makeText(getApplicationContext(), "Inserte su DNI para identificarle", Toast.LENGTH_LONG).show();
                } else {

                    DatosInsertar.put("NOMBRE", String.valueOf(nombre.getText()));
                    DatosInsertar.put("APELLIDOS", String.valueOf(apellidos.getText()));
                    DatosInsertar.put("DNI", String.valueOf(dni.getText()));
                    DatosInsertar.put("EMAIL", String.valueOf(email.getText()));

                    long err = BD.insert("CLIENTES", null, DatosInsertar);
                    if (err == -1) {
                        Toast.makeText(getApplicationContext(), "¡ Ya estabas dado de alta !, Gracias por su compra " + String.valueOf(nombre.getText()), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Nuevo Registro, Gracias por su compra " + String.valueOf(nombre.getText()), Toast.LENGTH_LONG).show();
                    }

                    Intent paso2 = new Intent(this, recibocompra.class);
                    paso2.putExtras(bundle);
                    startActivity(paso2);
                    finish();
                }
                    break;

        }

    }
    public void onBackPressed() {
    }
}
