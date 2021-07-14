package com.cocina.cocinafacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class RuletaActivity extends AppCompatActivity {

    private AdView adViewRuleta;
    private Button btnruleta;
    private DatabaseManager database;
    private int positionCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruleta);

        getSupportActionBar().hide();

        adViewRuleta = findViewById(R.id.adViewRuleta);
        btnruleta = findViewById(R.id.button_ruleta);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        adViewRuleta.loadAd(adRequest);

        positionCat = (int)Math.floor(Math.random()*11);

        btnruleta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RuletaActivity.this, MuestraReceta2.class);
                switch (positionCat)
                {
                    case 0:
                        i.putExtra("TABLA", "carnes" );

                        break;
                    case 1:
                        i.putExtra("TABLA", "pollo" );

                        break;
                    case 2:
                        i.putExtra("TABLA", "pescado" );

                        break;
                    case 3:
                        i.putExtra("TABLA", "ensaladas" );

                        break;
                    case 4:
                        i.putExtra("TABLA", "salsas" );

                        break;
                    case 5:
                        i.putExtra("TABLA", "pastas" );

                        break;
                    case 6:
                        i.putExtra("TABLA", "arroz" );

                        break;
                    case 7:
                        i.putExtra("TABLA", "batidos" );

                        break;
                    case 8:
                        i.putExtra("TABLA", "frios" );

                        break;
                    case 9:
                        i.putExtra("TABLA", "postres" );

                        break;
                    case 10:
                        i.putExtra("TABLA", "panificados" );

                        break;
                    default:
                        break;
                }
                startActivity(i);
            }
        });

    }


}