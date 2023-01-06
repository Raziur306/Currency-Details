package com.example.coinpaprika

import android.app.Application
import com.example.coinpaprika.di.component.ApplicationComponent
import com.example.coinpaprika.di.component.DaggerApplicationComponent

class CoinpaprikaApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}