package com.example.ktapplication

import android.app.Application

class CommonApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Preferences.init(this)
    }

}