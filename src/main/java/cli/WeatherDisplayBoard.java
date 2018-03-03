package cli;

import org.json.JSONArray;

public class WeatherDisplayBoard {
    private int nbOfBlocks = 0;
    private int nbOfDays;
    private String cityTitle = "metaweather";
    private int widthOfDisplay = 0;
    JSONArray daysForecastArray = null;
    WeatherBlockBoard weatherBlockArray[] = null;

    public WeatherDisplayBoard(String location, JSONArray daysForecastArray, int nbOfDays)
    {
        this.cityTitle = location;
        if (daysForecastArray == null)
            return;
        this.daysForecastArray = daysForecastArray;
        this.nbOfBlocks = daysForecastArray.length();
        this.nbOfDays = nbOfDays;
        setupBlockArrayFromData();
        calculateWidthOfDisplay();
    }

    private void setupBlockArrayFromData()
    {
        if (this.daysForecastArray != null && this.nbOfBlocks > 0)
        {
            this.weatherBlockArray = new WeatherBlockBoard[this.nbOfBlocks];
            for (int i = 0; i < this.daysForecastArray.length() && i < this.nbOfDays; i++)
            {
                this.weatherBlockArray[i] = new WeatherBlockBoard(this.daysForecastArray.getJSONObject(i));
            }
        }
    }

    private void calculateWidthOfDisplay() {
        this.widthOfDisplay = 0;
        for (int i = 0; i < this.daysForecastArray.length() && i < this.nbOfDays; i++)
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

    public String addMarginToString(String target, int margin) {
        String marginSpaces = "";
        StringBuilder builder = new StringBuilder();
        String margedResult = new String();

        for (int i = 0; i < margin; i++)
        {
            marginSpaces += " ";
        }
        margedResult = marginSpaces + target + marginSpaces;
        return margedResult;
    }

    public void drawCell(String cellText, int idealWidth) {
        int margin = (idealWidth - cellText.length()) / 2 ;
        String cellContent = "|";
        cellContent += this.addMarginToString(cellText, margin);
        cellContent += " |";
        System.out.print(cellContent);
    }

    public void drawDayCells() {
        String title = "MetaWeather";

        drawBorder();
        drawCell(title, title.length());
        for (int i = 0; i < this.nbOfBlocks && i < this.nbOfDays; i++) {
            drawCell("J + " + i, this.weatherBlockArray[i].getLenghtOfData() + 2);
        }
        System.out.println();
        drawBorder();
    }

    public void drawForecastInformation() {
        for (int i = 0; i < this.weatherBlockArray.length && i < this.nbOfDays; i++) {
            drawCell(this.weatherBlockArray[i].getWeatherDataAsString(), this.weatherBlockArray[i].getLenghtOfData());
        }
        System.out.println();
        drawBorder();
    }
    public void displayWeather() {
        drawDayCells();
        drawForecastInformation();
    }
}
