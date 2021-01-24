package com.arizataleptakipsistemi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Kontrol extends AppCompatActivity {
   // private Button bttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kontrol_activity);


        Button btntalepolustur = findViewById(R.id.btntalepolustur);                           //personel butonuna tıklandıgında
        btntalepolustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(Kontrol.this, TalepOlusturActivity.class);      // talep oluşturma sayfasıyla baglantı kurar.
                startActivity(intent2);
            }
        });

        Button liste = findViewById(R.id.btnlistele);
        liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Kontrol.this, Talepler.class);
                startActivity(intent);

            }

        });


        }
}

