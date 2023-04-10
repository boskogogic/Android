package com.example.cubatouristguide.ui.cities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cubatouristguide.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.ViewHolder> {
    private List<CityItem> _cities = new ArrayList<CityItem>();
    Context context;

    public interface OnItemClickListener {
        void onItemClick(CityItem item);
    }
    private OnItemClickListener listener;

    public CitiesAdapter(List<CityItem> cities,Context context){
        this._cities = cities;
        this.context = context;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return _cities.size();
    }


    @NonNull
    @Override
    public CitiesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.city_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CityItem city = _cities.get(position);
        String loadedImage = city.getImage();

        Picasso.get().load(loadedImage).into(holder.img);
        holder.img.setOnClickListener( v-> {
            Gson gson = new Gson();
            Intent intent = new Intent(context, CitiesScrollingActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            String intentData =gson.toJson(city);
            intent.putExtra("markerCity",intentData);
            context.startActivity(intent);
        });
        holder.name.setText(city.getName());
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.city_img);
            name= itemView.findViewById(R.id.city_name);

        }
    }
}
