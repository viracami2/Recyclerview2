package com.virra.recyclerview2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by USUARIO on 01/10/2016.
 */

public class card extends AppCompatActivity {

    @Bind(R.id.nombre_perro)
    TextView nombrePerro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_perro);
        ButterKnife.bind(this);

        registerForContextMenu(nombrePerro);
    }


    //para menu de contexto
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto, menu);

    }

    //para menu de contexto
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.meditar:
                Log.e(getLocalClassName(),"clic en editar");

                Toast.makeText( this,"editar",Toast.LENGTH_LONG).show();

                break;
            case R.id.meliminar:
                Log.e(getLocalClassName(),"clic en eliminar");
               // System.out.println("hola eliminar");
               Toast.makeText( this,"eliminar",Toast.LENGTH_LONG).show();
                break;

        }

        return super.onContextItemSelected(item);
    }
}
