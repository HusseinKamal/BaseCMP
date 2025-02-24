package com.hussein.basecmp

import android.app.Application
import com.hussein.basecmp.di.initKoin
import org.koin.android.ext.koin.androidContext

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BaseApplication)
        }
    }
}