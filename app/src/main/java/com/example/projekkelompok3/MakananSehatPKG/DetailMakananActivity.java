package com.example.projekkelompok3.MakananSehatPKG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projekkelompok3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailMakananActivity extends AppCompatActivity {
    String linkGambar;
    String namaMakanan;
    private ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);

        linkGambar = getIntent().getStringExtra("TAMPUNG_GAMBAR");
        namaMakanan = getIntent().getStringExtra("TAMPUNG_NAMA");
        data = getIntent().getStringArrayListExtra("TAMPUNG_DATA");


        ImageView gambarMakanan = findViewById(R.id.image_view);
        TextView tvNama = findViewById(R.id.text_viewNama);
        TextView tvAsal = findViewById(R.id.tv_asal);
        TextView tvKategori = findViewById(R.id.tv_kategori);
        Button btnLink = findViewById(R.id.btn_youtube);





        Picasso.get().load(linkGambar).fit().into(gambarMakanan);
        tvNama.setText(namaMakanan);
        tvAsal.setText("Kategori : "+data.get(0));
        tvKategori.setText("Asal : "+data.get(1));
        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(data.get(2)));
                startActivity(i);
            }
        });




    }

}