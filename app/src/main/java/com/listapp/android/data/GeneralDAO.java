package com.listapp.android.data;

import android.util.Log;

import com.listapp.android.BuildConfig;
import com.listapp.android.global.ApiServer;
import com.listapp.android.model.openweathermap.WeatherGlobalDataVO;
import com.listapp.android.network.MeteoApiEndpointInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.listapp.android.global.Constant.TAG;

/**
 * Created by ivan on 4/10/2017.
 */

public class GeneralDAO {


    private static GeneralDAO generalDAO;

    public static GeneralDAO getInstance() {
        if (generalDAO == null)
            generalDAO = new GeneralDAO();

        return generalDAO;
    }


    public void getCityWeather(String cityId) {
        Retrofit retrofit;

        if (BuildConfig.DEBUG) {
            // get logs from calls
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);

            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiServer.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        } else
            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiServer.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        MeteoApiEndpointInterface apiService = retrofit.create(MeteoApiEndpointInterface.class);

        Call<WeatherGlobalDataVO> callCityWeatcher;

        callCityWeatcher = apiService.getWeather(cityId, ApiServer.API_KEY);
//        callCityWeatcher = apiService.getWeather("3128759", ApiServer.API_KEY);

        callCityWeatcher.enqueue(new Callback<WeatherGlobalDataVO>() {
            @Override
            public void onResponse(Call<WeatherGlobalDataVO> call, Response<WeatherGlobalDataVO> response) {
                int statusCode = response.code();
                if (statusCode == 200) {

                    WeatherGlobalDataVO weatherGlobalDataVO = response.body();
                    Log.d(TAG, weatherGlobalDataVO.toString());

                } else {
                    // TODO show error
//                    showServerProblem();
                }
            }

            @Override
            public void onFailure(Call<WeatherGlobalDataVO> call, Throwable t) {
                // TODO show error
//                    showServerProblem();
            }

        });

    }
}
