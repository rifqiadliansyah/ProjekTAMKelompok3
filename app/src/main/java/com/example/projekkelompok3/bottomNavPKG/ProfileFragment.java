package com.example.projekkelompok3.bottomNavPKG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.projekkelompok3.R;


public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,container,false);
        WebView wv = (WebView) view.findViewById(R.id.web_views);
        String text = "Heafirst adalah aplikasi mobile yang dikembangkan oleh tiga mahasiswa Universitas Lampung dengan tujuan " +
                "mendukung penerapan pola hidup sehat " +
                "beserta hal pendukung lainnya untuk menunjang kesehatan diri.";
        wv.loadData("<p style=\"text-align:justify\">"+text+"</p>","text/html","UTF-8");


        return view;
    }
}