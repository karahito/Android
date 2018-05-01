package com.japanmicrosystem.eqms.ui.singin

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar
import com.japanmicrosystem.eqms.R
import com.japanmicrosystem.eqms.data.DbManager
import com.japanmicrosystem.eqms.data.Item
import com.japanmicrosystem.eqms.databinding.ActivityLoginBinding
import com.japanmicrosystem.eqms.network.InventoriesService
import com.japanmicrosystem.eqms.toItem
import com.japanmicrosystem.eqms.toJson
import com.japanmicrosystem.eqms.toUserStoreName
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * SignInActivity Class
 *
 * @author D.Noguchi
 * @since 2018/05/01
 */
class SignInActivity:AppCompatActivity() {
    @Inject
    lateinit var service: InventoriesService

    @Inject
    lateinit var dbManager:DbManager

    @Inject lateinit var actionCreator: SingInActionCreator

    private lateinit var binding:ActivityLoginBinding

    private fun initUi(){
            setProgressShow(false)
    }

    private fun doSignIn(id:String){
        service.fetchUserName(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    setProgressShow(true)
                }
                .doFinally {
//                    setProgressShow(false)
                }
                .doAfterSuccess {
                    doGetAll()
                }
                .subscribe(
                        {
//                            Timber.d(it.string())
                            val json = it.toJson()
                            val name = json?.toUserStoreName()
                            Timber.d(name)
//                            Timber.d(it.toJson())
                        },
                        {
                            Timber.e(it)
                        }
                )
    }

    private fun doGetAll(){
        service.fetchItem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    setProgressShow(true)
                }
                .doFinally {
                    setProgressShow(false)
                }
//                .doAfterSuccess {
//                    var json = it.toJson()
//                    json = "[$json]"
//                    val item = json.toItem() ?: return@doAfterSuccess
//                    dbManager.add(item)
//                }
                .subscribe(
                        {
                        var json = it.toJson()
                            json = "[$json]"
                            val item = json.toItem() ?: return@subscribe
                            dbManager.add(item)
                        },{
                            Timber.e(it)
                        }
                )
    }

    private fun setProgressShow(enable:Boolean){
        when(enable){
            true -> binding.progressBar.visibility = PROGRESS_VISIBLE
            false -> binding.progressBar.visibility = PROGRESS_INVISIBLE
        }
    }

    fun onClickSingIn(view:View){
        doSignIn(binding.editText.text.toString())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        initUi()
        val list = dbManager.findAll(Item::class.java)
        list?.forEach {
            Timber.d("${it.code},${it.admin},${it.name},${it.updater},${it.date}")
        }

    }



    companion object {
        @JvmStatic
        private val PROGRESS_VISIBLE = ProgressBar.VISIBLE
        @JvmStatic
        private val PROGRESS_INVISIBLE = ProgressBar.INVISIBLE
    }
}