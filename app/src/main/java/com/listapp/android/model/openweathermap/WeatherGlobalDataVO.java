package com.listapp.android.model.openweathermap;

import java.util.ArrayList;

/**
 * Created by ivan on 4/10/2017.
 */

public class WeatherGlobalDataVO {

    private String message;

    private String cnt;

    private String cod;

    private ArrayList<WeatherListVO> list;

    private WeatherCityVO city;

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

    public ArrayList<WeatherListVO> getList() {
        return list;
    }

    public void setList(ArrayList<WeatherListVO> list) {
        this.list = list;
    }

    public WeatherCityVO getCity() {
        return city;
    }

    public void setCity(WeatherCityVO city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "WeatherGlobalDataVO{" +
                "message='" + message + '\'' +
                ", cnt='" + cnt + '\'' +
                ", cod='" + cod + '\'' +
                ", list=" + list +
                ", city=" + city +
                '}';
    }
}
