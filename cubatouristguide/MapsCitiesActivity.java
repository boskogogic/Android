package com.example.cubatouristguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cubatouristguide.databinding.ActivityMapsCitiesBinding;
import com.example.cubatouristguide.ui.cities.CitiesScrollingActivity;
import com.example.cubatouristguide.ui.cities.CityItem;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

public class MapsCitiesActivity extends AppCompatActivity implements OnMapReadyCallback {

    public String API_KEY = "AIzaSyAGQ4fh1lC8o6zd13ZHqRPH2rxmJw9GqRw";
    private GoogleMap mMap;
    private ActivityMapsCitiesBinding binding;
    private CityItem[] _cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsCitiesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_cities);
        mapFragment.getMapAsync(this);


        setTitle("Google Maps");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Gson gson = new Gson();
            String intent = extras.getString("citiesList");
            _cities = gson.fromJson(intent, CityItem[].class);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

         mMap.getUiSettings().setZoomControlsEnabled(true);

       int lengthOfList = _cities.length;

        for (int i = 0; i < lengthOfList; i++) {
            CityItem singleCity = _cities[i];
            double longtitude = Double.parseDouble(singleCity.getLongitude());
            double latitude = Double.parseDouble(singleCity.getLatitude());

            LatLng citySingleItem = new LatLng(latitude, longtitude);

            mMap.addMarker(new MarkerOptions()
                    .position(citySingleItem)
                    .title(singleCity.getName())
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin))
            );

            mMap.moveCamera(CameraUpdateFactory.newLatLng(citySingleItem));
            //provjereno -> upisano kako treba
            System.out.println("Single item naziv je " + singleCity.getName() + "\n" + " single item: " + citySingleItem);
            mMap.setOnInfoWindowClickListener(c->{
                Gson gson = new Gson();
                Intent intent = new Intent(this, CitiesScrollingActivity.class);
                String intentData =gson.toJson(c.getTag());
                intent.putExtra("markerCity",intentData);
                startActivity(intent);});



            // Add a marker in Sydney and move the camera
            // LatLng sydney = new LatLng(-34, 151);
            //_citiesMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            //_citiesMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }

        // zumiranje mape
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

    }
}