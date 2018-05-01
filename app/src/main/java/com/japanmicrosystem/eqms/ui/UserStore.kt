package com.japanmicrosystem.eqms.ui

import com.squareup.moshi.Json

/**
 * UserStore Class
 *
 * @author D.Noguchi
 * @since 2018/05/01
 */
data class UserStore(
        var id:String? = null,
        @Json(name = "NAME")
        var name:String? = null
)
