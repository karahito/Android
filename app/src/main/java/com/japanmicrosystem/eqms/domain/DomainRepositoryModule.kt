package com.japanmicrosystem.eqms.domain

import android.support.annotation.NonNull
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Module(includes = [
    (NetworkModule::class)
])
class DomainRepositoryModule @Inject constructor(private val retrofit: Retrofit){
    @Suppress("HasPlatformType")
    @Singleton
    @Provides
    fun provideService()= retrofit.create(InventoriesService::class.java)
}