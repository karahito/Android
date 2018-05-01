package com.japanmicrosystem.eqms.data

import dagger.Module
import dagger.Provides
import io.realm.Realm
import javax.inject.Singleton

@Module
class DatabaseModule(private val application: DataApplication) {
    @Singleton
    @Provides
    fun provideRealm(): Realm = application.getRealm()
}