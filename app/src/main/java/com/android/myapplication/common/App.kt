package com.android.myapplication.common

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 *Created by Nivetha S on 09-05-2021.
 */
@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var mInstance: App
    }
    override fun onCreate() {
        super.onCreate()
        mInstance = this
    }
}