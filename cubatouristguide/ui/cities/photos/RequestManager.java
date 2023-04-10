package com.example.cubatouristguide.ui.cities.photos;

import android.content.Context;
import android.widget.Toast;

import com.example.cubatouristguide.ui.cities.photos.listener.ICuratedResponseListener;
import com.example.cubatouristguide.ui.cities.photos.models.CuratedApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestManager {

    private static String BASE_URL = "https://api.pexels.com/v1/";
    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }


    public void getCuratedWallpapers(ICuratedResponseListener listener, String page, String perPage){
        ICallAPI callAPI = retrofit.create(ICallAPI.class);
        Call<CuratedApiResponse> call = callAPI.getWallpapers(page, perPage);

        call.enqueue(new Callback<CuratedApiResponse>() {
            @Override
            public void onResponse(Call<CuratedApiResponse> call, Response<CuratedApiResponse> response) {
                 if(!response.isSuccessful()){
                     Toast.makeText(context, "An Error ocured", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 listener.onFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<CuratedApiResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });

    }


}
