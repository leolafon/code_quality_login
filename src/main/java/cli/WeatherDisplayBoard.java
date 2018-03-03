package cli;

import org.json.JSONArray;

public class WeatherDisplayBoard {
    private int nbOfBlocks = 0;
    private String cityTitle = "metaweather";
    private int widthOfDisplay = 0;
    JSONArray daysForecastArray = null;
    WeatherBlockBoard weatherBlockArray[] = null;

    public WeatherDisplayBoard(String location, JSONArray daysForecastArray)
    {
        this.cityTitle = location;
        if (daysForecastArray == null)
            return;
        this.daysForecastArray = daysForecastArray;
        this.nbOfBlocks = daysForecastArray.length();
        setupBlockArrayFromData();
    }

    private void setupBlockArrayFromData()
    {
        if (this.daysForecastArray != null && this.nbOfBlocks > 0)
        {
            this.weatherBlockArray = new WeatherBlockBoard[this.nbOfBlocks];
            for (int i = 0; i < this.daysForecastArray.length(); i++)
            {
                this.weatherBlockArray[i] = new WeatherBlockBoard(this.daysForecastArray.getJSONObject(i));

            }
        }
    }

    private void calculateWidthOfDisplay()
    {
        this.widthOfDisplay = 0;
        for (int i = 0; i < this.daysForecastArray.length(); i++)
        {
            this.widthOfDisplay += this.weatherBlockArray[i].getLenghtOfData() + 2;
        }
    }

    public void drawBorder() {
        String border = "+";
        for (int i = 0; i < this.widthOfDisplay; i++)
            border += '-';
        border += '+';
        System.out.println(border);
    }

    public void drawCell(String cellText) {
        String cellContent = "| ";
        cellContent += cellText;
        cellContent += " |";
    }

    public void displayWeather()
    {
    }
}
