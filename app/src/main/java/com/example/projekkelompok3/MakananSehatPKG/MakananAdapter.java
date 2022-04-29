package com.example.projekkelompok3.MakananSehatPKG;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.projekkelompok3.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.MakananViewHolder> {
    Context context;
    ArrayList<MakananItem> arr;


    public MakananAdapter(Context context, ArrayList<MakananItem> arr) {
        this.context = context;
        this.arr = arr;
    }

    @NonNull
    @Override
    public MakananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.makanan_item,parent,false);
        return new MakananViewHolder(view);
    }

    public void  parseJSON(String id, APICallback callback){
        ArrayList<String> arrTampung = new ArrayList<String>();
        String url = "https://www.themealdb.com/api/json/v1/1/lookup.php?i="+id;


        JsonObjectRequest req = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
//                    BAGIAN AWAL ARRAY
                    JSONArray jsonArray = response.getJSONArray("meals");
//                        Buat dapetin per single object
                    JSONObject obj = jsonArray.getJSONObject(0);

                    String category= obj.getString("strCategory");
                    String asal = obj.getString("strArea");
                    String youtube = obj.getString("strYoutube");


                    arrTampung.add(category);
                    arrTampung.add(asal);
                    arrTampung.add(youtube);
                    callback.onSuccess(arrTampung);

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
        RequestQueue rq = Volley.newRequestQueue(context);
        rq.add(req);
    }

    interface APICallback {
        void onSuccess(ArrayList<String> arrTampung);
        void onError(String error);
    }


    @Override
    public void onBindViewHolder(@NonNull MakananViewHolder holder, int position) {
        String linkGambar = arr.get(position).getLinkGambar();
        String namaMakanan = arr.get(position).getNamaMakanan();
        String idMakanan = arr.get(position).getIdMakanan();
        Picasso.get().load(linkGambar).fit().centerInside().into(holder.imgGambar);
        holder.tvNama.setText(namaMakanan);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                parseJSON(idMakanan, new APICallback() {
                    @Override
                    public void onSuccess(ArrayList<String> arrTampung) {
                        Intent i = new Intent(context, DetailMakananActivity.class);
                        i.putExtra("TAMPUNG_GAMBAR",linkGambar);
                        i.putExtra("TAMPUNG_NAMA",namaMakanan);
                        i.putStringArrayListExtra("TAMPUNG_DATA", arrTampung);
                        context.startActivity(i);

                    }
                    @Override
                    public void onError(String error) {
                        System.out.println(error);
                    }
                });
//                System.out.println(arrTampung.get(0));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class MakananViewHolder extends RecyclerView.ViewHolder {
        ImageView imgGambar;
        TextView tvNama;
        CardView cardView;
        public MakananViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.id_cardview);
            imgGambar = itemView.findViewById(R.id.image_view);
            tvNama = itemView.findViewById(R.id.text_viewNama);

        }
    }




}
