package com.listapp.android.presenter;

import com.listapp.android.global.ApiServer;
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
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
// add your other interceptors …
// add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!


        // Configure Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                // Base URL
                .baseUrl(ApiServer.BASE_URL)
                .client(httpClient.build())
                // It converts the JSON response into java objects
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create the API Service
        meteoApiEndpointInterface = retrofit.create(MeteoApiEndpointInterface.class);

    }


    @Override
    public Call<WeatherGlobalData> dataWeather(String cityId) {


        return meteoApiEndpointInterface.getWeather(cityId,ApiServer.API_KEY);//search("search+" + search);
    }
}
