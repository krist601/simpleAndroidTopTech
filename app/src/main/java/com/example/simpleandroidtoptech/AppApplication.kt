package com.example.simpleandroidtoptech

import android.app.Application
import com.example.simpleandroidtoptech.di.component.AppComponent
import com.example.simpleandroidtoptech.di.component.DaggerAppComponent

class AppApplication : Application() {
    companion object {
        var applicationComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        appComponent().inject(this)
    }
}

private fun buildDagger(): AppComponent {
    if (AppApplication.applicationComponent == null) {
        AppApplication.applicationComponent = DaggerAppComponent.builder().build()
    }
    return AppApplication.applicationComponent!!
}

fun appComponent(): AppComponent {
    return buildDagger()
}