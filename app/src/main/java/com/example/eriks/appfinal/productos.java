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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class productos extends Activity implements View.OnClickListener {

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        bundle = getIntent().getExtras();
        if (bundle == null){
            bundle = new Bundle();
        }

        ImageButton camisetas = (ImageButton)findViewById(R.id.camiseta);
        ImageButton equipaje = (ImageButton)findViewById(R.id.equipaje);
        ImageButton compl = (ImageButton)findViewById(R.id.compl);
        Button volver = (Button)findViewById(R.id.volver);
        Button facturar = (Button)findViewById(R.id.facturar);

        volver.setOnClickListener(this);
        facturar.setOnClickListener(this);
        camisetas.setOnClickListener(this);
        equipaje.setOnClickListener(this);
        compl.setOnClickListener(this);

        camisetas.setImageResource(R.drawable.camisetastitulo);
        equipaje.setImageResource(R.drawable.equipajestitulo);
        compl.setImageResource(R.drawable.complementostitulo);





    }

    @Override
    public void onClick(View v) {

        Intent paso = new Intent (this, TiendaInicio.class);
        Intent paso2 = new Intent (this, comprar.class);
        Intent paso3 = new Intent (this, Camisetas.class);
        Intent paso4 = new Intent (this, equipajes.class);
        Intent paso5 = new Intent (this, otros.class);

        switch (v.getId()){
            case R.id.volver:
                paso.putExtras(bundle);
                startActivity(paso);
                finish();
                break;
            case R.id.facturar:
                paso2.putExtras(bundle);
                startActivity(paso2);
                finish();
                break;
            case R.id.camiseta:
                paso3.putExtras(bundle);
                startActivity(paso3);
                finish();
                break;
            case R.id.equipaje:
                paso4.putExtras(bundle);
                startActivity(paso4);
                finish();
                break;
            case R.id.compl:
                paso5.putExtras(bundle);
                startActivity(paso5);
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
                startActivity(pasari);
                finish();
                return true;
            case R.id.Opcion1:
                startActivity(pasar);
                finish();
                return true;
            case R.id.Opcion2:
                startActivity(pasar2);
                finish();
                return true;
            case R.id.Opcion3:
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
