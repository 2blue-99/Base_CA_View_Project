package com.example.base_view_project.util

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class HiltApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init(){
        Timber.plant(LogDebugTree("TEST APP"))
    }
}