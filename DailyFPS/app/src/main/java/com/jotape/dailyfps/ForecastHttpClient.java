package com.jotape.dailyfps;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ForecastHttpClient {

    static final String API_KEY = "key=dd764bca8241064c494432d0733f7";
    static final String API_URL = "http://api.worldweatheronline.com/free/v2/weather.ashx?";
    static final String API_NUM_OF_DAYS = "&num_of_days=1";
    static final String API_RESPONSE_FORMAT = "&format=json";
    private static final String DEBUG_TAG = "Http response -> ";
    static String json = "";
    static JSONObject jObj = null;

    public JSONObject getForecastData(String latidude, String longitude) throws IOException {
        try {
            URL url = new URL(API_URL + API_KEY + "&q=" + latidude + "," + longitude + API_NUM_OF_DAYS + API_RESPONSE_FORMAT);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);

            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d(DEBUG_TAG, "The response is: " + response);

            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                json = stringBuilder.toString();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } finally {
                conn.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        return jObj;
    }
}
