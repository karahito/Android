package com.japanmicrosystem.eqms.data

import io.realm.RealmObject
import io.realm.RealmResults

interface DbManager {
    fun close()
    fun <T:RealmObject> findAll(clazz: Class<T>):RealmResults<T>?
    fun <T:RealmObject> add(model:T):T
    fun <T:RealmObject> add(model:List<T>):List<T>
}