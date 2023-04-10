package com.example.cubatouristguide.ui.sights;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cubatouristguide.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;

public class SightsInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private Context _context;

    public SightsInfoWindowAdapter(Context context) {
        _context = context;
    }

    @Nullable
    @Override
    public View getInfoWindow(@NonNull Marker marker) {
        return null;
    }

    @Nullable
    @Override
    public View getInfoContents(@NonNull Marker marker) {
        @SuppressLint("InflateParams") View view = ((Activity)_context).getLayoutInflater()
                .inflate(R.layout.sights_info_window, null);

        TextView text = view.findViewById(R.id.sight_infowindow_name);
        ImageView image = view.findViewById(R.id.sight_infowindow_img);

        text.setText(marker.getTitle());

        SightsItem sightWindowItem = (SightsItem) marker.getTag();
        assert sightWindowItem != null;
        Picasso.get().load(sightWindowItem.getImage()).into(image);

        return view;
    }
}
