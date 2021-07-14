package com.cocina.cocinafacil;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class ActivityMenu extends AppCompatActivity {

    private ArrayList<Receta_ListView> recetas;
    private ListView vista;
    private AdView adViewMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().hide();
        recetas = new ArrayList<Receta_ListView>();
        vista = findViewById(R.id.LW_recetas);
        adViewMenu = findViewById(R.id.adViewMenu);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        adViewMenu.loadAd(adRequest);

        /* FORMA PARA UTILIZAR LA BASE DE DATOS
        DatabaseManager database = DatabaseManager.getInstance(getApplicationContext());
        database.open();
        int i = 1;
        String nombre;
        while(i != database.getCantidadRegistros())
        {
            nombre = database.getNombre(i);

            i++;
        }

        database.close();
        */
        recetas.add(new Receta_ListView("CARNES", R.mipmap.g281));
        recetas.add(new Receta_ListView("POLLO", R.mipmap.g281));
        recetas.add(new Receta_ListView("PESCADO", R.mipmap.g281));
        recetas.add(new Receta_ListView("ENSALADAS", R.mipmap.g281));
        recetas.add(new Receta_ListView("SALSAS", R.mipmap.g281));
        recetas.add(new Receta_ListView("PASTAS", R.mipmap.g281));
        recetas.add(new Receta_ListView("ARROZ", R.mipmap.g281));
        recetas.add(new Receta_ListView("BATIDOS", R.mipmap.g281));
        recetas.add(new Receta_ListView("COMIDAS FRIAS", R.mipmap.g281));
        recetas.add(new Receta_ListView("POSTRES", R.mipmap.g281));
        recetas.add(new Receta_ListView("PANIFICADOS", R.mipmap.g281));

        vista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ActivityMenu.this, MuestraCategoria.class);
                switch (position)
                {
                    case 0:
                        i.putExtra("CATEGORIA", "carnes" );
                        break;
                    case 1:
                        i.putExtra("CATEGORIA", "pollo" );
                        break;
                    case 2:
                        i.putExtra("CATEGORIA", "pescado" );
                        break;
                    case 3:
                        i.putExtra("CATEGORIA", "ensaladas" );
                        break;
                    case 4:
                        i.putExtra("CATEGORIA", "salsas" );
                        break;
                    case 5:
                        i.putExtra("CATEGORIA", "pastas" );
                        break;
                    case 6:
                        i.putExtra("CATEGORIA", "arroz" );
                        break;
                    case 7:
                        i.putExtra("CATEGORIA", "batidos" );
                        break;
                    case 8:
                        i.putExtra("CATEGORIA", "frios" );
                        break;
                    case 9:
                        i.putExtra("CATEGORIA", "postres" );
                        break;
                    case 10:
                        i.putExtra("CATEGORIA", "panificados" );
                        break;
                    default:
                        break;
                }
                startActivity(i);
            }
        });
        RecetasAdapter adapter;
// Inicializamos el adapter.
        adapter = new RecetasAdapter(this, recetas);
// Asignamos el Adapter al ListView, en este punto hacemos que el
// ListView muestre los datos que queremos.
        vista.setAdapter(adapter);
    }
}
