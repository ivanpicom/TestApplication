package com.listapp.android.model.openweathermap;

import java.util.ArrayList;

/**
 * Created by ivan on 4/10/2017.
 */

public class WeatherGlobalData {

    private String message;

    private String cnt;

    private String cod;

    private ArrayList<WeatherList> list;

    private WeatherCity city;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public String getCnt ()
    {
        return cnt;
    }

    public void setCnt (String cnt)
    {
        this.cnt = cnt;
    }

    public String getCod ()
    {
        return cod;
    }

    public void setCod (String cod)
    {
        this.cod = cod;
    }

    public ArrayList<WeatherList> getList() {
        return list;
    }

    public void setList(ArrayList<WeatherList> list) {
        this.list = list;
    }

    public WeatherCity getCity() {
        return city;
    }

    public void setCity(WeatherCity city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "WeatherGlobalData{" +
                "message='" + message + '\'' +
                ", cnt='" + cnt + '\'' +
                ", cod='" + cod + '\'' +
                ", list=" + list +
                ", city=" + city +
                '}';
    }
}
