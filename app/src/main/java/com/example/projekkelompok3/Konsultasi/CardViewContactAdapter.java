package com.example.projekkelompok3.Konsultasi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projekkelompok3.R;

import java.util.ArrayList;

public class CardViewContactAdapter extends RecyclerView.Adapter<CardViewContactAdapter.CardViewViewHolder> {
    private ArrayList<Kontak> contactList;
    private Context context;

            public CardViewContactAdapter(Context context) {
            this.context = context;
            }

            public ArrayList<Kontak> getContactList() {
            return contactList;
            }

            public void setContactList(ArrayList<Kontak> contactList) {
            this.contactList = contactList;
            }

            @Override
            public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
            CardViewViewHolder viewHolder = new CardViewViewHolder(view);
            return viewHolder;
            }

            @Override
            public void onBindViewHolder(CardViewViewHolder holder, int position) {
            Kontak c = getContactList().get(position);
            Glide.with(context).load(c.getFoto()).override(1150,650).into(holder.imgPhoto);
            holder.tvName.setText(c.getNama());

            holder.btnCall.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {

                @Override
                public void onItemClicked(View view, int position) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + c.getNumber()));
                    context.startActivity(intent);
                            }
    }));
            holder.btnMessage.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {

                @Override
                public void onItemClicked(View view, int position) {
                    Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(c.getLink()));
                    context.startActivity(intent);
                            }
            }));

                }

            @Override
            public int getItemCount() {
                return contactList.size();
                }

            public class CardViewViewHolder extends RecyclerView.ViewHolder {
                ImageView imgPhoto;
                TextView tvName;
                Button btnCall, btnMessage;

                public CardViewViewHolder(View itemView) {
                    super(itemView);
                    imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
                    tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
                    btnCall = (Button)itemView.findViewById(R.id.btn_call);
                    btnMessage = (Button)itemView.findViewById(R.id.btn_message);
                }
        }
    }
