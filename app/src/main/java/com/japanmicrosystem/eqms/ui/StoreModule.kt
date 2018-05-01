package com.japanmicrosystem.eqms.ui

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * StoreModule Class
 *
 * @author D.Noguchi
 * @since 2018/05/01
 */
@Module
class StoreModule {
    private val itemStore = ArrayList<ItemStore>()
    private var user = UserStore()

    @Singleton
    @Provides
    fun provideItemStore() = itemStore

    @Singleton
    @Provides
    fun provideUser() = user
}