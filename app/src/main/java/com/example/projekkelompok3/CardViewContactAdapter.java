package com.example.projekkelompok3;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import androidx.fragment.app.FragmentActivity;

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
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_konsultasi, parent, false);
            CardViewViewHolder viewHolder = new CardViewViewHolder(view);
            return viewHolder;
            }

            @Override
            public void onBindViewHolder(CardViewViewHolder holder, int position) {
            Kontak c = getContactList().get(position);
            Glide.with(context).load(c.getFoto()).override(350,550).into(holder.imgPhoto);
            holder.tvName.setText(c.getNama());
            holder.btnCall.setOnClickListener(new CustomOnItemClickListener(position,
                    new CustomOnItemClickListener.OnItemClickCallback() {

                @Override
                public void onItemClicked(View view, int position) {
                            Toast.makeText(context, "Call "+getContactList().get(position).getNama(), Toast.LENGTH_SHORT).show();

                            }
    }));
            holder.btnMessage.setOnClickListener(new CustomOnItemClickListener(position, new
                    CustomOnItemClickListener.OnItemClickCallback() {

                @Override
                public void onItemClicked(View view, int position) {
                            Toast.makeText(context, "Message "+getContactList().get(position).getNama(), Toast.LENGTH_SHORT).show();
                            }
            }));

                }

            @Override
            public int getItemCount() {
                return getContactList().size();
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
