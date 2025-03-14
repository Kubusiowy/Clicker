package com.example.clickergame.gameData

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameData(
    @Json(name = "money") val money: Double,
    @Json(name = "level") val level: Int,
    @Json(name = "jednoKlikniecie") val jednoKlikniecie: Double
)
