package com.example.cubatouristguide.ui.cities.photos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cubatouristguide.R;
import com.example.cubatouristguide.ui.cities.photos.listener.IOnRecyclerClickListener;
import com.example.cubatouristguide.ui.cities.photos.models.Photo;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class CuratedPhotosAdapter extends RecyclerView.Adapter<CuratedViewHolder> implements Serializable {

    Context context;
    List<Photo> photos;
    IOnRecyclerClickListener listener;

    public CuratedPhotosAdapter(Context context, List<Photo> photos, IOnRecyclerClickListener listener) {
        this.context = context;
        this.photos = photos;
        this.listener = listener;
    }


    // sta ubacujes (resoursce)
    @NonNull
    @Override
    public CuratedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CuratedViewHolder(LayoutInflater.from(context).inflate(R.layout.image_item, parent, false));
    }

    //cime popunjavas
    @Override
    public void onBindViewHolder(@NonNull CuratedViewHolder holder, int position) {
        //placeholder -> samo nesto da bude popunjeno dok se ne ucita slika
        //imageViewItem == imageView_list
        Picasso.get().load(photos.get(position).getSrc().getPortrait()).placeholder(R.drawable.placeholderimage).into(holder.imageViewItem);
        //home_view_container

        holder.photos_card_view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(photos.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }
}

//klasa koja je potreban da bi se moglo manipulisati sa adapter klasom
class CuratedViewHolder extends RecyclerView.ViewHolder{

    //home_list_container
    CardView photos_card_view_container;
    //imageView_list
    ImageView imageViewItem;

    public CuratedViewHolder(@NonNull View itemView) {
        super(itemView);
        photos_card_view_container = itemView.findViewById(R.id.photo_card_view_container);
        imageViewItem = itemView.findViewById(R.id.imageViewItem);
    }
}
