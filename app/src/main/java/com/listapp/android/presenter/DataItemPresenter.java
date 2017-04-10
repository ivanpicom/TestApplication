package com.listapp.android.presenter;

import android.util.Log;

import com.listapp.android.view.WeatherListView;
import com.listapp.android.model.openweathermap.WeatherGlobalData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.listapp.android.global.Constant.TAG;


public class DataItemPresenter {

    DataItemInteractor dataItemInteractor;
    private WeatherListView view;

    public DataItemPresenter (DataItemInteractor dataItemInteractor){
        this.dataItemInteractor = dataItemInteractor;
    }


    public void bind(WeatherListView view) {
        this.view = view;
    }

    public void unbind() {
        view = null;
    }

    public void prefomDataWeather(String cityId) {

        dataItemInteractor.dataWeather(cityId)
        .enqueue(new Callback<WeatherGlobalData>() {
            @Override
            public void onResponse(Call<WeatherGlobalData> call, Response<WeatherGlobalData> response) {
                int statusCode = response.code();
                if (statusCode == 200) {

                    WeatherGlobalData weatherGlobalData = response.body();
                    Log.d(TAG, weatherGlobalData.toString());

                    if(view != null)
                        view.updateUi(weatherGlobalData);


                } else {
                    view.updateUi(null);
                }
            }

            @Override
            public void onFailure(Call<WeatherGlobalData> call, Throwable t) {

                view.updateUi(null);
            }

        });}
}
