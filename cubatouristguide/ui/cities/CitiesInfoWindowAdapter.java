package com.example.cubatouristguide.ui.cities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.cubatouristguide.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;

//import com.google.android.gms.maps.GoogleMap;

public class CitiesInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    private Context _context;

    public CitiesInfoWindowAdapter(Context context){
        _context = context;
    }

    @Override
    public View getInfoWindow(@NonNull Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        @SuppressLint("InflateParams") View view = ((Activity)_context).getLayoutInflater()
                .inflate(R.layout.cities_info_window, null);

        TextView name = view.findViewById(R.id.city_infowindow_name);
        ImageView img = view.findViewById(R.id.city_infowindow_img);

        name.setText(marker.getTitle());

        CityItem infoWindowData = (CityItem) marker.getTag();
        assert infoWindowData != null;
        Picasso.get().load(infoWindowData.getImage()).into(img);

        return view;
    }
}
