package com.example.cubatouristguide.ui.cities.photos.listener;

import com.example.cubatouristguide.ui.cities.photos.models.CuratedApiResponse;

public interface ICuratedResponseListener {
    void onFetch(CuratedApiResponse response, String message);
    void onError(String message);
}
