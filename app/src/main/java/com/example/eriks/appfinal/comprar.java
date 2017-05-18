package com.example.eriks.appfinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class comprar extends Activity implements View.OnClickListener{
    Bundle bundle;
    TextView productos,precio;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);
        bundle = getIntent().getExtras();
        if (bundle == null){
            bundle = new Bundle();
        }

        Button volver = (Button)findViewById(R.id.volver);
        Button siguiente = (Button)findViewById(R.id.siguiente);
        Button vaciar = (Button) findViewById(R.id.vaciar);
        productos = (TextView) findViewById(R.id.productos);
        precio = (TextView) findViewById(R.id.precio);

        volver.setOnClickListener(this);
        siguiente.setOnClickListener(this);
        vaciar.setOnClickListener(this);



        total = (bundle.getInt("pc1") + bundle.getInt("pc2") +bundle.getInt("pc3") +bundle.getInt("pe1") +bundle.getInt("pe2") +
                bundle.getInt("pe3") +bundle.getInt("po1") +bundle.getInt("po2") +bundle.getInt("po3") +bundle.getInt("pt"));

        //AÑADIENDO LOS PRODUCTOS EN LA CESTA
        if(bundle.getString("camisa1") != null){
            productos.append(bundle.getString("camisa1") + "\n");
        }
        if(bundle.getString("camisa2") != null){
            productos.append(bundle.getString("camisa2") + "\n");
        }
        if(bundle.getString("camisa3") != null){
            productos.append(bundle.getString("camisa3") + "\n");
        }
        if(bundle.getString("equipajes1") != null){
            productos.append(bundle.getString("equipajes1") + "\n");
        }
        if(bundle.getString("equipajes2") != null){
            productos.append(bundle.getString("equipajes2")+ "\n");
        }
        if(bundle.getString("equipajes3") != null){
            productos.append(bundle.getString("equipajes3")+ "\n");
        }
        if(bundle.getString("otros1") != null){
            productos.append(bundle.getString("otros1")+ "\n");
        }
        if(bundle.getString("otros2") != null){
            productos.append(bundle.getString("otros2")+ "\n");
        }
        if(bundle.getString("otros3") != null){
            productos.append(bundle.getString("otros3")+ "\n");
        }
        if(bundle.getString("entrada") != null){
            productos.append(bundle.getString("entrada")+ "\n");
        }

        precio.setText(String.valueOf(total) + "€");
        bundle.putInt("total", total);

    }


    @Override
    public void onClick(View v) {

        Intent paso = new Intent (this, productos.class);
        Intent paso2 = new Intent (this, Finalcompra.class);

        switch (v.getId()){
            case R.id.volver:
                paso.putExtras(bundle);
                startActivity(paso);
                finish();
                break;
            case R.id.siguiente:
                if (total !=  0) {
                    paso2.putExtras(bundle);
                    startActivity(paso2);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Debe seleccionar mínimo un producto", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.vaciar:
                bundle = null;
                bundle = new Bundle();
                productos.setText("");
                precio.setText("0€");
                Toast.makeText(getApplicationContext(), "Has vaciado la cesta", Toast.LENGTH_LONG).show();
                break;
        }

    }
    public void onBackPressed() {
    }
}
