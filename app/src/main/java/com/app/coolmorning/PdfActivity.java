package com.app.coolmorning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        //Agregar icono en action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_menu_foreground);
        //Agregar flecha para ir a home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Cambiar nombre de Activity en action bar
        getSupportActionBar().setTitle("Catalogo");

        //Declarar pdfview para interfaz grafica
        PDFView pdfView = findViewById(R.id.pdfView);
        //Carga de archivo pdf para vista
        pdfView.fromAsset("catalogo.pdf").load();
    }
}