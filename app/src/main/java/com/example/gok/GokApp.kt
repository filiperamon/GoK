package com.example.gok

import android.app.Application
import org.koin.android.ext.android.startKoin
import com.example.gok.di.androidModule
import org.koin.standalone.StandAloneContext.stopKoin

class GokApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(androidModule))
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}