package com.listapp.android.global;

public class ApiServer {

    // base Url (data source)
    public final static String BASE_URL = "http://api.openweathermap.org";
    /*call example
    * http://api.openweathermap.org/data/2.5/forecast?id=3128759&APPID=98d05cb13bc73c66c5099fa4481d7a41
    */

    public final static String API_KEY = "7855ff73bf07f8dc5cb11c3c93e28c24";
    public final static String API_CONTENT_TYPE = "application/json";

    public static final String CITY_ID_BARCELONA = "3128759";
    public static final String FORECAST_NUM_DAYS = "10";
}
