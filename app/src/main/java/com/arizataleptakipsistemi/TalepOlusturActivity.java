package com.arizataleptakipsistemi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


public class TalepOlusturActivity extends AppCompatActivity {

    EditText ad, soyad, email, detay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talep_olustur);


        ad = (EditText)findViewById(R.id.editText);                     // alıcağım verileri xml dosyasındaki karsılıklarını tek tek atadım.
        soyad = (EditText)findViewById(R.id.editText2);
        email = (EditText)findViewById(R.id.editText4);
        detay = (EditText)findViewById(R.id.editText8);


            Button fab = findViewById(R.id.gönder);                           // Gönder butonuna basıldlğında yapılacaklar
            fab.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Talepler");          //database child "talepler"
                    dbRef.push().setValue(
                            new Talep(
                                    ad.getText().toString(),                                                        // verileri alıp database e kaydettiğim kısım
                                    soyad.getText().toString(),
                                    email.getText().toString(),
                                    detay.getText().toString()
                            )
                    );
                    Toast.makeText(getApplicationContext(), "Talebiniz Oluşturuldu", Toast.LENGTH_SHORT).show();
                finish();
                }
        });

    }
}

