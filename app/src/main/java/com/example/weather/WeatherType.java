package com.example.weather;

import androidx.annotation.DrawableRes;

public class WeatherType {
    private String weatherDesc;

    @DrawableRes
    private int weatherIcon;

    public WeatherType(String weatherDesc, int weatherIcon) {
        this.weatherDesc = weatherDesc;
        this.weatherIcon = weatherIcon;
    }

    public WeatherType() {
    }

    public WeatherType getWeatherType(Integer weatherCode){
        switch (weatherCode){
            case 0:
                return new WeatherType("Clear sky",R.drawable.ic_sunny);

            case 1:
                return new WeatherType("Mainly clear",R.drawable.ic_cloudy);

            case 2:
                return new WeatherType("Partly cloudy",R.drawable.ic_cloudy);
            case 3:
                return new WeatherType("Overcast",R.drawable.ic_cloudy);

            case 45:
                return new WeatherType("Foggy",R.drawable.ic_very_cloudy);

            case 48:
                return new WeatherType("Depositing rime fog",R.drawable.ic_cloudy);

            case 51:
                return new WeatherType("Light drizzle",R.drawable.ic_rainshower);

            case 53:
                return new WeatherType("Moderate drizzle",R.drawable.ic_rainshower);

            case 55:
                return new WeatherType("Dense drizzle",R.drawable.ic_rainshower);

            case 56:

            case 66:
                return new WeatherType("Slight freezing drizzle",R.drawable.ic_snowyrainy);

            case 57:
                return new WeatherType("Dense freezing drizzle",R.drawable.ic_snowyrainy);

            case 61:
                return new WeatherType("Slight rain",R.drawable.ic_rainy);

            case 63:
                return new WeatherType("Rainy",R.drawable.ic_rainy);

            case 65:
                return new WeatherType("Heavy rain",R.drawable.ic_rainy);

            case 67:
                return new WeatherType("Heavy freezing rain",R.drawable.ic_snowyrainy);

            case 71:
                return new WeatherType("Slight snow fall",R.drawable.ic_snowy);

            case 73:
                return new WeatherType("Moderate snow fall",R.drawable.ic_heavysnow);

            case 75:
                return new WeatherType("Heavy snow fall",R.drawable.ic_heavysnow);

            case 77:
                return new WeatherType("Snow grains",R.drawable.ic_heavysnow);

            case 80:
                return new WeatherType("Slight rain showers",R.drawable.ic_rainshower);

            case 81:
                return new WeatherType("Moderate rain showers",R.drawable.ic_rainshower);

            case 82:
                return new WeatherType("Violent rain showers",R.drawable.ic_rainshower);

            case 85:
                return new WeatherType("Light snow showers",R.drawable.ic_snowy);

            case 86:
                return new WeatherType("Heavy snow showers",R.drawable.ic_snowy);

            case 95:
                return new WeatherType("Moderate thunderstorm",R.drawable.ic_thunder);
            case 96:
                return new WeatherType("Thunderstorm with slight hail",R.drawable.ic_rainythunder);

            case 99:
                return new WeatherType("Thunderstorm with heavy hail",R.drawable.ic_rainythunder);

            default:
                return new WeatherType("Mainly clear",R.drawable.ic_cloudy);

        }
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }
}
