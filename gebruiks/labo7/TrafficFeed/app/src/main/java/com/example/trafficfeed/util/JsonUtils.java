package com.example.trafficfeed.util;

import android.content.Context;

import com.example.trafficfeed.model.TrafficNotification;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public abstract class JsonUtils {

    private JsonUtils(){}

    public static JSONObject loadJSONFromAsset(Context context, String file) throws IOException, JSONException {
        JSONObject json = new JSONObject();
        InputStream is = null;
        try {
            is = context.getAssets().open(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            json = new JSONObject(new String(buffer, "UTF-8"));
        } finally {
            if (is != null)
                is.close();
        }
        return json;
    }

    /**
     * Update the content provider from the json data. This data has a lot of errors and needs to be
     * as robust as possible therefor we allow empty strings if the keys are not found.
     * @param result
     * @throws JSONException
     */
    public static List<TrafficNotification> parseJSON(JSONObject result) throws JSONException {
        List<TrafficNotification> list = new ArrayList<>();
        JSONArray json = result.getJSONArray("result");
        TrafficNotification notification;
        for (int i=0; i<json.length(); i++) {
            JSONObject entity = json.getJSONObject(i);
            JSONObject parent = entity;
            if (entity.has("objectsToStore")) // to fix some strange data of tweets
                entity = entity.optJSONArray("objectsToStore").optJSONObject(0) != null ? entity.optJSONArray("objectsToStore").optJSONObject(0) : entity;

            JSONObject payload = entity.optJSONObject("payload"); // can be null
            if (payload == null) {
                payload = new JSONObject("{}"); // fix bad data
            }
            JSONObject sourcePayload = entity.optJSONObject("sourcePayload"); // can be null
            if (sourcePayload == null)
                sourcePayload = new JSONObject("{}"); // fix bad data

            String name = entity.optString("alarmName");
            String type = entity.optString("type");
            String source = entity.has("source") ? entity.getString("source") : payload.optString("source");
            String transport = entity.optString("transport");
            Double latitude = payload.optDouble("latitude");
            Double longitude = payload.optDouble("longitude");
            Date date = new Date(parent.optLong("timestamp"));

            UUID id = null;
            String message = null;
            try {
                if (source.equalsIgnoreCase("waze")) {
                    id = UUID.fromString(sourcePayload.optString("uuid"));
                    message =  payload.optString("message");
                } else if (source.equalsIgnoreCase("irail")) {
                    message =  payload.optString("message");
                    id = UUID.fromString(String.format(Locale.getDefault(), "%d-%f-%f", parent.optLong("timestamp"), parent.optDouble("longitude"), parent.optDouble("latitude"))); // no real ID on iRail
                } else if (source.equalsIgnoreCase("coyote")) {
                    id = UUID.fromString(payload.optString("id"));
                    message = String.format(Locale.getDefault(), "Speed limit of %d km/h on %s.", payload.optInt("speed_limit", -1), payload.optString("road_name", "unknown")); // no real message for coyote
                }
            } catch (Exception ex) {
            } finally {
                // fix bad json
                if (id == null) {
                    id = UUID.randomUUID();
                }
                if (message == null)
                    message = "No message included.";
            }

            notification = new TrafficNotification(id.toString(), name, type, source, transport, message, latitude, longitude, String.valueOf(date));
            list.add(notification);
        }
        return list;
    }
}

