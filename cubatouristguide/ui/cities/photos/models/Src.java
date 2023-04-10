package com.example.cubatouristguide.ui.cities.photos.models;

import java.io.Serializable;

public class Src implements Serializable {
    private String original;
    private String large2x;
    private String large;
    private String medium;
    private String small;
    private String portrait;
    private String landscape;
    private String tiny;


    // Getter Methods

    public String getOriginal() {
        return original;
    }

    public String getLarge2x() {
        return large2x;
    }

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }

    public String getSmall() {
        return small;
    }

    public String getPortrait() {
        return portrait;
    }

    public String getLandscape() {
        return landscape;
    }

    public String getTiny() {
        return tiny;
    }

    // Setter Methods

    public void setOriginal(String original) {
        this.original = original;
    }

    public void setLarge2x(String large2x) {
        this.large2x = large2x;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public void setLandscape(String landscape) {
        this.landscape = landscape;
    }

    public void setTiny(String tiny) {
        this.tiny = tiny;
    }
}