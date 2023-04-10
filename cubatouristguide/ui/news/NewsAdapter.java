package com.example.cubatouristguide.ui.news;

import android.annotation.SuppressLint;
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

import com.example.cubatouristguide.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    Context context;
    ArrayList<NewsItem> modelClassArrayList;

    public NewsAdapter(Context context, ArrayList<NewsItem> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item,null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        // klik na novinski clanak
        holder._news_card_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(context, NewsWebWiew.class);
                intent.putExtra("url", modelClassArrayList.get(position).get_url());
                context.startActivity(intent);
            }
        });

        holder._news_content.setText(modelClassArrayList.get(position).getContent());
        holder._news_time.setText("Published At:-" + modelClassArrayList.get(position).get_publishedAt());
        holder._news_author.setText(modelClassArrayList.get(position).get_author());
        holder._news_main_heading.setText(modelClassArrayList.get(position).get_title());
        if(modelClassArrayList.get(position).get_urlToImage() != null) {
            String loadedImage = modelClassArrayList.get(position).get_urlToImage();
            Picasso.get().load(loadedImage).into(holder._news_image_view);
        }

    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    //Custom view holder
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView _news_main_heading;
        TextView _news_content;
        TextView _news_author;
        TextView _news_time;

        CardView _news_card_view;
        ImageView _news_image_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            _news_main_heading = itemView.findViewById(R.id.news_main_heading);
            _news_content = itemView.findViewById(R.id.news_content);
            _news_author = itemView.findViewById(R.id.news_author);
            _news_time = itemView.findViewById(R.id.news_time);
            _news_card_view = itemView.findViewById(R.id.news_card_view);
            _news_image_view = itemView.findViewById(R.id.news_image);
        }
    }
}
