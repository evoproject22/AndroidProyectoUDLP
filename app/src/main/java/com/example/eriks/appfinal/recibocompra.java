package com.example.eriks.appfinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class recibocompra extends Activity implements View.OnClickListener {
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibocompra);
        bundle = new Bundle();

        Button inicio = (Button)findViewById(R.id.inicio);
        inicio.setOnClickListener(this);

        TextView codigo = (TextView)findViewById(R.id.codigo);
        ImageView ud = (ImageView)findViewById(R.id.udd);
        ud.setImageResource(R.drawable.ud);

        int aleatorio = (int)(Math.random() * 100) + 1;
        codigo.setText(String.valueOf(aleatorio));

}
    @Override
    public void onClick(View v) {
        Intent paso = new Intent(this, Inicio.class);

        switch(v.getId()){
            case R.id.inicio:
                paso.putExtras(bundle);
                startActivity(paso);
                finish();
                break;
        }

    }
    public void onBackPressed() {
    }
}
