package com.example.cubatouristguide.ui.cities.videos;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cubatouristguide.R;

import java.io.File;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<VideoViewHolder> {
    private Context context;
    private List<File> files;

    public CustomAdapter(Context context, List<File> files) {
        this.context = context;
        this.files = files;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(LayoutInflater.from(context).inflate(R.layout.video_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {

        Bitmap thumb = ThumbnailUtils.createVideoThumbnail(files.get(position).getAbsolutePath(),
                MediaStore.Images.Thumbnails.MINI_KIND);

        holder.image_video_cardView.setImageBitmap(thumb);


    }

    @Override
    public int getItemCount() {
        return files.size();
    }
}
