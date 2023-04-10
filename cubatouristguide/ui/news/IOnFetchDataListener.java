package com.example.cubatouristguide.ui.news;

import java.util.List;

public interface IOnFetchDataListener {

    void onFetchData(List<NewsItem> list, String message);
    void onError(String message);
}
