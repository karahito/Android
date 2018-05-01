package com.japanmicrosystem.eqms.ui.singin

import android.arch.lifecycle.LiveData
import com.japanmicrosystem.eqms.data.Item
import com.japanmicrosystem.eqms.data.User
import com.japanmicrosystem.eqms.flux.Store
import com.japanmicrosystem.eqms.toLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * SignInStore Class
 *
 * @author D.Noguchi
 * @since 2018/05/01
 */
class SignInStore @Inject constructor(internal val dispatcher: SingInDispatcher):Store(){
    val user:LiveData<User> = dispatcher.onFetchUser
            .map { it.data }
            .observeOn(AndroidSchedulers.mainThread())
            .toLiveData()

    val item:LiveData<List<Item>> = dispatcher.onFetchItem
            .map { it.data }
            .observeOn(AndroidSchedulers.mainThread())
            .toLiveData()

}