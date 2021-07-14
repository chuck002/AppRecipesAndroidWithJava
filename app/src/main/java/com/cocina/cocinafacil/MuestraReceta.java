package com.cocina.cocinafacil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.net.HttpURLConnection;
import java.net.URL;

public class MuestraReceta extends AppCompatActivity {

    private TextView Nombre;
    private ImageView Imagen;
    private TextView Ingredientes;
    private AdView adViewRecetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_receta);

        Nombre = findViewById(R.id.id_nombre);
        Imagen = findViewById(R.id.id_imagen);
        Ingredientes = findViewById(R.id.id_ingredientes);
        adViewRecetas = findViewById(R.id.adViewRecetas);

        //adViewRecetas.setAdSize(AdSize.BANNER);
        //adViewRecetas.setAdUnitId("ca-app-pub-3940256099942544/6300978111");

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        adViewRecetas.loadAd(adRequest);


        getSupportActionBar().hide();

        int id = getIntent().getExtras().getInt("ID");
        String tabla = getIntent().getExtras().getString("TABLA");

        DatabaseManager database = DatabaseManager.getInstance(getApplicationContext());
        database.open();

        String nombre, imagen, ingredientes;

        nombre = database.getNombre(id+1, tabla);
        imagen = database.getFoto(id+1, tabla);
        ingredientes = database.getIngredientes(id+1, tabla);
        database.close();

        Nombre.setText(nombre.toUpperCase());
        Ingredientes.setText(Html.fromHtml(ingredientes));
        Ingredientes.setMovementMethod(new ScrollingMovementMethod());

        Glide.with(getApplicationContext()).load(imagen).into(Imagen);
    }
}
