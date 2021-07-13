package com.example.simpleandroidtoptech.data.entities

import com.example.simpleandroidtoptech.domain.entities.GeneralHeaderMemory
import com.google.gson.Gson
import java.lang.reflect.Type

@Suppress("UNCHECKED_CAST")
data class GeneralHeaderEntry<T>(
    val info: GeneralInfoEntry?,
    val results: T?
){
    fun serialize(): String? {
        val data = Gson()
        return data.toJson(this)
    }
    companion object {
        fun <T> create(serializedData: String?, dataClass: Type): GeneralHeaderEntry<T> {
            return Gson().fromJson(serializedData, dataClass)
        }
    }
    fun <K>toEntityMemory() = GeneralHeaderMemory(
        info = info?.toEntityMemory(),
        results = (when(results) {
            is List<*> -> (results as List<*>).map { (it as Entry).toEntityMemory() }
            is Map<*,*> -> { mapTransformation(results as Map<*,*>) }
            else -> (if (results is Entry) (results as Entry).toEntityMemory()
            else results)
        })  as K
    )
    private fun <K>mapTransformation(map: Map<*,*>): K {
        val returnMap = mutableMapOf<Any?, Any?>()
        map.forEach { returnMap[if(it.key is Entry) (it.key as Entry).toEntityMemory() else it.key ] = if(it.value is Entry) (it.value as Entry).toEntityMemory() else it.value }
        return returnMap as K
    }
}
abstract class Entry{
    abstract fun toEntityMemory(): Any
}