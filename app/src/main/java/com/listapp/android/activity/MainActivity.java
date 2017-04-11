package com.listapp.android.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.listapp.android.R;
import com.listapp.android.activity.adapter.ItemAdapter;
import com.listapp.android.activity.adapter.RecycleViewAdapter;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Construct the data source
        weatherLists = new ArrayList<WeatherList>();
        // Create the adapter to convert the array to views
        adapter = new ItemAdapter(this, weatherLists);

        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lt_main_activity);
        listView.setAdapter(adapter);

        DataItemInteractorImpl interactor = new DataItemInteractorImpl();
        presenter = new DataItemPresenter(interactor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.d(TAG,"Item clicked");

            }
        });


        mRecyclerView = (RecyclerView) findViewById(R.id.rv_main_activity);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        weatherListArrayAdapter = new ArrayList<WeatherList>();
        mListArrayAdapter = new RecycleViewAdapter(weatherListArrayAdapter);
        mRecyclerView.setAdapter(mListArrayAdapter);



    }

    @Override
    public void onResume() {
        super.onResume();

        presenter.bind(this);

        presenter.prefomDataWeather("3128759");

    }
    @Override
    public void onPause() {
        super.onPause();
        presenter.unbind();
    }


    @Override
    public void updateUi(WeatherGlobalData weatherGlobalData) {

        if(weatherGlobalData != null) {
            adapter.clear();
            weatherListArrayAdapter.clear();
            for (WeatherList weatherList : weatherGlobalData.getList()) {
                adapter.add(weatherList);
                weatherListArrayAdapter.add(weatherList);
            }
        }
        else {
            // TODO error to update query
        }



    }
}
