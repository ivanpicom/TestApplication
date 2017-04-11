package com.listapp.android.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.listapp.android.global.Constant;


public class BasicActivity extends AppCompatActivity{

    protected String TAG  = Constant.TAG + this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause");

    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume");

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy");

    }
}
