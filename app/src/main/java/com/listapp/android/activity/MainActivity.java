package com.listapp.android.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.listapp.android.R;
import com.listapp.android.global.ApiServer;
import com.listapp.android.model.openweathermap.WeatherGlobalData;
import com.listapp.android.network.MeteoApiEndpointInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Call api
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
// add your other interceptors …
// add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServer.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        MeteoApiEndpointInterface apiService = retrofit.create(MeteoApiEndpointInterface.class);

        Call<WeatherGlobalData> callCityWeatcher;

        callCityWeatcher = apiService.getWeather("3128759", ApiServer.API_KEY);

        callCityWeatcher.enqueue(new Callback<WeatherGlobalData>() {
            @Override
            public void onResponse(Call<WeatherGlobalData> call, Response<WeatherGlobalData> response) {
                int statusCode = response.code();
                if (statusCode == 200) {

                    WeatherGlobalData weatherGlobalData = response.body();
                    Log.d(TAG, weatherGlobalData.toString());

                } else {
                    // TODO show error
                    showServerProblem();
                }
            }

            @Override
            public void onFailure(Call<WeatherGlobalData> call, Throwable t) {
                showServerProblem();
            }

        });

    }

    // move this to control to an notification class
    private void showServerProblem() {
        Toast.makeText(getApplicationContext(), "Server error", Toast.LENGTH_SHORT).show();

    }
}
