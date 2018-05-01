package com.japanmicrosystem.eqms.component

import com.japanmicrosystem.eqms.MyApplication
import com.japanmicrosystem.eqms.data.DataRepositoryModule
import com.japanmicrosystem.eqms.data.DatabaseModule
import com.japanmicrosystem.eqms.network.NetworkModule
import com.japanmicrosystem.eqms.ui.StoreModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidSupportInjectionModule::class),
    (AppModule::class),
    (NetworkModule::class),
    (UiModule::class),
    (StoreModule::class),
    (DatabaseModule::class),
    (DataRepositoryModule::class)
])
interface AppComponent:AndroidInjector<MyApplication>{
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: MyApplication):Builder
        fun build():AppComponent
    }
}