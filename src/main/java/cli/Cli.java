package cli;

public class Cli {
    private String  city = "";
    private int     nbDays = 0;

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
