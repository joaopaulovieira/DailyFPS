package com.jotape.dailyfps;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JSONParser {

    // JSON Node names
    private static final String TAG_DATA = "data";

    private static final String TAG_WEATHER = "weather";
    private static final String TAG_ASTRONOMY = "astronomy";
    private static final String TAG_DATE = "date";
    private static final String TAG_HOURLY = "hourly";
    private static final String TAG_MAX_TEMP_C = "maxtempC";
    private static final String TAG_MIN_TEMP_C = "mintempC";
    private static final String TAG_MAX_TEMP_F = "maxtempF";
    private static final String TAG_MIN_TEMP_F = "mintempF";
    private static final String UV_INDEX = "uvIndex";

    JSONArray weather = null;

    private static JSONObject getObject(String tagName, JSONObject jObj) throws JSONException {
        JSONObject subObj = jObj.getJSONObject(tagName);
        return subObj;
    }

    private static String getString(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getString(tagName);
    }

    private static float getFloat(String tagName, JSONObject jObj) throws JSONException {
        return (float) jObj.getDouble(tagName);
    }

    private static int getInt(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getInt(tagName);
    }

    public String getWeatherJSON(JSONObject data) throws JSONException {

        String uv_index = "";
        JSONObject json = data.getJSONObject(TAG_DATA);
        weather = json.getJSONArray(TAG_WEATHER);

        // looping through All Contacts
        for (int i = 0; i < weather.length(); i++) {
            JSONObject w = weather.getJSONObject(i);

            // JSON Object's
            JSONArray astronomy = w.getJSONArray(TAG_ASTRONOMY);
            JSONArray hourly = w.getJSONArray(TAG_HOURLY);

            // Storing each json item in variable
            String date = w.getString(TAG_DATE);
            String max_tempC = w.getString(TAG_MAX_TEMP_C);
            String min_tempC = w.getString(TAG_MIN_TEMP_C);
            String max_tempF = w.getString(TAG_MAX_TEMP_F);
            String min_tempF = w.getString(TAG_MIN_TEMP_F);
            uv_index = w.getString(UV_INDEX);

        }
        return uv_index;
    }
}
