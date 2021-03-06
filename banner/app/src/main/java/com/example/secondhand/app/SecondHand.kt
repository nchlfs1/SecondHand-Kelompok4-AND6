package com.example.secondhand.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class SecondHand: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SecondHand)
            modules(ProductVM, NotifVM, HistoVM)
        }
    }

}

