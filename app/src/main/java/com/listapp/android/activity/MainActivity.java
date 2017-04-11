package com.listapp.android.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.listapp.android.R;
import com.listapp.android.activity.adapter.ItemAdapter;
import com.listapp.android.activity.adapter.RecycleViewAdapter;
import com.listapp.android.global.ApiServer;
import com.listapp.android.model.openweathermap.WeatherGlobalData;
import com.listapp.android.model.openweathermap.WeatherList;
import com.listapp.android.presenter.DataItemInteractorImpl;
import com.listapp.android.presenter.DataItemPresenter;
import com.listapp.android.view.WeatherListView;

import java.util.ArrayList;

public class MainActivity extends BasicActivity implements WeatherListView{

    private ArrayList<WeatherList> weatherLists;
    private ArrayList<WeatherList>  weatherListArrayAdapter;
    private ItemAdapter adapter;
    private DataItemPresenter presenter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private RecycleViewAdapter mListArrayAdapter;
    private TextView currentTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Construct the data source
        weatherLists = new ArrayList<WeatherList>();
        // Create the adapter to convert the array to views
        adapter = new ItemAdapter(this, weatherLists);

        DataItemInteractorImpl interactor = new DataItemInteractorImpl();
        presenter = new DataItemPresenter(interactor);

        currentTemp = (TextView) findViewById(R.id.tv_main_activity_current_temperature);


        mRecyclerView = (RecyclerView) findViewById(R.id.rv_main_activity);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setVerticalFadingEdgeEnabled(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        weatherListArrayAdapter = new ArrayList<WeatherList>();
        mListArrayAdapter = new RecycleViewAdapter(getApplicationContext(),weatherListArrayAdapter);
        mRecyclerView.setAdapter(mListArrayAdapter);



    }

    @Override
    public void onResume() {
        super.onResume();

        presenter.bind(this);

        presenter.prefomDataWeather(ApiServer.CITY_ID_BARCELONA);
        presenter.prefomCurrentDataWeather(ApiServer.CITY_ID_BARCELONA);

    }
    @Override
    public void onPause() {
        super.onPause();
        presenter.unbind();
    }


    @Override
    public void updateUi(WeatherGlobalData weatherGlobalData) {

        if(weatherGlobalData != null) {
            weatherListArrayAdapter.clear();
            for (WeatherList weatherList : weatherGlobalData.getList()) {
                weatherListArrayAdapter.add(weatherList);
            }
            mListArrayAdapter.notifyDataSetChanged();
        }
        else {
            // TODO error to update query
        }



    }

    @Override
    public void updateCurrentUi(Float  temp) {
        if(temp!= 0) {
            String aux = String.format("%.1f", temp / 10);
            currentTemp.setText(aux);
        }


    }
}
