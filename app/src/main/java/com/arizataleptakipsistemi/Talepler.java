package com.arizataleptakipsistemi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Talepler extends AppCompatActivity {

    private ArrayList<Talep> talepler;                          //talep nesnelerini tutacağım bir arraylist tanımladım.
    private ListView listView;
    private TaleplerAdapter listViewAdapter;                    //adapter tanımladım.
    //private Kullanici kullanici;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_listview_example);

        talepler = new ArrayList<Talep>();                                      //talep adındaki model sınıfındaki verileri listeye alıp taleplere atıyor.
        listView = (ListView) findViewById(R.id.listviewcustom);                //listviewcustom ıd sahip görüntüyü bul ve listview e ata.
                                                                                //adapterımı bağladığım kısım


        DatabaseReference dbRef= FirebaseDatabase.getInstance().getReference().child("Talepler");
        dbRef.addValueEventListener(new ValueEventListener() {                                      // database den veri okuyor

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot postSnopshot : dataSnapshot.getChildren()) {
                    Talep t = postSnopshot.getValue(Talep.class);
                    talepler.add(new Talep(t.getAd(),t.getSoyad(),t.getEmail(),t.getDetay()));
                }

                listViewAdapter = new TaleplerAdapter(Talepler.this, talepler);
                listView.setAdapter(listViewAdapter);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });
    }
}

