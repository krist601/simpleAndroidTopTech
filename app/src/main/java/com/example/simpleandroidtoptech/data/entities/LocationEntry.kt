package com.example.simpleandroidtoptech.data.entities

import com.example.simpleandroidtoptech.domain.entities.LocationMemory

data class LocationEntry(
    val name: String?,
    val url: String?
): Entry(){
    override fun toEntityMemory() = LocationMemory(
        name = name,
        url = url
    )
}