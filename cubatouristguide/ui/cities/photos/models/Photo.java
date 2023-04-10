package com.example.cubatouristguide.ui.cities.photos.models;


import java.io.Serializable;

public class Photo implements Serializable {
    private float id;
    private float width;
    private float height;
    private String url;
    private String photographer;
    private String photographer_url;
    private float photographer_id;
    private String avg_color;
    public Src src;
    private boolean liked;
    private String alt;


    // Getter Methods

    public float getId() {
        return id;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public String getUrl() {
        return url;
    }

    public String getPhotographer() {
        return photographer;
    }

    public String getPhotographer_url() {
        return photographer_url;
    }

    public float getPhotographer_id() {
        return photographer_id;
    }

    public String getAvg_color() {
        return avg_color;
    }

    public Src getSrc() {
        return src;
    }

    public boolean getLiked() {
        return liked;
    }

    public String getAlt() {
        return alt;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public void setPhotographer_url(String photographer_url) {
        this.photographer_url = photographer_url;
    }

    public void setPhotographer_id(float photographer_id) {
        this.photographer_id = photographer_id;
    }

    public void setAvg_color(String avg_color) {
        this.avg_color = avg_color;
    }

    public void setSrc(Src srcObject) {
        this.src = srcObject;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }


}

