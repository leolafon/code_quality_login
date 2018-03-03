package cli;

import MetaWeather.Api;
import jdk.nashorn.internal.parser.JSONParser;

public class Cli {
    private String  city = "";
    private int     nbDays = 0;
    private Api     weatherApi = Api.getInstance();

    Cli(String city, int nbDays) {
        this.city = city;
        this.nbDays = nbDays;
    }

    public String getCity() {
        return this.city;
    }

    public int getNbDays() {
        return nbDays;
    }
}
