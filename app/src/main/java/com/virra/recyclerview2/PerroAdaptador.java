package com.virra.recyclerview2;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by USUARIO on 20/09/2016.
 */

public class PerroAdaptador  extends  RecyclerView.Adapter<PerroAdaptador.PerroViewHolder>{
ArrayList <Perro> perros;
    Activity activity;

    public PerroAdaptador(ArrayList<Perro> perros,Activity activity) {
        this.activity = activity;
        this.perros = perros;
    }

    @Override
    public PerroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perro,parent,false);
        return new PerroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PerroViewHolder holder, int position) {
        final Perro perro=perros.get(position);

        holder.nombre.setText(perro.getNombre());
        holder.megusta.setText(perro.getMegusta());
        holder.foto_perro.setImageResource(perro.getFoto());


    }

    @Override
    public int getItemCount() {
        return perros.size();
    }

    public static  class PerroViewHolder extends RecyclerView.ViewHolder{
            private TextView nombre;
            private TextView megusta;
            private ImageView foto_perro;



        public PerroViewHolder(View itemView ){
            super(itemView);
            nombre = (TextView)itemView.findViewById(R.id.nombre_perro);
            megusta = (TextView)itemView.findViewById(R.id.numero_me_gusta);
            foto_perro = (ImageView) itemView.findViewById(R.id.imgperro);



        }


    }
}
