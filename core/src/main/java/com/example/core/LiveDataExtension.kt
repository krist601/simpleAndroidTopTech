package com.example.core

import androidx.lifecycle.MutableLiveData

public fun <T> MutableLiveData<T>.post(status: LiveDataStatus, data: Any? = null, failure: Error? = null) {  }