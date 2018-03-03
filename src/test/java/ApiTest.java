import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

import metaweather.Api;

public class ApiTest {
    @Test
    public void testLocalSearch() {
        Api api = Api.getInstance();

        JSONObject response = api.locationSearch("bordeaux");

        assertEquals(response.get("title"), "Bordeaux");
        assertEquals(response.get("location_type"), "City");
    }

    @Test
    public void testGetWeatherByLocation() {
        Api api = Api.getInstance();

        try {
            JSONObject response = api.getWeatherByLocation("Bordeaux");
            assertEquals(response.has("consolidated_weather"), true);
        } catch (Exception e) {
            e.printStackTrace();
            assertEquals(1, 2);
        }
    }
}
