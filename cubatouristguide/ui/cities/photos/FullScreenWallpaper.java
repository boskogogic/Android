package com.example.cubatouristguide.ui.cities.photos;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cubatouristguide.R;
import com.example.cubatouristguide.ui.cities.photos.models.Photo;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class FullScreenWallpaper extends AppCompatActivity implements Serializable {
    ImageView imageView_wallpaper;
    Photo photo;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_wallpaper);

        imageView_wallpaper = findViewById(R.id.imageView_wallpaper);
        photo = (Photo) getIntent().getSerializableExtra("photo");

        Picasso.get().load(photo.getSrc().getOriginal()).placeholder(R.drawable.placeholderimage).into(imageView_wallpaper);
    }

  /*  @Override
    public void onClick(Photo photo){
        Toast.makeText(PhotosActivity.this, photo.getPhotographer(),Toast.LENGTH_SHORT).show();

    }*/
}
