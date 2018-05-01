package com.japanmicrosystem.eqms

import com.japanmicrosystem.eqms.component.DaggerAppComponent
import com.japanmicrosystem.eqms.data.DataApplication
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class MyApplication:DataApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent.builder()
            .application(this)
            .build()


//    @Inject lateinit var service:InventoriesService
    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

//        service.fetchUserName("151")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        {
//                            Timber.d(it.string())
//                        },{
//                            Timber.e(it)
//                        }
//                )

    }
}