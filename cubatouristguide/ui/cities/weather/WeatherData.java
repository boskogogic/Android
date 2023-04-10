package com.example.cubatouristguide.ui.cities.weather;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherData {

    //paznja - JSON nazivi parametara i poklapanja
    private String mTemperature;
    private String mIcon;
    private String mCity;
    private String mWeatherType;
    private int mCondition;

    public static WeatherData fromJSON(JSONObject jsonObject){

        try{
            // mapiranje iz JSON Response - a
            WeatherData weatherData = new WeatherData();
            weatherData.mCity = jsonObject.getString("name");
            weatherData.mCondition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherData.mWeatherType = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherData.mIcon = updateWeatherIcon(weatherData.mCondition);
            //mora se oduzeti jer se daje u kelvinima
            double tempResult = jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValueTemp = (int)Math.rint(tempResult);
            weatherData.mTemperature = Integer.toString(roundedValueTemp);
            return weatherData;

        }catch(JSONException e)
        {
            System.out.println("KOD MAPIRANJA SE DESILA GRESKA ? ");
            e.printStackTrace();
            return null;
        }
    }

    private static String updateWeatherIcon(int condition) {
        if(condition >= 0 && condition <= 300){
            return "thunderstorm";
        }
        else if(condition >= 300 && condition <= 500){
            return "lightrain";
        }
        else if(condition >= 500 && condition <= 600){
            return "shower";
        }
        else if(condition >= 600 && condition <= 700){
            return "snow";
        }
        else if(condition >= 701 && condition <= 771){
            return "fog";
        }
        else if(condition >= 772 && condition <= 800){
            return "overcast";
        }
        else if(condition == 800){
            return "sunny";
        }
        else if(condition >= 801 && condition <= 804){
            return "cloud";
        }
        else if(condition >= 900 && condition <= 902){
            return "thunderstorm";
        }
        else if(condition == 903){
            return "snow";
        }
        else if(condition == 904){
            return "sunny";
        }
        else if(condition >= 905 && condition <= 1000){
            return "thunderstorm";
        }
        //anything its not important, just to now that is not one of IF-s
        return "dunno";
    }

    public String getmTemperature() {
        return mTemperature +"°C";
    }

    public void setmTemperature(String mTemperature) {
        this.mTemperature = mTemperature;
    }

    public String getmIcon() {
        return mIcon;
    }

    public void setmIcon(String mIcon) {
        this.mIcon = mIcon;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }

    public void setmWeatherType(String mWeatherType) {
        this.mWeatherType = mWeatherType;
    }

    public int getmCondition() {
        return mCondition;
    }

    public void setmCondition(int mCondition) {
        this.mCondition = mCondition;
    }
}
