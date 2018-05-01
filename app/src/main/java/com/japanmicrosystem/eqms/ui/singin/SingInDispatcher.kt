package com.japanmicrosystem.eqms.ui.singin

import com.japanmicrosystem.eqms.flux.Dispatcher
import io.reactivex.Flowable
import io.reactivex.processors.BehaviorProcessor
import io.reactivex.processors.FlowableProcessor

/**
 * SingInDispatcher Class
 *
 * @author D.Noguchi
 * @since 2018/05/01
 */
class SingInDispatcher :Dispatcher(){

    private val dispatcherFetchUser:FlowableProcessor<SingInAction.FetchUser> = BehaviorProcessor.create<SingInAction.FetchUser>().toSerialized()
    val onFetchUser:Flowable<SingInAction.FetchUser> = dispatcherFetchUser

    private val dispatcherFetchItem:FlowableProcessor<SingInAction.FetchItem> = BehaviorProcessor.create<SingInAction.FetchItem>().toSerialized()
    val onFetchItem:Flowable<SingInAction.FetchItem> = dispatcherFetchItem

    fun dispatch(action: SingInAction.FetchUser){
        dispatcherFetchUser.onNext(action)
    }

    fun dispatch(action:SingInAction.FetchItem){
        dispatcherFetchItem.onNext(action)
    }
}
