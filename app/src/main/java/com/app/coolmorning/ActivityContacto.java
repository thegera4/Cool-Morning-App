package com.app.coolmorning;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityContacto extends AppCompatActivity {

    private ImageView imageViewFacebook, imageViewWhatsapp, imageViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto);

        //Agregar icono en action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_contacto_foreground);
        //Agregar flecha para ir a home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Cambiar nombre de Activity en action bar
        getSupportActionBar().setTitle("Contacto");

        imageViewFacebook = (ImageView) findViewById(R.id.imageViewFacebook);
        imageViewWhatsapp = (ImageView) findViewById(R.id.imageViewWhatsapp);
        imageViewEmail = (ImageView) findViewById(R.id.imageViewEmail);

        imageViewFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Abrir app de facebook
                Intent intent = null;
                try {
                    getPackageManager().getPackageInfo("com.facebook.katana", 0);
                    String url = "https://www.facebook.com/CoolMorningLaguna";
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href="+url));
                } catch (Exception e) {
                    //Si no esta instalada la app de Facebook, abrir navegador
                    String url = "https://facebook.com/CoolMorningLaguna";
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent .setData(Uri.parse(url));
                }
                startActivity(intent);
            }
        });

        imageViewWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Abrir contacto especifico de whatsapp
                try {
                    // Reemplazar mensaje
                    String text = "Hola";
                    // Remplazar con el telefono sin el signo de + o 0 al principio, pero incluir el codigo de pais
                    String toNumber = "528711390732";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
                    startActivity(intent);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

        });

        imageViewEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Abrir opciones de apps para escribir correo
                Intent intentMail = new Intent(Intent.ACTION_SEND);
                intentMail.setType("plain/text");
                intentMail.putExtra(Intent.EXTRA_SUBJECT, "Mi pedido");
                intentMail.putExtra(Intent.EXTRA_TEXT, "Hola....");
                intentMail.putExtra(Intent.EXTRA_EMAIL, new String[]{"fatme.sabag@coolmorning.com.mx"});
                startActivity(Intent.createChooser(intentMail, "Elige app para escribir correo electronico:"));
            }
        });
    }
}