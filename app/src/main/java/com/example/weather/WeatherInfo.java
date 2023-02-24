package com.example.weather;

import java.util.ArrayList;

public class WeatherInfo {

        private float latitude;
        private float longitude;
        private float generationtime_ms;
        private float utc_offset_seconds;
        private String timezone;
        private String timezone_abbreviation;
        private float elevation;
        Hourly_units Hourly_unitsObject;
        Hourly HourlyObject;


        // Getter Methods

        public float getLatitude() {
            return latitude;
        }

        public float getLongitude() {
            return longitude;
        }

        public float getGenerationtime_ms() {
            return generationtime_ms;
        }

        public float getUtc_offset_seconds() {
            return utc_offset_seconds;
        }

        public String getTimezone() {
            return timezone;
        }

        public String getTimezone_abbreviation() {
            return timezone_abbreviation;
        }

        public float getElevation() {
            return elevation;
        }

        public Hourly_units getHourly_units() {
            return Hourly_unitsObject;
        }

        public Hourly getHourly() {
            return HourlyObject;
        }

        // Setter Methods

        public void setLatitude(float latitude) {
            this.latitude = latitude;
        }

        public void setLongitude(float longitude) {
            this.longitude = longitude;
        }

        public void setGenerationtime_ms(float generationtime_ms) {
            this.generationtime_ms = generationtime_ms;
        }

        public void setUtc_offset_seconds(float utc_offset_seconds) {
            this.utc_offset_seconds = utc_offset_seconds;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public void setTimezone_abbreviation(String timezone_abbreviation) {
            this.timezone_abbreviation = timezone_abbreviation;
        }

        public void setElevation(float elevation) {
            this.elevation = elevation;
        }

        public void setHourly_units(Hourly_units hourly_unitsObject) {
            this.Hourly_unitsObject = hourly_unitsObject;
        }

        public void setHourly(Hourly hourlyObject) {
            this.HourlyObject = hourlyObject;
        }
    }
    class Hourly {
        ArrayList< Object > time = new ArrayList < Object > ();
        ArrayList < Object > temperature_2m = new ArrayList < Object > ();
        ArrayList < Object > relativehumidity_2m = new ArrayList < Object > ();
        ArrayList < Object > rain = new ArrayList < Object > ();
        ArrayList < Object > weathercode = new ArrayList < Object > ();
        ArrayList < Object > surface_pressure = new ArrayList < Object > ();
        ArrayList < Object > windspeed_10m = new ArrayList < Object > ();


        // Getter Methods



        // Setter Methods


    }
    class Hourly_units {
        private String time;
        private String temperature_2m;
        private String relativehumidity_2m;
        private String rain;
        private String weathercode;
        private String surface_pressure;
        private String windspeed_10m;


        // Getter Methods

        public String getTime() {
            return time;
        }

        public String getTemperature_2m() {
            return temperature_2m;
        }

        public String getRelativehumidity_2m() {
            return relativehumidity_2m;
        }

        public String getRain() {
            return rain;
        }

        public String getWeathercode() {
            return weathercode;
        }

        public String getSurface_pressure() {
            return surface_pressure;
        }

        public String getWindspeed_10m() {
            return windspeed_10m;
        }

        // Setter Methods

        public void setTime(String time) {
            this.time = time;
        }

        public void setTemperature_2m(String temperature_2m) {
            this.temperature_2m = temperature_2m;
        }

        public void setRelativehumidity_2m(String relativehumidity_2m) {
            this.relativehumidity_2m = relativehumidity_2m;
        }

        public void setRain(String rain) {
            this.rain = rain;
        }

        public void setWeathercode(String weathercode) {
            this.weathercode = weathercode;
        }

        public void setSurface_pressure(String surface_pressure) {
            this.surface_pressure = surface_pressure;
        }

        public void setWindspeed_10m(String windspeed_10m) {
            this.windspeed_10m = windspeed_10m;
        }
    }

