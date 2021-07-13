package com.example.simpleandroidtoptech.data.entities

import com.example.simpleandroidtoptech.domain.entities.CharacterMemory

data class CharacterEntry(
    val id: Int?,
    val name: String?,
    val status: String?,
    val species: String?,
    val type: String?,
    val gender: String?,
    val origin: OriginEntry?,
    val location: LocationEntry?,
    val image: String?
): Entry(){
    override fun toEntityMemory() = CharacterMemory(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = origin?.toEntityMemory(),
        location = location?.toEntityMemory(),
        image = image
    )
}

