package com.japanmicrosystem.eqms.domain

/**
 * Domain Class
 *
 * @author D.Noguchi
 * @since 2018/05/01
 */
interface Domain {
    fun doSingIn(id:String)
    fun inventory(id:String,item:List<String>):Unit
    fun getAll():Unit
}