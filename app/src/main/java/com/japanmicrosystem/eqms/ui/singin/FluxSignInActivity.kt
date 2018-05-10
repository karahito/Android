package com.japanmicrosystem.eqms.ui.singin

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.japanmicrosystem.eqms.R
import com.japanmicrosystem.eqms.StoreProvider
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * FluxSignInActivity Class
 *
 * @author D.Noguchi
 * @since 2018/05/10
 */
class FluxSignInActivity:AppCompatActivity(),HasSupportFragmentInjector {
    @Inject lateinit var androidInjector:DispatchingAndroidInjector<Fragment>
    @Inject lateinit var storeProvider: StoreProvider
    @Inject lateinit var actionCreator: SingInActionCreator

    private val store by lazy { storeProvider.get(this,SignInStore::class) }
//    private val binding by lazy { DataBindingUtil.setContentView<>(this, R.layout.activity_main) }
    override fun supportFragmentInjector() = androidInjector
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

}