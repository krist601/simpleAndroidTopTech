package com.example.core

import androidx.lifecycle.MutableLiveData

public fun <T> MutableLiveData<T>.post(status: ResponseCodes, data: Any?, failure: Error?) {  }