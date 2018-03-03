package cli;

import MetaWeather.Api;
import org.json.JSONArray;
import org.json.JSONObject;

public class Cli {
    private String  city = "";
    private int     nbDays = 0;
    private Api     weatherApi = Api.getInstance();
    private JSONObject targetLocation;

    Cli(String city, int nbDays) {
        this.city = city;
        this.nbDays = nbDays;
        this.targetLocation = this.weatherApi.locationSearch(this.city);


      }

    public String getCity() {
        return this.city;
    }

    public int getNbDays() {
        return nbDays;
    }
}
