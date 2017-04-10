package com.listapp.android.model.openweathermap;

import java.util.Arrays;

/**
 * Created by ivan on 4/10/2017.
 */

public class WeatherListVO {

    private String dt;

    private WeatherDataVO[] weather;

    private String dt_txt;

    //    private Clouds clouds;

//    private Wind wind;

//    private Sys sys;

//    private Main main;

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public WeatherDataVO[] getWeather() {
        return weather;
    }

    public void setWeather(WeatherDataVO[] weather) {
        this.weather = weather;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    @Override
    public String toString() {
        return "WeatherListVO{" +
                "dt='" + dt + '\'' +
                ", weather=" + Arrays.toString(weather) +
                ", dt_txt='" + dt_txt + '\'' +
                '}';
    }
}
