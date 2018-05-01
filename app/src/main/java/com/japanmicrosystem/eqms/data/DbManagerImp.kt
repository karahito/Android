package com.japanmicrosystem.eqms.data

import dagger.Module
import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.exceptions.RealmException
import timber.log.Timber
import javax.inject.Inject


@Module(includes = [
    (DatabaseModule::class)
])
class DbManagerImp @Inject constructor(internal val realm:Realm):DbManager {
    override fun close() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        realm.close()
        Timber.d("Database is close")
    }

    override fun <T : RealmObject> findAll(clazz: Class<T>): RealmResults<T>? {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Timber.d("findAll at $clazz")
        return realm.where(clazz).findAll()
    }

    override fun <T : RealmObject> add(model: T): T {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Timber.d("add $model")
        return try{
            realm.run {
                beginTransaction()
                copyToRealm(model)
            }
            model
        }catch (e:RealmException){
            Timber.e(e)
            model
        }finally {
            realm.commitTransaction()
        }
    }

    override fun <T : RealmObject> add(model: List<T>): List<T> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Timber.d("add $model")
        return try{
            realm.run {
                beginTransaction()
                copyToRealmOrUpdate(model)
            }
            model
        }catch (e:RealmException){
            Timber.e(e)
            model
        }finally {
            realm.commitTransaction()
        }
    }
}