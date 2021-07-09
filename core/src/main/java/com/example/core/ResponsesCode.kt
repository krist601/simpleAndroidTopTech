package com.example.core

enum class ResponsesCode(val type: Int) {
    SUCCESS(200),
    ERROR(500),
    TIME_OUT(408),
    NONE(0)
}