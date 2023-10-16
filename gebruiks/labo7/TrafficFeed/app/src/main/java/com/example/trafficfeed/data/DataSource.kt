package com.example.trafficfeed.data

import android.content.Context
import android.util.JsonReader
import com.example.trafficfeed.model.TrafficNotification
import com.example.trafficfeed.util.JsonUtils
import org.json.JSONObject
import org.json.JSONTokener
import java.io.File
import java.io.Reader

class DataSource {
    fun loadTrafficNotifications(appContext: Context): List<TrafficNotification> {
        val json: JSONObject = JsonUtils.loadJSONFromAsset(appContext, "notifications.json")
        return JsonUtils.parseJSON(json)
    }
    fun loadTrafficNotifications(): List<TrafficNotification> {
        val json = JSONObject(File("F:\\git\\Projects\\gebruiks\\labo7\\TrafficFeed\\app\\src\\main\\assets\\notifications.json").readText())
        return JsonUtils.parseJSON(json)
    }
}