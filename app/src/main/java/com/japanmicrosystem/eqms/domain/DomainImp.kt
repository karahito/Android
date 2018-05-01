package com.japanmicrosystem.eqms.domain

import com.japanmicrosystem.eqms.data.DbManager
import com.japanmicrosystem.eqms.network.InventoriesService
import com.japanmicrosystem.eqms.toItem
import com.japanmicrosystem.eqms.toJson
import com.squareup.moshi.Moshi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * DomainImp Class
 *
 * @author D.Noguchi
 * @since 2018/05/01
 */
class DomainImp @Inject constructor(internal val dbManager: DbManager,internal val networkApi:InventoriesService,internal val moshi: Moshi):Domain{
    override fun doSingIn(id:String){
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        networkApi.fetchUserName(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterSuccess {
                    getAll()
                }
                .subscribe({
                    // onSuccess
                }, {
                    // onError
                    Timber.e(it)
                })
    }

    override fun getAll() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        networkApi.fetchItem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterSuccess {
                    val json = "[" + it.toJson() + "]"
                    json.toItem()?.apply {
                        dbManager.add(this)
                    }
                }.subscribe({
                    Timber.d("domain getAll success")
                },{
                    Timber.e(it)
                })
    }

    override fun inventory(id:String,item:List<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}