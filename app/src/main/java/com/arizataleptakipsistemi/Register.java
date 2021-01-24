package com.arizataleptakipsistemi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    EditText ad, soyad, eposta, sifre, unvan, birim, oda_no, kat_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        ad = (EditText)findViewById(R.id.adR);                     // alıcağım verileri xml dosyasındaki karsılıklarını tek tek atadım.
        soyad = (EditText)findViewById(R.id.soyadR);
        eposta = (EditText)findViewById(R.id.epostaR);
        unvan = (EditText)findViewById(R.id.unvanR);
        birim = (EditText)findViewById(R.id.birimR);
        oda_no = (EditText)findViewById(R.id.odanumarasiR);
        kat_no = (EditText)findViewById(R.id.katnumarasiR);
        sifre = (EditText) findViewById(R.id.sifreR);


        Button btnekle = findViewById(R.id.btnekleR);
        btnekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Kullanicilar");
                dbRef.push().setValue(
                        new Kullanici(
                                ad.getText().toString(),                                                        // verileri alıp database e kaydettiğim kısım
                                soyad.getText().toString(),
                                eposta.getText().toString(),
                                sifre.getText().toString(),
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
