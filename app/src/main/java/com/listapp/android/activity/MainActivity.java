package com.listapp.android.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.listapp.android.R;
import com.listapp.android.global.ApiServer;
import com.listapp.android.model.openweathermap.WeatherGlobalDataVO;
import com.listapp.android.network.MeteoApiEndpointInterface;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BasicActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        GeneralBO.getInstance().getCityWeather("3128759");


        Retrofit retrofit;


        retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(ApiServer.BASE_URL)
                .client(new OkHttpClient.Builder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MeteoApiEndpointInterface apiService = retrofit.create(MeteoApiEndpointInterface.class);


        Observable<WeatherGlobalDataVO> observable = apiService.getWeatherObs("3128759", ApiServer.API_KEY);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherGlobalDataVO>() {

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d(TAG, "In onError()");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "In onCompleted()");
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "In onSubscribe()");

                    }

                    @Override
                    public void onNext(WeatherGlobalDataVO gitHubRepos) {
                        Log.d(TAG, "In onNext()");
                    }
                });


    }

    // move this to control to an notification class
    private void showServerProblem() {
        Toast.makeText(getApplicationContext(), "Server error", Toast.LENGTH_SHORT).show();

    }

}
