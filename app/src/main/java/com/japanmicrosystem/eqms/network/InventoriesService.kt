package com.japanmicrosystem.eqms.network

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface InventoriesService {
    @GET("inventories/")
    fun fetchUserName(@Query("WCODE")id:String):Single<ResponseBody>

    @GET("inventories/")
    fun inventory(@Query("WCODE",encoded = true)id:String, @Query("ECODE",encoded = true)item:List<String>):Single<ResponseBody>

    @GET("inventories/?einfo=1")
    fun fetchItem(): Single<ResponseBody>
}