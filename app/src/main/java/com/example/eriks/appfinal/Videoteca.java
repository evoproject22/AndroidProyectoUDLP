package com.example.eriks.appfinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Videoteca extends YouTubeBaseActivity {

    Bundle bundle;
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener OnInitializedListener;
    Intent paso;
    String peli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoteca);
        bundle = getIntent().getExtras();
        if (bundle == null){
            bundle = new Bundle();
        }

        Button bn = (Button)findViewById(R.id.bn);
        Button volver = (Button)findViewById(R.id.volver);
        youTubePlayerView = (YouTubePlayerView)findViewById(R.id.youtube);
        paso = new Intent(this, Inicio.class);
        Spinner video = (Spinner)findViewById(R.id.spin);


        final String [] files = {"Ascenso 2015","UD Las Palmas vs Valencia (2017)", "Gol Prince Boateng vs Villarreal"};
        final String[] eleccion = {""};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, files);
        video.setAdapter(adaptador);

        video.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

                if (position == 0) {
                    eleccion[0] = files[0];
                    peli = "oTb42ee6dYU";
                }
                if (position == 1){
                    eleccion[0] = files[1];
                    peli = "2ZCNXRLUZHk";

                }
                if (position == 2){
                    eleccion[0] = files[2];
                    peli = "ssoxmXoBll8";
                }


                //Toast.makeText(getApplicationContext(), "Ha pulsado el item " + position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        volver.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                paso.putExtras(bundle);
                startActivity(paso);
                finish();


            }} );

        OnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(peli);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        bn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                youTubePlayerView.initialize(PlayerConfig.API_KEY, OnInitializedListener);

            }
        });


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
