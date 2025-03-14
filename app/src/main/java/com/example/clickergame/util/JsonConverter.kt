package com.example.clickergame.util

import com.example.clickergame.gameData.GameData
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object JsonConverter {
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private val jsonAdapter = moshi.adapter(GameData::class.java)

    fun toJson(gameData: GameData): String = jsonAdapter.toJson(gameData)

    fun fromJson(json:String): GameData? = jsonAdapter.fromJson(json)

}