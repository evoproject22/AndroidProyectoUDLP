package com.example.eriks.appfinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class TiendaInicio extends Activity implements View.OnClickListener {

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda_inicio);
        bundle = getIntent().getExtras();
        if (bundle == null){
            bundle = new Bundle();
        }

        ImageButton productos = (ImageButton)findViewById(R.id.productos);
        ImageButton ticket = (ImageButton)findViewById(R.id.tickets);
        Button comprar = (Button)findViewById(R.id.comprar);
        Button volver = (Button)findViewById(R.id.volver);
        ImageView titulo = (ImageView)findViewById(R.id.imageView2);

        productos.setOnClickListener(this);
        ticket.setOnClickListener(this);
        comprar.setOnClickListener(this);
        volver.setOnClickListener(this);
        titulo.setOnClickListener(this);


        productos.setImageResource(R.drawable.productostitulo);
        ticket.setImageResource(R.drawable.tickettitulo);
        titulo.setImageResource(R.drawable.tienditatitulo);




    }

    @Override
    public void onClick(View v) {

        Intent pasar = new Intent (this, productos.class);
        Intent pasar2 = new Intent (this, ticket.class);
        Intent pasar3 = new Intent (this, comprar.class);
        Intent pasar4 = new Intent (this, Inicio.class);

        switch (v.getId()){

            case R.id.productos:
                pasar.putExtras(bundle);
                startActivity(pasar);
                finish();

                break;
            case R.id.tickets:
                pasar2.putExtras(bundle);
                startActivity(pasar2);
                finish();

                break;
            case R.id.comprar:
                pasar3.putExtras(bundle);
                startActivity(pasar3);
                finish();

                break;
            case R.id.volver:
                pasar4.putExtras(bundle);
                startActivity(pasar4);
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
