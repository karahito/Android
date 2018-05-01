package com.japanmicrosystem.eqms.ui.singin

import com.japanmicrosystem.eqms.data.User
import com.japanmicrosystem.eqms.network.InventoriesService
import com.japanmicrosystem.eqms.toItem
import com.japanmicrosystem.eqms.toJson
import com.japanmicrosystem.eqms.toUserStoreName
import com.squareup.moshi.Moshi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * SingInActionCreator Class
 *
 * @author D.Noguchi
 * @since 2018/05/01
 */

class SingInActionCreator @Inject constructor(internal val service: InventoriesService,
                                              internal val dispatcher: SingInDispatcher,
                                              internal val moshi:Moshi
){

    fun fetchUser(id:String){
        service.fetchUserName(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {
                            val json = it.toJson()
                            val name = json?.toUserStoreName()
                            val data = User(id,name)
                            dispatcher.dispatch(SingInAction.FetchUser(data))
                        },
                        onError = {
                            Timber.e(it)
                        }
                )

    }

    fun fetchItem(){
        service.fetchItem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {
                            val json = it.toJson()
                            val item = json?.toItem() ?: return@subscribeBy
                            dispatcher.dispatch(SingInAction.FetchItem(item))
                        },
                        onError = {
                            Timber.e(it)
                        }
                )
    }
}