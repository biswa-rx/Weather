package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.weather.Adapters.RvSpreedAdapter;
import com.example.weather.Models.RvSpreedModel;
import com.example.weather.databinding.ActivityMainBinding;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements RvSpreedAdapter.OnItemClickListener{

    ActivityMainBinding mainBinding;
    ArrayList<RvSpreedModel> rvList;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private WeatherInfo weatherInfo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        mainBinding.cardView.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();
        double latitude = intent.getDoubleExtra("Key_lat",0.0);
        double longitude = intent.getDoubleExtra("Key_lon",0.0);
        Toast.makeText(this,"Latitude: "+latitude+"  Longitude: "+longitude,Toast.LENGTH_SHORT).show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.open-meteo.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        getForcast(latitude,longitude);
    }

    private void getForcast(double latitude,double longitude) {
        Call<WeatherInfo> weatherInfoCall = jsonPlaceHolderApi.getWeatherInfo(latitude,longitude);
//Enqueue method for not in ui thread it uses separate thread...
        weatherInfoCall.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this,"Code: "+response.code(),Toast.LENGTH_LONG).show();
                    return;
                }
                //UI UPDATE HERE
                weatherInfo = response.body();
                cardViewUpdate(response.body());
                getSpreedData(response.body());
            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getSpreedData(WeatherInfo data) {
        rvList = new ArrayList<>();
        for(int i=0;i<24;i++){
            double weatherCode = Double.parseDouble(data.getHourly().weathercode.get(i)+"");
            int wtCode = (int)weatherCode;
            int imageId = new WeatherType().getWeatherType(wtCode).getWeatherIcon();
            String time = i>9?i+":00":"0"+i+":00";
            String temp = data.getHourly().temperature_2m.get(i)+data.getHourly_units().getTemperature_2m();
            rvList.add(new RvSpreedModel(imageId,temp,time));
        }
        RvSpreedAdapter rvSpreedAdapter = new RvSpreedAdapter(rvList,this,this);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mainBinding.rvWeatherSpreed.setLayoutManager(layoutManager);
        mainBinding.rvWeatherSpreed.setAdapter(rvSpreedAdapter);
    }

    private void cardViewUpdate(WeatherInfo data) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            String localTime = String.valueOf(java.time.LocalTime.now());
            int hour = Integer.parseInt(localTime.substring(0, localTime.indexOf(':')));

            mainBinding.tvTemp.setText(data.getHourly().temperature_2m.get(hour)+data.getHourly_units().getTemperature_2m());
            mainBinding.tvAtmPressure.setText(data.getHourly().surface_pressure.get(hour)+data.getHourly_units().getSurface_pressure());
            mainBinding.tvHumidity.setText(data.getHourly().relativehumidity_2m.get(hour)+data.getHourly_units().getRelativehumidity_2m());
            mainBinding.tvWindSpeed.setText(data.getHourly().windspeed_10m.get(hour)+data.getHourly_units().getWindspeed_10m());
            mainBinding.tvTime.setText(data.getHourly().time.get(hour)+"");

            double weatherCode = Double.parseDouble(data.getHourly().weathercode.get(hour)+"");
            int wtCode = (int)weatherCode;
            mainBinding.tvWeatherType.setText(new WeatherType().getWeatherType(wtCode).getWeatherDesc());
            Drawable drawable = getResources().getDrawable(new WeatherType().getWeatherType(wtCode).getWeatherIcon());
            mainBinding.ivWeatherDesc.setImageDrawable(drawable);
            mainBinding.cardView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onItemClick(int position) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            mainBinding.tvTemp.setText(weatherInfo.getHourly().temperature_2m.get(position)+weatherInfo.getHourly_units().getTemperature_2m());
            mainBinding.tvAtmPressure.setText(weatherInfo.getHourly().surface_pressure.get(position)+weatherInfo.getHourly_units().getSurface_pressure());
            mainBinding.tvHumidity.setText(weatherInfo.getHourly().relativehumidity_2m.get(position)+weatherInfo.getHourly_units().getRelativehumidity_2m());
            mainBinding.tvWindSpeed.setText(weatherInfo.getHourly().windspeed_10m.get(position)+weatherInfo.getHourly_units().getWindspeed_10m());
            mainBinding.tvTime.setText(weatherInfo.getHourly().time.get(position)+"");

            double weatherCode = Double.parseDouble(weatherInfo.getHourly().weathercode.get(position)+"");
            int wtCode = (int)weatherCode;
            mainBinding.tvWeatherType.setText(new WeatherType().getWeatherType(wtCode).getWeatherDesc());
//            Drawable drawable = getResources().getDrawable(new WeatherType().getWeatherType(wtCode).getWeatherIcon());
//            mainBinding.ivWeatherDesc.setImageDrawable(drawable);
            mainBinding.ivWeatherDesc.setImageResource(new WeatherType().getWeatherType(wtCode).getWeatherIcon());
            mainBinding.cardView.setVisibility(View.VISIBLE);
        }
    }

}