package com.example.eriks.appfinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ticket extends Activity implements View.OnClickListener{
    Bundle bundle;
    Editable numentradas;
    String s1 = "";
    int precio,tickets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        bundle = getIntent().getExtras();
        if (bundle == null){
            bundle = new Bundle();
        }

        Button volver = (Button)findViewById(R.id.volver);
        Button cesta = (Button)findViewById(R.id.cesta);
        Button añadir = (Button)findViewById(R.id.añadir);
        EditText number = (EditText)findViewById(R.id.numentradas);
        Spinner zona = (Spinner)findViewById(R.id.spinner);
        ImageView precios = (ImageView)findViewById(R.id.imageView4);
        ImageButton borrar = (ImageButton) findViewById(R.id.borrar);

        borrar.setOnClickListener(this);
        volver.setOnClickListener(this);
        cesta.setOnClickListener(this);
        añadir.setOnClickListener(this);
        precios.setOnClickListener(this);


        precios.setImageResource(R.drawable.precios);
        borrar.setImageResource(R.drawable.x);

        //SPINNER-----------------------------

       final String [] zonas = {"Sur","Curva","Tribuna","Naciente"};
        final String[] eleccion = {""};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, zonas);
        zona.setAdapter(adaptador);

        zona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

                if (position == 0) {
                    eleccion[0] = zonas[0];
                    precio = 25;
                }
                if (position == 1){
                    eleccion[0] = zonas[1];
                    precio = 22;
                }
                if (position == 2){
                    eleccion[0] = zonas[2];
                    precio = 35;
                }
                if (position == 3){
                    eleccion[0] = zonas[3];
                    precio = 20;
                }

               //Toast.makeText(getApplicationContext(), "Ha pulsado el item " + position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        numentradas = number.getText();

        añadir.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                if(!String.valueOf(numentradas).equals("") && !String.valueOf(numentradas).equals("0")) {
                    tickets = Integer.parseInt(String.valueOf(numentradas));
                    s1 = numentradas + " entradas en " + eleccion[0];
                    Toast.makeText(getApplicationContext(), "Has insertado en la cesta: " + s1, Toast.LENGTH_SHORT).show();
                    bundle.putString("entrada", s1);
                    bundle.putInt("pt",(precio*tickets));
                } else{
                    Toast.makeText(getApplicationContext(), "Inserte la cantidad de entradas", Toast.LENGTH_SHORT).show();
                }

            }} );



    }


    public void onBackPressed() {
    }

    @Override
    public void onClick(View v) {
        Intent paso = new Intent (this, TiendaInicio.class);
        Intent paso2 = new Intent (this, comprar.class);

        switch (v.getId()){
            case R.id.volver:
                paso.putExtras(bundle);
                startActivity(paso);
                finish();
                break;
            case R.id.cesta:
                paso2.putExtras(bundle);
                startActivity(paso2);
                finish();
                break;
            case R.id.borrar:
                bundle.putString("entrada",null);
                bundle.putInt("pt", 0);
                Toast.makeText(getApplicationContext(),"Has deseleccionado las entradas", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
