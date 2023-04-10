package com.example.cubatouristguide.ui.cities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.cubatouristguide.R;
import com.example.cubatouristguide.ui.cities.photos.PhotosActivity;
import com.example.cubatouristguide.ui.cities.videos.VideosActivity;
import com.example.cubatouristguide.ui.cities.weather.WeatherActivity;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.Locale;

public class CitiesScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Locale locale;
        if (!sharedPreferences.getString("language_pref", "English").equals("English")) {
            locale = new Locale("sr");
        } else {
            locale = new Locale("en");
        }

        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());

        setContentView(R.layout.activity_cities_scrolling);
        Toolbar toolbar = findViewById(R.id.city_toolbar);

        Bundle extras =getIntent().getExtras();

        // Fetch data from GSON
        if(extras!=null) {
            Gson gson = new Gson();
            String intentData = extras.getString("markerCity");
            System.out.println("Sta je u intent data: " + intentData);
            CityItem data = gson.fromJson(intentData, CityItem.class);

            setTitle(data.getName());

            TextView txt=findViewById(R.id.city_scrolling_txt);
            txt.setText(data.getDescription());

            ImageView img=findViewById(R.id.city_scrolling_img);
            Picasso.get().load(data.getImage()).into(img);

            Button weather=findViewById(R.id.city_weather);
            Button photos=findViewById(R.id.city_photos);
            Button videos=findViewById(R.id.city_videos);

            //set listener on buttons
            weather.setOnClickListener(l->{
                Intent intent = new Intent(this, WeatherActivity.class);
                String intentData1 =data.getName();
               // intent.putExtra("weather",intentData1);
                intent.putExtra("cityName", data.getName());
                startActivity(intent);

            });

            photos.setOnClickListener(l->{
                Intent intent = new Intent(this, PhotosActivity.class);
                String intentData1 =data.getName();
                System.out.println("Sta je u intentData1" + intentData1 );
                intent.putExtra("photos",data.getName());
                startActivity(intent);});

            videos.setOnClickListener(l->{
                Intent intent = new Intent(this, VideosActivity.class);
                String intentData1 =data.getName();
                intent.putExtra("videos",intentData1);
                startActivity(intent);});
        }

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);


    }

    //for back
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
