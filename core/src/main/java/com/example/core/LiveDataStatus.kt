package com.example.core

import androidx.lifecycle.MutableLiveData

enum class LiveDataStatus {
    SUCCESS,
    ERROR,
    TIME_OUT,
    LOADING
}

open class Resource<out T> constructor(val status: LiveDataStatus, val data: T?, val failure: Error?)

@Suppress("UNCHECKED_CAST")
fun <T> MutableLiveData<T>.post(status: LiveDataStatus, data: Any? = null, failure: Error? = null) {  }