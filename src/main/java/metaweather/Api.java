package metaweather;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.net.URL;

public class Api {
    private static Api instance = null;

    private static String baseUrl = "https://www.metaweather.com/api/location";

    protected Api() {}

    /**
     *
     * @return
     */
    public static Api getInstance() {
        if (instance == null) {
            instance = new Api();
        }
        return instance;
    }

    /**
     *
     * @param location
     * @return
     */
    public static JSONObject locationSearch(String location) {
        if (location == null) {
            return null;
        }

        HttpURLConnection connection = null;
        try {
            String params = buildQueryString("query", location);
            connection = connectToUrl(
                baseUrl + "/search/" + params
            );
            return getJsonResponseArray(connection);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /**
     *
     * @param location
     * @return
     * @throws Exception
     */
    public static JSONObject getWeatherByLocation(String location)
        throws Exception {
        JSONObject locationData = locationSearch(location);
        if (locationData == null) {
            return null;
        }

        HttpURLConnection connection = null;
        try {
            connection = connectToUrl(
                    baseUrl + "/" + locationData.get("woeid").toString()
            );
            return getJsonResponse(connection);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /**
     *
     * @param key
     * @param value
     * @return
     */
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

    /**
     *
     * @param urlString
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
    private static HttpURLConnection connectToUrl(String urlString)
        throws MalformedURLException, IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = null;
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);

        return connection;
    }

    /**
     *
     * @param connection
     * @return
     * @throws IOException
     */
    private static JSONObject getJsonResponse(HttpURLConnection connection)
        throws IOException {
        StringBuffer response = getResponse(connection);
        JSONObject json = new JSONObject(response.toString());

        return json;
    }

    /**
     *
     * @param connection
     * @return
     * @throws IOException
     */
    private static JSONObject getJsonResponseArray(HttpURLConnection connection)
            throws IOException {
        StringBuffer response = getResponse(connection);
        JSONObject json = new JSONArray(response.toString()).getJSONObject(0);

        return json;
    }

    /**
     *
     * @param connection
     * @return
     * @throws IOException
     */
    private static StringBuffer getResponse(HttpURLConnection connection)
        throws IOException {
        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        StringBuffer response = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append("\r");
        }
        rd.close();

        return response;
    }

}
