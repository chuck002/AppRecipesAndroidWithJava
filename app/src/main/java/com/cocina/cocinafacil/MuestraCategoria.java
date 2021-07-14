package com.cocina.cocinafacil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class MuestraCategoria extends AppCompatActivity {

    private String tabla;
    private ListView vista_categorias;
    private TextView titulo;
    private AdView adViewCategoria;
    private InterstitialAd interAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_categoria);

        getSupportActionBar().hide();
        adViewCategoria = findViewById(R.id.adViewCategoria);
        interAd = new InterstitialAd(this);
        interAd.setAdUnitId("ca-app-pub-8026622122174762/5438991023");
        interAd.loadAd(new AdRequest.Builder().build());


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        adViewCategoria.loadAd(adRequest);

        interAd.setAdListener(new AdListener()
        {
            @Override
            public void onAdClosed() {
                interAd.loadAd(new AdRequest.Builder().build());
            }
        });


        ArrayList<Receta_ListView> recetas_categoria;

            recetas_categoria = new ArrayList<Receta_ListView>();
            vista_categorias = findViewById(R.id.LW_categoria_receta);
            titulo = findViewById(R.id.txt_nombre_categoria);

        DatabaseManager database = DatabaseManager.getInstance(getApplicationContext());
        database.open();
        int i = 1;
        tabla = getIntent().getExtras().getString("CATEGORIA");
        titulo.setText(tabla.toUpperCase());
        String nombre_receta;
        while(i != database.getCantidadRegistros(tabla)+1)
        {
           nombre_receta = database.getNombre(i, tabla);
           recetas_categoria.add(new Receta_ListView(nombre_receta, R.mipmap.g281));
           i++;
        }

        database.close();


            vista_categorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(MuestraCategoria.this, MuestraReceta.class);
                    i.putExtra("ID", position);
                    i.putExtra("TABLA", tabla );
                    startActivity(i);
                    if (interAd.isLoaded()) {
                        interAd.show();
                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }
                }
            });
            RecetasAdapter adapter;
// Inicializamos el adapter.
            adapter = new RecetasAdapter(this, recetas_categoria);
// Asignamos el Adapter al ListView, en este punto hacemos que el
// ListView muestre los datos que queremos.
            vista_categorias.setAdapter(adapter);
        }

    }