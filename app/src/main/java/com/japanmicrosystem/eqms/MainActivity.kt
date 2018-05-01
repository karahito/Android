package com.japanmicrosystem.eqms

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar
import com.japanmicrosystem.eqms.databinding.ActivityLoginBinding
import com.japanmicrosystem.eqms.network.InventoriesService
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var service:InventoriesService

    lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this,R.layout.activity_login)
        binding.progressBar.visibility = ProgressBar.INVISIBLE
    }

//    fun onClickSignIn(view:View){
//        val id :String = binding.editText.text.toString()
//        service.fetchUserName(id)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe {
//                    binding.progressBar.visibility = ProgressBar.VISIBLE
//                }
//                .doAfterSuccess {
//                    succesSignIn()
//                }
//                .doFinally {
//                    binding.progressBar.visibility = ProgressBar.INVISIBLE
//                }
//                .subscribe({
//                    Timber.d(it.string())
//                },{
//                    Timber.e(it)
//                })
//    }
//
//    fun succesSignIn(){
//        service.fetchItem()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe {
//                    binding.progressBar.visibility = ProgressBar.VISIBLE
//                }
//                .doFinally {
//                    binding.progressBar.visibility = ProgressBar.INVISIBLE
//                }
//                .subscribe { it->
//                    Timber.d(it.string())
//                }
//    }
}
