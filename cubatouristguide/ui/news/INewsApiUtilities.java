package com.example.cubatouristguide.ui.news;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface INewsApiUtilities {

    String BASE_URL="https://newsapi.org/v2/";

     @GET("top-headlines")
     Call<NewsApiResponse> getNews(
        @Query("country") String country,
        @Query("pageSize") int pagesize,
        @Query("apiKey") String apikey

     );
}
