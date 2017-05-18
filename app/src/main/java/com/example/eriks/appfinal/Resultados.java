package com.example.eriks.appfinal;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class Resultados extends Activity implements View.OnClickListener{

    Bundle bundle;
    String img, img2, img3, img4, img5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        bundle = getIntent().getExtras();
        if (bundle == null){
            bundle = new Bundle();
        }

        Button volver = (Button)findViewById(R.id.volver);
        Spinner jornadas = (Spinner)findViewById(R.id.jornadas);
        final ImageView foto = (ImageView)findViewById(R.id.imageView);

        volver.setOnClickListener(this);
        foto.setOnClickListener(this);


        //INSERCIONES EN LA BASE DE DATOS
        //BD
        BD acceso = new BD(this);
        SQLiteDatabase BD = acceso.getWritableDatabase();
        ContentValues DatosInsertar = new ContentValues();

        //Insertamos1
        DatosInsertar.put("COD3",1);
        DatosInsertar.put("JORNADA",1);
        DatosInsertar.put("IMG","R.drawable.j1");

        long err = BD.insert("PARTIDOS", null, DatosInsertar);
        if (err==-1){
            //  Toast.makeText(this, "Ya estaba creada la fila", Toast.LENGTH_LONG).show();
        }

        //Insertamos2
        DatosInsertar.put("COD3",2);
        DatosInsertar.put("JORNADA",2);
        DatosInsertar.put("IMG","R.drawable.j2");

        err = BD.insert("PARTIDOS", null, DatosInsertar);
        if (err==-1){
            // Toast.makeText(this, "Ya estaba creada la fila", Toast.LENGTH_LONG).show();
        }

        //Insertamos3
        DatosInsertar.put("COD3", 3);
        DatosInsertar.put("JORNADA",3);
        DatosInsertar.put("IMG","R.drawable.j3");

        err = BD.insert("PARTIDOS", null, DatosInsertar);
        if (err==-1){
            //  Toast.makeText(this, "Ya estaba creada la fila", Toast.LENGTH_LONG).show();
        }

        //Insertamos4
        DatosInsertar.put("COD3",4);
        DatosInsertar.put("JORNADA",4);
        DatosInsertar.put("IMG","R.drawable.j4");

        err = BD.insert("PARTIDOS", null, DatosInsertar);
        if (err==-1){
            // Toast.makeText(this, "Ya estaba creada la fila", Toast.LENGTH_LONG).show();
        }

        //Insertamos5
        DatosInsertar.put("COD3",5);
        DatosInsertar.put("JORNADA",5);
        DatosInsertar.put("IMG","R.drawable.j5");

        err = BD.insert("PARTIDOS", null, DatosInsertar);
        if (err==-1){
            // Toast.makeText(this, "Ya estaba creada la fila", Toast.LENGTH_LONG).show();
        }

        //SELECCIONO LAS RUTAS DE LAS IMAGENES
        String campos [] = new String [] {"IMG"};
        Cursor cr = BD.query("PARTIDOS", campos, "(COD3 == 1)", null, null, null, null);
        cr.moveToFirst();
        img = cr.getString(cr.getColumnIndex("IMG")).substring(11,cr.getString(cr.getColumnIndex("IMG")).length());

        Cursor cr2 = BD.query("PARTIDOS", campos, "(COD3 == 2)", null, null, null, null);
        cr2.moveToFirst();
        img2 = cr2.getString(cr2.getColumnIndex("IMG")).substring(11,cr2.getString(cr2.getColumnIndex("IMG")).length());

        Cursor cr3 = BD.query("PARTIDOS", campos, "(COD3 == 3)", null, null, null, null);
        cr3.moveToFirst();
        img3 = cr3.getString(cr3.getColumnIndex("IMG")).substring(11,cr3.getString(cr3.getColumnIndex("IMG")).length());

        Cursor cr4 = BD.query("PARTIDOS", campos, "(COD3 == 4)", null, null, null, null);
        cr4.moveToFirst();
        img4 = cr4.getString(cr4.getColumnIndex("IMG")).substring(11,cr4.getString(cr4.getColumnIndex("IMG")).length());

        Cursor cr5 = BD.query("PARTIDOS", campos, "(COD3 == 5)", null, null, null, null);
        cr5.moveToFirst();
        img5 = cr5.getString(cr5.getColumnIndex("IMG")).substring(11,cr5.getString(cr5.getColumnIndex("IMG")).length());


        //COLOCO UNA IMAGEN (PRIMERA JORNADA)

        int ide=getResources().getIdentifier(img,"drawable",getPackageName());
        foto.setImageResource(ide);

        //SPINNER-----------------------------

        String [] Jornadas = {"Jornada 1","Jornada 2","Jornada 3","Jornada 4", "Jornada 5"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Jornadas);
        jornadas.setAdapter(adaptador);

        jornadas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

                if (position == 0) {
                    int ide=getResources().getIdentifier(img,"drawable",getPackageName());
                    foto.setImageResource(ide);
                }
                if (position == 1){
                    int ide=getResources().getIdentifier(img2,"drawable",getPackageName());
                    foto.setImageResource(ide);
                }
                if (position == 2){
                    int ide=getResources().getIdentifier(img3,"drawable",getPackageName());
                    foto.setImageResource(ide);
                }
                if (position == 3){
                    int ide=getResources().getIdentifier(img4,"drawable",getPackageName());
                    foto.setImageResource(ide);
                }
                if (position == 4){
                    int ide=getResources().getIdentifier(img5,"drawable",getPackageName());
                    foto.setImageResource(ide);
                }

               // Toast.makeText(getApplicationContext(), " " + position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }


    @Override
    public void onClick(View v) {

    Intent paso = new Intent(this, Inicio.class);

    switch (v.getId()){
        case R.id.volver:
            paso.putExtras(bundle);
            startActivity(paso);
            finish();
            break;
    }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent pasari = new Intent (this, Inicio.class);
        Intent pasar = new Intent (this, TiendaInicio.class);
        Intent pasar2 = new Intent (this, Resultados.class);
        Intent pasar3 = new Intent (this, Videoteca.class);

        switch (item.getItemId()) {
            case R.id.Opcion:
                pasari.putExtras(bundle);
                startActivity(pasari);
                finish();
                return true;
            case R.id.Opcion1:
                pasar.putExtras(bundle);
                startActivity(pasar);
                finish();
                return true;
            case R.id.Opcion2:
                pasar2.putExtras(bundle);
                startActivity(pasar2);
                finish();
                return true;
            case R.id.Opcion3:
                pasar3.putExtras(bundle);
                startActivity(pasar3);
                finish();
                return true;
            case R.id.Opcion4:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onBackPressed() {
    }


}
