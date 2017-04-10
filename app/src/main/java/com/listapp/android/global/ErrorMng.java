package com.listapp.android.global;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ivan on 4/10/2017.
 */

public class ErrorMng {

    private static ErrorMng errorMng;
    private static Context contextApp;


    public static ErrorMng getInstance(Context context) {
        if (errorMng == null){
            errorMng = new ErrorMng();
        contextApp  =context;
        }
        return errorMng;
    }

    public void showErrorServer(String msg) {
        // TODO trigger an error to observers

        Toast.makeText(contextApp, "Server error", Toast.LENGTH_SHORT).show();


    }
}
