package com.japanmicrosystem.eqms.data

import com.squareup.moshi.Json
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Item Class
 *
 * @author D.Noguchi
 * @since 2018/05/01
 */
open class Item(
        @Json(name = "c")
        @PrimaryKey var code:String = "",
        @Json(name = "a")
        var admin:String = "",
        @Json(name = "n")
        var name:String = "",
        @Json(name = "u")
        var updater:String? = null,
        @Json(name = "d")
        var date:String? = null
) :RealmObject()

