package com.example.simpleandroidtoptech.data.dataSources.local

import android.content.Context
import android.content.SharedPreferences
import com.example.simpleandroidtoptech.data.entities.CharacterEntry
import com.example.simpleandroidtoptech.data.entities.GeneralHeaderEntry
import com.example.simpleandroidtoptech.domain.entities.CharacterMemory
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class LocalDataSource @Inject constructor(/*private val context: Context*/) {
    /*private val sharedPreferences: SharedPreferences = context.getSharedPreferences("simpleAndroidTopTech.preferences", Context.MODE_PRIVATE)

    fun getCharacters(sharedPreferenceName: String): GeneralHeaderEntry<CharacterMemory>? {
        return sharedPreferences.getString(sharedPreferenceName, null)?.let { GeneralHeaderEntry.create(it, object : TypeToken<GeneralHeaderEntry<CharacterEntry>>() {}.type) }
    }
    fun setCharacters(sharedPreferenceName: String, header: GeneralHeaderEntry<CharacterEntry>){
        sharedPreferences.edit().putString(sharedPreferenceName,header.serialize()).apply()
    }*/
}