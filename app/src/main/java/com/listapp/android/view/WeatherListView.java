package com.listapp.android.view;

import com.listapp.android.model.openweathermap.WeatherGlobalData;


public interface  WeatherListView {


    void updateUi(WeatherGlobalData weatherGlobalData);
    void updateCurrentUi(Float temp);
}
