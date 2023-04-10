package com.example.cubatouristguide.ui.cities.photos;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cubatouristguide.R;
import com.example.cubatouristguide.ui.cities.photos.listener.ICuratedResponseListener;
import com.example.cubatouristguide.ui.cities.photos.listener.IOnRecyclerClickListener;
import com.example.cubatouristguide.ui.cities.photos.models.CuratedApiResponse;
import com.example.cubatouristguide.ui.cities.photos.models.Photo;

import java.io.Serializable;
import java.util.List;

//page -> the page number you are requesting (default =1 )
//per_page -> the nymber of results (photos) you are requesting per page

public class PhotosActivity extends AppCompatActivity implements IOnRecyclerClickListener, Serializable {
    private static String ApiKey = "g0n1Iu7YWETUNP4140RgiS3jIIlPs4c1NSKCDgpo9gEaHjXmKwvnrL0g";
    //for photos base url = https://api.pexels.com/v1/
    //for videos base url = https://api.pexels.com/videos/

    //recyclerView_home
    RecyclerView recyclerView_photos;
    CuratedPhotosAdapter adapter;
    ProgressDialog dialog;
    RequestManager manager;
    String cityName;

    @Override
    protected void onCreate(Bundle savedBundleInstance){
        Bundle extras =getIntent().getExtras();
        Intent intent = getIntent();
        cityName = intent.getStringExtra("photos");

        //Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        System.out.println("City name je : " + cityName);

        // Fetch data from GSON
        /*if(extras!=null) {
            Gson gson = new Gson();

            String intentData = extras.getString("markerCity");
            CityItem data = gson.fromJson(intentData, CityItem.class);
            //setTitle(data.getName());

        }*/
        super.onCreate(savedBundleInstance);
        setContentView(R.layout.activity_photos);

        //provjeriti kako dodati tollbar
        //Toolbar toolbar = findViewById(R.id.photo_tolbar);
       // setSupportActionBar(toolbar);

        //ActionBar actionBar = getSupportActionBar();
        //assert actionBar != null;
       // actionBar.setDisplayHomeAsUpEnabled(true);
        //Bundle extras =getIntent().getExtras();

        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading..");

        manager = new RequestManager(this);
        manager.getCuratedWallpapers(listener, "1", "5");
    }

    private final ICuratedResponseListener listener = new ICuratedResponseListener(){

        @Override
        public void onFetch(CuratedApiResponse response, String message) {
            if(response.getPhotos().isEmpty()){
                Toast.makeText(PhotosActivity.this, "No Image found", Toast.LENGTH_SHORT).show();
                return;
            }
            System.out.println("Sta je ovde sta:" + response.getPhotos().get(2).getAvg_color());
            showData(response.getPhotos());
        }

        @Override
        public void onError(String message) {
            Toast.makeText(PhotosActivity.this,message,Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(List<Photo> photos) {
        recyclerView_photos = findViewById(R.id.recycler_view_photos);
        recyclerView_photos.setHasFixedSize(true);
        recyclerView_photos.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new CuratedPhotosAdapter(PhotosActivity.this, photos, this);
        recyclerView_photos.setAdapter(adapter);
    }

    @Override
    public void onClick(Photo photo) {
        startActivity(new Intent(PhotosActivity.this, FullScreenWallpaper.class).putExtra("photo", photo));

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
