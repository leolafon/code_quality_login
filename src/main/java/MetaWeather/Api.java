package MetaWeather;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.URL;

public class Api {
    private static Api instance = null;

    private static String baseUrl = "https://www.metaweather.com/api/location";

    protected Api() {}

    public static Api getInstance() {
        if (instance == null) {
            instance = new Api();
        }
        return instance;
    }

    public static JSONObject locationSearch(String location) {
        if (location == null) {
            return null;
        }

        HttpURLConnection connection = null;
        try {
            String params = buildQueryString("query", location);
            URL url = new URL(baseUrl + "/search/" + params);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);

            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuffer response = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append("\r");
            }
            rd.close();
            JSONObject json = new JSONArray(response.toString()).getJSONObject(0);
            return json;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private static String buildQueryString(String key, String value) {
        try {
            String url = "?" + key + "="
                + URLEncoder.encode(value, "UTF-8");

            return url;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
