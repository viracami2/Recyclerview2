package com.virra.recyclerview2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    ArrayList<Perro> perros;
    @Bind(R.id.reciclermascotas)
    RecyclerView reciclermascotas;
    @Bind(R.id.estrella)
    ImageView estrella;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        perros = new ArrayList<Perro>();


        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        reciclermascotas.setLayoutManager(llm);

        perros.add(new Perro(R.drawable.images, "Perro1", "5"));
        perros.add(new Perro(R.drawable.perro, "perro", "4"));
        perros.add(new Perro(R.drawable.perro2, "perro2", "6"));
        perros.add(new Perro(R.drawable.perro3, "perro3", "7"));
        perros.add(new Perro(R.drawable.perro4, "perro4", "2"));


        PerroAdaptador adaptador = new PerroAdaptador(perros, this);
        reciclermascotas.setAdapter(adaptador);
        //recyclermascotas.getAdapter(adaptador);


    }

    @OnClick(R.id.estrella)
    public void onClick() {
        Intent in = new Intent(this,MascotasFavoritas.class);
        in.putExtra("nombre","holos");
        this.startActivity(in);
    }
}
