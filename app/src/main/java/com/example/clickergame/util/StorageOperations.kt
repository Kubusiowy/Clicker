package com.example.clickergame.util

import android.content.Context
import android.content.SharedPreferences
import com.example.clickergame.gameData.GameData

object StorageOperations {
    private const val PREF_NAME = "GameDataPrefs"
    private const val KEY_GAME_DATA = "game_data"

    fun saveGameData(context: Context, gameData: GameData) {
        val sharedPrefs =context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        val json = JsonConverter.toJson(gameData)

        editor.putString(KEY_GAME_DATA, json)
           editor.apply()

    }

    fun loadGameData(context:Context):GameData? {
        val sharedPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        val json = sharedPrefs.getString(KEY_GAME_DATA, null)
        return json?.let{JsonConverter.fromJson(it)}
    }

}