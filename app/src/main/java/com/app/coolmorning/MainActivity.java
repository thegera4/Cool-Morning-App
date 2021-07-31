package com.app.coolmorning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewContacto;
    private ImageView imageViewMenu;
   // private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializar SDK para Ads
       // MobileAds.initialize(this, new OnInitializationCompleteListener() {
          //  @Override
          //  public void onInitializationComplete(InitializationStatus initializationStatus) {
          //  }
       // });

        //Lineas para definir el uso del adView e inicializacion
        //mAdView = findViewById(R.id.adViewMain);
        //AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);

        //Agregar icono en action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_logo_foreground);
        //Cambiar nombre de Activity en action bar
        getSupportActionBar().setTitle("Bienvenido a Cool Morning");

        imageViewContacto = (ImageView) findViewById(R.id.imageViewContacto);
        imageViewMenu = (ImageView) findViewById(R.id.imageViewMenu);

        imageViewContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ir a pantalla de Contacto
                Intent intent = new Intent(MainActivity.this, ActivityContacto.class);
                startActivity(intent);
            }
        });

        imageViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Mostrar pdf
                Intent intent = new Intent(MainActivity.this, PdfActivity.class);
                startActivity(intent);
            }
        });

    }

    //Metodo para evitar que al presionar el Back button en el dispositivo Android, se devuelva al Splash Screen
    //y tambien evita que se el usuario se salga de la app como si usara el boton de home de Android
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}