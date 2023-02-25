package com.example.weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("v1/forecast?hourly=temperature_2m,relativehumidity_2m,rain,weathercode,surface_pressure,windspeed_10m")
    Call<WeatherInfo> getWeatherInfo(
            @Query("latitude") Double lat,
            @Query("longitude") Double lon);
}
