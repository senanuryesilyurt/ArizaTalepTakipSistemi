package com.arizataleptakipsistemi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class YetkiliKontrol extends AppCompatActivity {
    private Button btn, btn2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yetkili_kontrol);

        btn = findViewById(R.id.button);                           //personel butonuna tıklandıgında
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(YetkiliKontrol.this, Register.class);      // talep oluşturma sayfasıyla baglantı kurar.
                startActivity(intent);
            }
        });

        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(YetkiliKontrol.this, Talepler.class);
                startActivity(intent2);

            }
        });
    }
}
