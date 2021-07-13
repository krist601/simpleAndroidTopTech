package com.example.simpleandroidtoptech.data.entities

import com.example.simpleandroidtoptech.domain.entities.OriginMemory

data class OriginEntry(
    val name:String?,
    val url:String?
): Entry(){
    override fun toEntityMemory() = OriginMemory(
        name = name,
        url = url
    )
}