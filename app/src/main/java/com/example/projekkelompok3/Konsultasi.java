package com.example.projekkelompok3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;


import android.os.Bundle;

public class Konsultasi extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Kontak> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Kontak Dokter");
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_konsultasi);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(KontakData.getListData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CardViewContactAdapter cardViewContactAdapter= new CardViewContactAdapter(this);
        cardViewContactAdapter.setContactList(list);
        recyclerView.setAdapter(cardViewContactAdapter);

    }
}