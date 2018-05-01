package com.japanmicrosystem.eqms.data

import com.squareup.moshi.Json

/**
 * User Class
 *
 * @author D.Noguchi
 * @since 2018/05/01
 */
data class User(
        val id:String,
        @Json(name = "NAME")
        val name:String?
)