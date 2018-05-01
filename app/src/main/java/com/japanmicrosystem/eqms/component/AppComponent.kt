package com.japanmicrosystem.eqms.component

import com.japanmicrosystem.eqms.MainActivity
import com.japanmicrosystem.eqms.MyApplication
import dagger.BindsInstance
import dagger.Component

@Component(modules = [
    (AppModule::class)
])
interface AppComponent{
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: MyApplication):Builder
        fun build():AppComponent
    }
    fun inject(activity:MainActivity)
}