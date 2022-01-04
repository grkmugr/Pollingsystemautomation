package com.h5170062.q1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ogrenciList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    Adapter adapter;
    ArrayList<Ogrenci> list; //öğrenci listesini tutmak için oluşturdum.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogrenci_list);

        recyclerView = findViewById(R.id.ogrList); //ogrlist recyclerView'e tanımlamak için yaptım.
        database = FirebaseDatabase.getInstance().getReference("Users"); //Database değişkenine firebasede ki user adındaki veritabanı atamak için oluşturdum.
        recyclerView.setHasFixedSize(true); //Fixed size özelliğini true yaptım.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>(); //objeyi oluşturdum
        adapter = new Adapter(this,list); //adaptör değişkeninin içine listeyi attım.

        recyclerView.setAdapter(adapter); //öğrenci listesini adaptöre verdim.

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                   Ogrenci ogrenci = dataSnapshot.getValue(Ogrenci.class); //class değişkenlerini aldırdım.
                  list.add(ogrenci); //Döngü kullanarak firebasede ki öğrencileri list adlı listeye ekledim.
               }
               adapter.notifyDataSetChanged(); //veri değişikliği olduğu zaman güncelleme yapması için oluşturdum.
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}