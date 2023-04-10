package com.example.cubatouristguide.ui.sights;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.cubatouristguide.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.Locale;

public class SightsScrollingActivity extends AppCompatActivity {

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

        setContentView(R.layout.activity_sights_scrolling);
        Toolbar toolbar = findViewById(R.id.sights_toolbar);

        Bundle extras =getIntent().getExtras();

        // Fetch data from GSON
        if(extras!=null) {
            Gson gson = new Gson();
            String intentData = extras.getString("markerSights");
            System.out.println("Sta je u intent data: " + intentData);
            SightsItem data = gson.fromJson(intentData, SightsItem.class);

            setTitle(data.getName());

            TextView txt=findViewById(R.id.sight_scrolling_txt);
            txt.setText(data.getDescription());

            ImageView img=findViewById(R.id.sight_scrolling_img);
            Picasso.get().load(data.getImage()).into(img);


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
