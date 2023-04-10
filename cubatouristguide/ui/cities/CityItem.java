package com.example.cubatouristguide.ui.cities;

public class CityItem {

    private int _id;

    private String _name;

    private String _image;

    private String _description;

    private  String _longitude;

    private  String _latitude;

    public CityItem(int id, String name, String image, String description, String longitude, String latitude) {
        _id = id;
        _name = name;
        _image = image;
        _description = description;
        _longitude = longitude;
        _latitude = latitude;
    }

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public String getImage() {
        return _image;
    }

    public String getDescription() { return _description; }

    public String  getLongitude(){ return _longitude; }

    public String getLatitude(){ return _latitude; }

}
