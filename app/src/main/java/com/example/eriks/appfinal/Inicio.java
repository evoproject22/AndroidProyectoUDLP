package com.example.eriks.appfinal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Inicio extends Activity implements View.OnClickListener{

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        bundle = getIntent().getExtras();
        if (bundle == null){
            bundle = new Bundle();
        }

        ImageButton tienda = (ImageButton)findViewById(R.id.tienda);
        ImageButton resultados = (ImageButton)findViewById(R.id.resultados);
        ImageButton videoteca = (ImageButton)findViewById(R.id.videoteca);
        ImageButton udradio = (ImageButton)findViewById(R.id.udradio);


        tienda.setOnClickListener(this);
        resultados.setOnClickListener(this);
        videoteca.setOnClickListener(this);
        udradio.setOnClickListener(this);


        tienda.setImageResource(R.drawable.tiendatitulo);
        resultados.setImageResource(R.drawable.resultadostitulo);
        videoteca.setImageResource(R.drawable.videotecatitulo);
        udradio.setImageResource(R.drawable.udradio);


        udradio.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                String link = "http://www.udlaspalmas.es/udradio";
                Intent intent = null;
                intent = new Intent(intent.ACTION_VIEW, Uri.parse(link));
                startActivity(intent);

            }} );


    }





    @Override
    public void onClick(View v) {

        Intent pasar = new Intent (this, TiendaInicio.class);
        Intent pasar2 = new Intent (this, Resultados.class);
        Intent pasar3 = new Intent (this, Videoteca.class);

    switch (v.getId()){

        case R.id.tienda:
            pasar.putExtras(bundle);
            startActivity(pasar);
            finish();

            break;
        case R.id.resultados:
            pasar2.putExtras(bundle);
            startActivity(pasar2);
            finish();

            break;
        case R.id.videoteca:
            pasar3.putExtras(bundle);
            startActivity(pasar3);
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
