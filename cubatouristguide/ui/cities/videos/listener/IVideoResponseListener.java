package com.example.cubatouristguide.ui.cities.videos.listener;

import com.example.cubatouristguide.ui.cities.photos.models.CuratedApiResponse;

public interface IVideoResponseListener {
    void onFetch(CuratedApiResponse response, String message);
    void onError(String message);
}
