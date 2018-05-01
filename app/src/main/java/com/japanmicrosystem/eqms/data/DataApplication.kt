package com.japanmicrosystem.eqms.data

import dagger.android.support.DaggerApplication
import io.realm.Realm
import io.realm.RealmConfiguration
import timber.log.Timber

abstract class DataApplication:DaggerApplication() {

    internal var config:RealmConfiguration? = null

    private fun initRealm(){
        Timber.d("initialize at Realm")
        Realm.init(this)
        initConfig()
    }

    internal fun initConfig(){
        Timber.d("initialize at RealmConfig")
        config ?:let{
            config = RealmConfiguration.Builder()
                    .deleteRealmIfMigrationNeeded()
                    .build()
        }
    }

    internal fun getRealm():Realm{
        Timber.d("get realm instance")
        return Realm.getDefaultInstance()
    }
    override fun onCreate() {
        super.onCreate()
        initRealm()
    }
}