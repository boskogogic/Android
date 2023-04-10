package com.example.cubatouristguide.ui.cities.videos;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cubatouristguide.R;

public class VideoViewHolder extends RecyclerView.ViewHolder {
    public ImageView image_video_cardView;
    public CardView cardView;

    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
        //imgThumbail
        image_video_cardView = itemView.findViewById(R.id.image_video_card_view);
        //maint container
        cardView = itemView.findViewById(R.id.card_view_video_container);
    }
}
