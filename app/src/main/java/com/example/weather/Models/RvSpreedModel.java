package com.example.weather.Models;

public class RvSpreedModel {
    int image;
    String temp;
    String time;

    public RvSpreedModel(int image, String temp, String time) {
        this.image = image;
        this.temp = temp;
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
