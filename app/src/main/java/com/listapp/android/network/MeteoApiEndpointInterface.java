package com.listapp.android.network;

import com.listapp.android.global.ApiServer;
import com.listapp.android.model.openweathermap.WeatherGlobalData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by ivan on 4/10/2017.
 */

public interface MeteoApiEndpointInterface {


    @Headers({
            "Content-type: " + ApiServer.API_CONTENT_TYPE})

    @GET("/data/2.5/forecast")
    Call<WeatherGlobalData> getWeather(@Query("id") String cityId, @Query("APPID") String apiKey);
}
