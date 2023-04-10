package com.example.cubatouristguide.ui.news;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsApiUtilities {

    private static Retrofit _retrofit=null;

    public static INewsApiUtilities getApiInterface(){

        if(_retrofit==null){
            _retrofit = new Retrofit.Builder()
                        .baseUrl(INewsApiUtilities.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

        }
        return _retrofit.create(INewsApiUtilities.class);
    }

}
