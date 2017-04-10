package com.listapp.android.model.bo;

import com.listapp.android.data.GeneralDAO;

/**
 * Created by ivan on 4/10/2017.
 */

public class GeneralBO {

    private static GeneralBO generalBO;

    public static GeneralBO getInstance() {
        if (generalBO == null)
            generalBO = new GeneralBO();

        return generalBO;
    }


    public void getCityWeather(String cityId) {

        GeneralDAO.getInstance().getCityWeather(cityId);

    }
}

