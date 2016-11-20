package com.virra.recyclerview2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_reclycerview extends Fragment {
    ArrayList<Perro> perros;
    RecyclerView reciclermascotas;
    PerroAdaptador adaptador;

    public Fragment_reclycerview() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        perros = new ArrayList<Perro>();
        View v= inflater.inflate (R.layout.fragment_fragment_reclycerview, container, false);
        reciclermascotas = (RecyclerView) v.findViewById(R.id.reciclermascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        reciclermascotas.setLayoutManager(llm);

        perros.add(new Perro(R.drawable.images, "Perro1", "5"));
        perros.add(new Perro(R.drawable.perro, "perro", "4"));
        perros.add(new Perro(R.drawable.perro2, "perro2", "6"));
        perros.add(new Perro(R.drawable.perro3, "perro3", "7"));
        perros.add(new Perro(R.drawable.perro4, "perro4", "2"));

        adaptador = new PerroAdaptador(perros, getActivity());
        reciclermascotas.setAdapter(adaptador);
        //recyclermascotas.getAdapter(adaptador);
        return v;
    }

}
