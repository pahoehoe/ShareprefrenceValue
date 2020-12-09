package com.example.ktapplication

import android.app.Application
import com.kaptowka.preference.Preferences

class CommonApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Preferences.init(this)
    }

}