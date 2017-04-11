package com.listapp.android.model.openweathermap;

/**
 * Created by ivan on 4/11/2017.
 */


    public class WeatherCurrentData
    {
        private String id;

        private String dt;

        private String cod;

        private String visibility;

        private String name;

        private String base;

        private WeatherCurrentDataMain main;

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getDt ()
        {
            return dt;
        }

        public void setDt (String dt)
        {
            this.dt = dt;
        }

        public String getCod ()
        {
            return cod;
        }

        public void setCod (String cod)
        {
            this.cod = cod;
        }

        public String getVisibility ()
        {
            return visibility;
        }

        public void setVisibility (String visibility)
        {
            this.visibility = visibility;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getBase ()
        {
            return base;
        }

        public void setBase (String base)
        {
            this.base = base;
        }

        public WeatherCurrentDataMain getMain ()
        {
            return main;
        }

        public void setMain (WeatherCurrentDataMain main)
        {
            this.main = main;
        }

        @Override
        public String toString() {
            return "WeatherCurrentData{" +
                    "id='" + id + '\'' +
                    ", dt='" + dt + '\'' +
                    ", cod='" + cod + '\'' +
                    ", name='" + name + '\'' +
                    ", base='" + base + '\'' +
                    ", main=" + main +
                    '}';
        }
    }
