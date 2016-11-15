package com.virra.recyclerview2;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by USUARIO on 20/09/2016.
 */

public class PerroAdaptador  extends  RecyclerView.Adapter<PerroAdaptador.PerroViewHolder> {
ArrayList <Perro> perros;
    Activity activity;
    String  a;

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


        holder.foto_perro.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(activity,perro.getNombre(),Toast.LENGTH_LONG).show();

                return false;
            }
        });



        holder.setLongClickListener(new LongClickListener() {
            @Override
            public void onItemLongClick(int pos) {
                Toast.makeText(activity,perros.get(pos).getNombre(),Toast.LENGTH_SHORT).show();
                a= perros.get(3).getNombre();
            }
        });






    }




    @Override
    public int getItemCount() {
        return perros.size();
    }


    public void getItemSelected(MenuItem item){


        if (item.getItemId()==0) {
            Toast.makeText(activity, "editar"+item.getItemId(), Toast.LENGTH_SHORT).show();


        }if(item.getItemId()==1) {
            int  a =item.getItemId();

            Toast.makeText(activity, item.getTitle() + "xdddd : " + a, Toast.LENGTH_SHORT).show();

        }
    }


    public static  class PerroViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener,View.OnCreateContextMenuListener{
            private TextView nombre;
            private TextView megusta;
            private ImageView foto_perro;
            LongClickListener longClickListener;



        public PerroViewHolder(View itemView ){
            super(itemView);
            nombre = (TextView)itemView.findViewById(R.id.nombre_perro);
            megusta = (TextView)itemView.findViewById(R.id.numero_me_gusta);
            foto_perro = (ImageView) itemView.findViewById(R.id.imgperro);

            itemView.setOnLongClickListener(this);
            //itemView.setOnCreateContextMenuListener(this);



            nombre.setOnCreateContextMenuListener(this);
                    }

        public void setLongClickListener (LongClickListener lc) {
              this.longClickListener=lc;
        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

            menu.setHeaderTitle("Select The Action");
            menu.add(0,0, 1,R.string.menu_about);//groupId, itemId, order, title
            menu.add(0, 1, 2,"Eliminar");
           }


        @Override
        public boolean onLongClick(View v) {
            this.longClickListener.onItemLongClick(getLayoutPosition());
            return false;
        }
    }


    }

