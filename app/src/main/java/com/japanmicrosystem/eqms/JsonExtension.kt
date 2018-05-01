package com.japanmicrosystem.eqms

import com.japanmicrosystem.eqms.data.Item
import com.japanmicrosystem.eqms.ui.UserStore
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import okhttp3.ResponseBody
import org.jsoup.Jsoup
import pl.droidsonroids.jspoon.Jspoon
import pl.droidsonroids.jspoon.annotation.Selector
import timber.log.Timber
import java.util.jar.Attributes
import javax.inject.Inject

fun ResponseBody.toJson():String?{
    val doc = Jsoup.parse(this.string()).body()
//    Timber.d(doc.toString())
    val adapter = Jspoon.create().adapter(JsonFromHtml::class.java)
    val json = adapter.fromHtml(doc.text()).json
    Timber.d(json)
    return adapter.fromHtml(doc.text()).json
}

class JsonFromHtml {
    @Selector("body") var json:String? = null
}

fun String.toItem():List<Item>?{
    val listMyData = Types.newParameterizedType(List::class.java,Item::class.java)
    val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    val adapter: JsonAdapter<List<Item>> = moshi.adapter(listMyData)
    return adapter.fromJson(this)
}

fun String.toUserStoreName():String{
    val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    val adapter:JsonAdapter<UserStore> = moshi.adapter(UserStore::class.java)
    val name = adapter.fromJson(this)?.name
    return name ?: ""
}