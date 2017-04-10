package com.listapp.android.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.listapp.android.R;
import com.listapp.android.activity.adapter.ItemAdapter;
import com.listapp.android.global.ApiServer;
import com.listapp.android.model.openweathermap.WeatherGlobalData;
import com.listapp.android.model.openweathermap.WeatherList;
import com.listapp.android.network.MeteoApiEndpointInterface;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BasicActivity {

    private ArrayList<WeatherList> weatherLists;
    private ItemAdapter adapter;

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

                    adapter.clear();
                    for(WeatherList weatherList: weatherGlobalData.getList()){
                        adapter.add(weatherList);
                    }
//                    weatherLists = weatherGlobalData.getList();
//                    adapter.notifyDataSetChanged();


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

        // Construct the data source
        weatherLists = new ArrayList<WeatherList>();
// Create the adapter to convert the array to views
        adapter = new ItemAdapter(this, weatherLists);
// Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lt_main_activity);
        listView.setAdapter(adapter);

    }

    // move this to control to an notification class
    private void showServerProblem() {
        Toast.makeText(getApplicationContext(), "Server error", Toast.LENGTH_SHORT).show();

    }
}
