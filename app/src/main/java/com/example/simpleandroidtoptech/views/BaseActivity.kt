package com.example.simpleandroidtoptech.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simpleandroidtoptech.R
import com.example.simpleandroidtoptech.views.characterList.CharactersFragment

class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.container, CharactersFragment()).commitNow()
        }
    }
}