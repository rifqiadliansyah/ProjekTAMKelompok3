package com.example.projekkelompok3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.projekkelompok3.MakananSehatPKG.MakananAdapter;
import com.example.projekkelompok3.MakananSehatPKG.MakananItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MakananSehat extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<MakananItem> listMakanan;
    private RequestQueue rq;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_sehat);
        rv  = findViewById(R.id.recycle_view);

//        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(this));

        listMakanan = new ArrayList<>();
        rq = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON(){
        String url = "https://www.themealdb.com/api/json/v1/1/filter.php?c=Vegetarian#";
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
//                    BAGIAN AWAL ARRAY
                    JSONArray jsonArray = response.getJSONArray("meals");

                    for (int i=0;i<jsonArray.length();i++){
//                        Buat dapetin per single object
                        JSONObject obj = jsonArray.getJSONObject(i);

                        String link= obj.getString("strMealThumb");
                        String namaMakananan = obj.getString("strMeal");
                        String idMakanan = obj.getString("idMeal");

                        listMakanan.add(new MakananItem(link,namaMakananan,idMakanan));

                    }

                    MakananAdapter makananAdapter = new MakananAdapter(MakananSehat.this,
                            listMakanan);
                    rv.setAdapter(makananAdapter);
                    rv.setLayoutManager(new LinearLayoutManager(MakananSehat.this));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        rq.add(req);

    }

}