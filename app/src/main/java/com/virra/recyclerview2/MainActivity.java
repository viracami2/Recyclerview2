package com.virra.recyclerview2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    PerroAdaptador adaptador;


    @Bind(R.id.barra)
    AppBarLayout barra;

    @Bind(R.id.viewPager)
    ViewPager viewPager;

    @Bind(R.id.tablayout)
    TabLayout tablayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        SetupViewPager();


    }


    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fragment_reclycerview());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    public void SetupViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tablayout.setupWithViewPager(viewPager);

        tablayout.getTabAt(0).setIcon(R.drawable.estrella);
        tablayout.getTabAt(1).setIcon(R.drawable.dog_50);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.macerca_de:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.facebook.com/victorcastro.irresistiblementecosteno"));
                startActivity(intent);
                break;
            case R.id.mconfiguracion:
                Intent inn = new Intent(this, Contacto.class);
               // in.putExtra("nombre", "hola que hace?");
                Log.e(getLocalClassName(),"VA A ENTRAR!!!");
                startActivity(inn);

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        adaptador.getItemSelected(item);
        return super.onContextItemSelected(item);
    }

    @OnClick(R.id.estrella)
    public void onClick() {
        Intent in = new Intent(this, MascotasFavoritas.class);
        in.putExtra("nombre", "hola que hace?");
        Log.e(getLocalClassName(),"clic en estrella");
        startActivity(in);
    }

}

