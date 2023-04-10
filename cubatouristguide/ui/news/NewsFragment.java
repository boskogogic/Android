package com.example.cubatouristguide.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cubatouristguide.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsFragment extends Fragment {

    String apiKey = "328c939136064752877e9034de8cbcba";
    ArrayList<NewsItem> newsItems = new ArrayList<NewsItem>(100);
    NewsAdapter adapter;
    String country = "us";
    private RecyclerView recyclerViewNews;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment_news, null);
        recyclerViewNews = v.findViewById(R.id.recyclerviewNews);
        newsItems = new ArrayList<NewsItem>();
        recyclerViewNews.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NewsAdapter(getContext(),newsItems);
        recyclerViewNews.setAdapter(adapter);

        findNews();

        return v;
    }

    private void findNews() {
        NewsApiUtilities.getApiInterface().getNews(country,100, apiKey).enqueue(new Callback<NewsApiResponse>() {
            @Override
            public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {
               if (response.isSuccessful()) {
                    System.out.println("Sta je error body " + response.errorBody());
                    newsItems.addAll(response.body().get_articles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<NewsApiResponse> call, Throwable t) {
                System.out.println("Desila se greska!");
            }
        });
    }

}

/*
                    //NewsApiResponse responseClone = new NewsApiResponse( response.body().get_status(), response.body().get_totalResults(),response.body().get_articles());

                    //System.out.println("Number of items: " + newsItems.size());
                    //System.out.println("Headers (Neke osnovne info)" + response.headers());
                    System.out.println("To string: " +response.toString());


                    System.out.println("Upis nekakav RAW = " + response.raw());
                    //System.out.println("Ostalo " + response.message() + " " + response.code());

                    System.out.println("Sta se nalazi u totalResults " + response.body().get_totalResults());
                    System.out.println("Sta se nalazi u status " +response.body().get_status());
                    //System.out.println("Sta se tu nalazi " + response.body().get_articles());*/