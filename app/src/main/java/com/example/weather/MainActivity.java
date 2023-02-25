package com.example.weather;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.weather.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        mainBinding.cardView.setVisibility(View.INVISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.open-meteo.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        getForcast();

    }

    private void getForcast() {
        Call<WeatherInfo> weatherInfoCall = jsonPlaceHolderApi.getWeatherInfo(-3.255703,-62.084950);

        weatherInfoCall.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this,"Code: "+response.code(),Toast.LENGTH_LONG).show();
                    return;
                }
                //UI UPDATE HERE
                WeatherInfo weatherInfo = response.body();
                cardViewUpdate(response.body());
            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    private void cardViewUpdate(WeatherInfo data) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            String localTime = String.valueOf(java.time.LocalTime.now());
            int hour = Integer.parseInt(localTime.substring(0, localTime.indexOf(':')));

            mainBinding.tvTemp.setText(data.getHourly().temperature_2m.get(hour)+data.getHourly_units().getTemperature_2m());
            mainBinding.tvAtmPressure.setText(data.getHourly().surface_pressure.get(hour)+data.getHourly_units().getSurface_pressure());
            mainBinding.tvHumidity.setText(data.getHourly().relativehumidity_2m.get(hour)+data.getHourly_units().getRelativehumidity_2m());
            mainBinding.tvWindSpeed.setText(data.getHourly().windspeed_10m.get(hour)+data.getHourly_units().getWindspeed_10m());

            double weatherCode = Double.parseDouble(data.getHourly().weathercode.get(hour)+"");
            int wtCode = (int)weatherCode;
            mainBinding.tvWeatherType.setText(new WeatherType().getWeatherType(wtCode).getWeatherDesc());
            Drawable drawable = getResources().getDrawable(new WeatherType().getWeatherType(wtCode).getWeatherIcon());
            mainBinding.ivWeatherDesc.setImageDrawable(drawable);
            mainBinding.cardView.setVisibility(View.VISIBLE);
        }
    }
}