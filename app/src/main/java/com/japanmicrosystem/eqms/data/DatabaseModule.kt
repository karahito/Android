package com.japanmicrosystem.eqms.data

import com.japanmicrosystem.eqms.MyApplication
import dagger.Module
import dagger.Provides
import io.realm.Realm
import javax.inject.Inject
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideRealm(application:MyApplication): Realm = application.getRealm()
}