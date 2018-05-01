package com.japanmicrosystem.eqms.ui.singin

import com.japanmicrosystem.eqms.data.Item
import com.japanmicrosystem.eqms.data.User
import com.japanmicrosystem.eqms.flux.Action

/**
 * SingInAction Class
 *
 * @author D.Noguchi
 * @since 2018/05/01
 */
sealed class SingInAction<out T>: Action<T> {
    class FetchUser(override val data:User): SingInAction<User>()
    class FetchItem(override val data:List<Item>):SingInAction<List<Item>>()
}