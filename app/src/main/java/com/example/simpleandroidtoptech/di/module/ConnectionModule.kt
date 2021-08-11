package com.example.simpleandroidtoptech.di.module

import com.example.simpleandroidtoptech.data.connectionServices.ApiConstants
import com.example.simpleandroidtoptech.data.connectionServices.ApiMethods
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ConnectionModule {

    @Singleton
    @Provides
    fun getRetrofitMethodsInstance(retrofit: Retrofit): ApiMethods {
        return retrofit.create(ApiMethods::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(ApiConstants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}