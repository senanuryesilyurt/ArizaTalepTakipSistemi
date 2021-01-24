package com.arizataleptakipsistemi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    int counter = 3;
    String sifre, posta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final EditText eposta = (EditText) findViewById(R.id.mail);
        final EditText passwd = (EditText) findViewById(R.id.password);
        Button giris = findViewById(R.id.giris);

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posta = eposta.getText().toString();
                sifre = passwd.getText().toString();

                 if(posta.isEmpty() || sifre.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Lütfen Gerekli Alanları Doldurunuz!", Toast.LENGTH_SHORT).show(); }
                 else{

                    if (posta.trim().equals("admin@gmail.com") && sifre.trim().equals("admin")) {
                        Intent i = new Intent(Login.this, YetkiliKontrol.class);
                        startActivity(i); }
                     else {
                        counter--;
                        Toast.makeText(getApplicationContext(), "E-mail yada Şifre Hatalı\nKalan Deneme Hakkı: " + counter, Toast.LENGTH_SHORT).show();

                        if (counter == 0) {
                            System.exit(0); } }
                 }
            }
        });
    }
}
