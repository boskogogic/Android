package com.example.cubatouristguide.ui.cities.photos;

import com.example.cubatouristguide.ui.cities.photos.models.CuratedApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

//callWallpaperList
public interface ICallAPI {
  @Headers({
        "Accept: application/json",
        "Authorization: g0n1Iu7YWETUNP4140RgiS3jIIlPs4c1NSKCDgpo9gEaHjXmKwvnrL0g"
    })
    @GET("curated/")
    Call<CuratedApiResponse> getWallpapers(
            @Query("page") String page,
            @Query("per_page") String per_page
    );

}
