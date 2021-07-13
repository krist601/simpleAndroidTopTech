package com.example.simpleandroidtoptech.data.entities

import com.example.simpleandroidtoptech.domain.entities.GeneralInfoMemory

data class GeneralInfoEntry(
    val count: Int?,
    val pages: Int?,
    val next: String?,
    val prev: String?
): Entry(){
    override fun toEntityMemory() = GeneralInfoMemory(
        count = count,
        pages = pages,
        next = next,
        prev = prev
    )
}