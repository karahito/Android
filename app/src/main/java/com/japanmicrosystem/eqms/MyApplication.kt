package com.japanmicrosystem.eqms

import com.japanmicrosystem.eqms.component.AppComponent
import com.japanmicrosystem.eqms.component.DaggerAppComponent
import com.japanmicrosystem.eqms.data.DataApplication
import timber.log.Timber

class MyApplication:DataApplication() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build()
    }
}