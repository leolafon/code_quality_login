package cli;

import org.json.JSONObject;

public class WeatherBlockBoard {
    private JSONObject  weatherData;
    public int minTemp = 0;
    public int maxTemp = 0;
    public int humidity = 0;
    public int windSpeed = 0;
    public String forecastInfos = "";

    public WeatherBlockBoard(JSONObject weatherData)
    {
        this.weatherData = weatherData;
        extractData();
    }

    private void extractData()
    {
        if (this.weatherData == null)
            return;
        if (this.weatherData.get("min_temp") != null)
            this.minTemp = this.weatherData.getInt("min_temp");
        if (this.weatherData.get("max_temp") != null)
            this.maxTemp = this.weatherData.getInt("max_temp");
        if (this.weatherData.get("humidity") != null)
            this.humidity = this.weatherData.getInt("humidity");
        if (this.weatherData.get("wind_speed") != null)
            this.windSpeed = this.weatherData.getInt("wind_speed");
        this.forecastInfos = this.minTemp + " " + this.maxTemp + " " + this.windSpeed + " " + this.humidity;
    }

    public String getWeatherDataAsString()
    {
        this.forecastInfos = this.minTemp + " " + this.maxTemp + " " + this.windSpeed + " " + this.humidity;
        return this.forecastInfos;
    }

    public int getLenghtOfData()
    {
        return this.forecastInfos.length();
    }
}
