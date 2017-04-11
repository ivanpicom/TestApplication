package com.listapp.android.presenter;

import com.listapp.android.global.ApiServer;
import com.listapp.android.model.openweathermap.WeatherCurrentData;
import com.listapp.android.model.openweathermap.WeatherGlobalData;
import com.listapp.android.network.MeteoApiEndpointInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataItemInteractorImpl implements DataItemInteractor {

    private MeteoApiEndpointInterface meteoApiEndpointInterface;

    public DataItemInteractorImpl() {

        // Call api
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(logging);


        // Configure Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServer.BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create the API Service
        meteoApiEndpointInterface = retrofit.create(MeteoApiEndpointInterface.class);

    }


    @Override
    public Call<WeatherGlobalData> dataWeather(String cityId) {


        return meteoApiEndpointInterface.getWeather(cityId, ApiServer.FORECAST_NUM_DAYS, ApiServer.API_KEY);
    }

    @Override
    public Call<WeatherCurrentData> dataCurrentWeather(String cityId) {
        return meteoApiEndpointInterface.getCurrentWeather(cityId, ApiServer.API_KEY);
    }
}
