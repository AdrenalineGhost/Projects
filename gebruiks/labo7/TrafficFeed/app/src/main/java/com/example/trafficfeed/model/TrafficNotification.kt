package com.example.trafficfeed.model

data class TrafficNotification(
    val id: String,
    val name: String,
    val type: String,
    val source: String,
    val transport: String,
    val message: String,
    val latitude: Double,
    val longitude: Double,
    var date: String
)