package com.arizataleptakipsistemi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PersonelLogin extends AppCompatActivity {

    int counter = 3;
    String sifre;
    String  posta;
    int sifre_size;
    TextView kayit_ol;
    private ArrayList<Kullanici> kullanicilar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personel_login);

        kullanicilar = new ArrayList<Kullanici>();

        final EditText eposta = (EditText) findViewById(R.id.mail);
        final EditText passwd = (EditText) findViewById(R.id.password);
        Button giris = findViewById(R.id.giris);
        kayit_ol = findViewById(R.id.textView);

        DatabaseReference dbRef= FirebaseDatabase.getInstance().getReference().child("Kullanicilar");
        dbRef.addValueEventListener(new ValueEventListener() {                                          // database den veri okuyor

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot postSnopshot : dataSnapshot.getChildren()) {
                    Kullanici t = postSnopshot.getValue(Kullanici.class);
                    kullanicilar.add(new Kullanici(t.getAd(),t.getSoyad(),t.getEmail(),t.getSifre(),t.getBirim(),t.getOda_no(),t.getUnvan(),t.getKat_no()));
                }

                for (Kullanici k:kullanicilar) {
                    Log.w("MAILS","Ad = " + k.ad +" Email = " + k.email + " Sifre = " + k.sifre);
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                posta = eposta.getText().toString();
                sifre = passwd.getText().toString();
                sifre_size = sifre.length();

                if(posta.isEmpty() || sifre.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Lütfen Gerekli Alanları Doldurunuz!", Toast.LENGTH_SHORT).show(); }
                else {
                    for (Kullanici k:kullanicilar) {
                        if (posta.trim().equals(k.email) && sifre.trim().equals(k.sifre)) {

                            Intent i = new Intent(PersonelLogin.this, Kontrol.class);
                            startActivity(i);
                            finish();

                        }
                    }

                   /* if (posta.trim().equals("user@gmail.com") && sifre.trim().equals("user")) {

                        Intent i = new Intent(PersonelLogin.this, Kontrol.class);
                        startActivity(i);

                    } else {
                        counter--;
                        Toast.makeText(getApplicationContext(), "E-mail yada Şifre Hatalı\nKalan Deneme Hakkı: " + counter, Toast.LENGTH_SHORT).show();

                        if (counter == 0) {
                            System.exit(0); } }*/
                }
            }
        });

        kayit_ol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (PersonelLogin.this, Register.class);
                startActivity(i);
            }
        });
    }
}
