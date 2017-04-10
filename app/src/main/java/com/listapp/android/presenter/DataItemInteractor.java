package com.listapp.android.presenter;

import com.listapp.android.model.openweathermap.WeatherGlobalData;

import retrofit2.Call;

public interface  DataItemInteractor {


    Call<WeatherGlobalData> dataWeather(String cityId);
}
