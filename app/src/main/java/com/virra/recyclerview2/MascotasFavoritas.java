package com.virra.recyclerview2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MascotasFavoritas extends AppCompatActivity {

    @Bind(R.id.textView)
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);
        ButterKnife.bind(this);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Bundle parametros = getIntent().getExtras();
        String nom = parametros.getString("nombre");

        textView.setText(nom);


    }

}
