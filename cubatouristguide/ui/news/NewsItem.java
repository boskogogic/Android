package com.example.cubatouristguide.ui.news;

//ModelClass
public class NewsItem {

    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;

    public NewsItem(String _author, String _title, String _description, String _url, String _urlToImage, String _publishedAt, String _content) {
        this.author = _author;
        this.title = _title;
        this.description = _description;
        this.url = _url;
        this.urlToImage = _urlToImage;
        this.publishedAt = _publishedAt;
        this.content = _content;
    }

    public String get_author() {
        return author;
    }

    public String get_title() {
        return title;
    }

    public String get_description() {
        return description;
    }

    public String get_url() {
        return url;
    }

    public String get_urlToImage() {
        return urlToImage;
    }

    public String get_publishedAt() {
        return publishedAt;
    }

    public void set_author(String _author) {
        this.author = _author;
    }

    public void set_title(String _title) {
        this.title = _title;
    }

    public void set_description(String _description) {
        this.description = _description;
    }

    public void set_url(String _url) {
        this.url = _url;
    }

    public void set_urlToImage(String _urlToImage) {
        this.urlToImage = _urlToImage;
    }

    public void set_publishedAt(String _publishedAt) {
        this.publishedAt = _publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
