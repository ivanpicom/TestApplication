package com.listapp.android.presenter;

import com.listapp.android.model.openweathermap.WeatherCurrentData;
import com.listapp.android.model.openweathermap.WeatherGlobalData;

import retrofit2.Call;

public interface  DataItemInteractor {


    Call<WeatherGlobalData> dataWeather(String cityId);
    Call<WeatherCurrentData> dataCurrentWeather(String cityId);
}
