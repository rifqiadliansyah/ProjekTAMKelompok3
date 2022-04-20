package com.example.projekkelompok3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


public class HomeFragment extends Fragment {
    GridView gridView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home,container,false);


        String[] datatulisan ={"Konsultasi","BBI","Hitung Mineral","Rekomendasi Olahraga",
                "Healing","Statistik Covid"};
        int[] gambar={R.drawable.ic_konsultasi,R.drawable.ic_bbi,R.drawable.ic_drink,
                R.drawable.ic_barbel,R.drawable.ic_yoga,R.drawable.ic_covid};

        GridAdapter gridAdapter = new GridAdapter(getActivity().getApplicationContext(),datatulisan,gambar);
        gridView = (GridView) rootView.findViewById(R.id.gridView);


        gridView.setAdapter(gridAdapter);

        //KLIK FITUR

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(datatulisan[i].equals("Konsultasi")){
                    intent = new Intent(getActivity().getApplicationContext(),
                            Konsultasi.class);
                    startActivity(intent);
                }
                if(datatulisan[i].equals("BBI")){
                    intent = new Intent(getActivity().getApplicationContext(),Bbi.class);
                    startActivity(intent);
                }
                if(datatulisan[i].equals("Hitung Mineral")){
                    intent = new Intent(getActivity().getApplicationContext(),HitungMineral.class);
                    startActivity(intent);
                }
                if(datatulisan[i].equals("Rekomendasi Olahraga")){
                    intent = new Intent(getActivity().getApplicationContext(),
                            RekomendasiOlahraga.class);
                    startActivity(intent);
                }
                if(datatulisan[i].equals("Healing")){
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/AB3Y-4a3ZrU"));
                    startActivity(intent);
                }
                if(datatulisan[i].equals("Statistik Covid")){
                    intent = new Intent(getActivity().getApplicationContext(),StatistikCovid.class);
                    startActivity(intent);
                }
            }
        });

        return rootView;
    }
}