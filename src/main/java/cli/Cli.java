package cli;

import metaweather.Api;
import org.json.JSONArray;
import org.json.JSONObject;

public class Cli {
    private String  city = "";
    private int     nbDays = 0;
    private Api     weatherApi = Api.getInstance();
    private JSONObject location;
    private WeatherDisplayBoard displayBoard = null;

    Cli(String city, int nbDays) {
        this.city = city;
        this.nbDays = nbDays;
        this.location = Api.locationSearch(this.city);
        JSONObject consolidateWeather = Api.getWeatherByLocation(this.city);
        if (consolidateWeather != null)
        {
            JSONArray Forecasts = consolidateWeather.getJSONArray("consolidated_weather");
            this.displayBoard = new WeatherDisplayBoard(this.city, Forecasts);
        }

    }

    public String getCity() {
        return this.city;
    }

    public int getNbDays() {
        return nbDays;
    }
}
