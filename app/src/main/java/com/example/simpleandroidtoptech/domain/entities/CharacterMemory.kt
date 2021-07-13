package com.example.simpleandroidtoptech.domain.entities

data class CharacterMemory(
    val id: Int?,
    val name: String?,
    val status: String?,
    val species: String?,
    val type: String?,
    val gender: String?,
    val origin: OriginMemory?,
    val location: LocationMemory?,
    val image: String?
)