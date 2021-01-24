package com.arizataleptakipsistemi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class KullaniciKayit extends AppCompatActivity {

    EditText ad, soyad, eposta, unvan, birim, oda_no, kat_no;
    String sifre = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kullanici_kayit);

        ad = (EditText)findViewById(R.id.ad);                     // alıcağım verileri xml dosyasındaki karsılıklarını tek tek atadım.
        soyad = (EditText)findViewById(R.id.soyad);
        eposta = (EditText)findViewById(R.id.eposta);
        unvan = (EditText)findViewById(R.id.unvan);
        birim = (EditText)findViewById(R.id.birim);
        oda_no = (EditText)findViewById(R.id.odanumarasi);
        kat_no = (EditText)findViewById(R.id.katnumarasi);


        Button btnekle = findViewById(R.id.btnekle);
        btnekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Kullanicilar");
                dbRef.push().setValue(
                        new Kullanici(
                                ad.getText().toString(),                                                        // verileri alıp database e kaydettiğim kısım
                                soyad.getText().toString(),
                                eposta.getText().toString(),
                                sifre,
                                birim.getText().toString(),
                                Integer.parseInt(oda_no.getText().toString()),
                                unvan.getText().toString(),
                                kat_no.getText().toString()
                        )
                );
                Toast.makeText(getApplicationContext(), "Kullanıcı Eklendi", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

    }
}
