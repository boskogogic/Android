package com.example.cubatouristguide.ui.news;

import java.util.ArrayList;

//mainN
public class NewsApiResponse {

    private String status;
    private int totalResults;
    private ArrayList<NewsItem> articles;

    public NewsApiResponse(String _status, int _totalResults, ArrayList<NewsItem> _articles) {
        this.status = _status;
        this.totalResults = _totalResults;
        this.articles = _articles;
    }

    public String get_status() {
        return status;
    }

    public void set_status(String _status) {
        this.status = _status;
    }

    public int get_totalResults() {
        return totalResults;
    }

    public void set_totalResults(int _totalResults) {
        this.totalResults = _totalResults;
    }

    public ArrayList<NewsItem> get_articles() {
        return articles;
    }

    public void set_articles(ArrayList<NewsItem> _articles) {
        this.articles = _articles;
    }
}
