package com.listapp.android.model.openweathermap;

/**
 * Created by ivan on 4/11/2017.
 */

public class WeatherCurrentDataMain {
    private String humidity;

    private String pressure;

    private String temp_max;

    private String temp_min;

    private Float temp;

    public String getHumidity ()
    {
        return humidity;
    }

    public void setHumidity (String humidity)
    {
        this.humidity = humidity;
    }

    public String getPressure ()
    {
        return pressure;
    }

    public void setPressure (String pressure)
    {
        this.pressure = pressure;
    }

    public String getTemp_max ()
    {
        return temp_max;
    }

    public void setTemp_max (String temp_max)
    {
        this.temp_max = temp_max;
    }

    public String getTemp_min ()
    {
        return temp_min;
    }

    public void setTemp_min (String temp_min)
    {
        this.temp_min = temp_min;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "WeatherCurrentDataMain{" +
                "humidity='" + humidity + '\'' +
                ", pressure='" + pressure + '\'' +
                ", temp_max='" + temp_max + '\'' +
                ", temp_min='" + temp_min + '\'' +
                ", temp='" + temp + '\'' +
                '}';
    }
}
