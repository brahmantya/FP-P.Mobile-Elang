package com.workshopkotlin.anggitprayogo

import android.app.Application
import com.workshopkotlin.anggitprayogo.data.sharedpref.SharedprefUtil

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        SharedprefUtil.init(this)
    }
}