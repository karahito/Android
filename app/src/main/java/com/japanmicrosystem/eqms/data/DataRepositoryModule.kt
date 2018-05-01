package com.japanmicrosystem.eqms.data

import dagger.Binds
import dagger.Module

@Module(includes = [
    (DbManagerImp::class)
])
abstract class DataRepositoryModule {
    @Binds
    abstract internal fun bindDbManager(manager:DbManagerImp):DbManager
}