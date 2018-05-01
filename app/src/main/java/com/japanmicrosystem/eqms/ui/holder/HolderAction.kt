package com.japanmicrosystem.eqms.ui.holder

import android.drm.DrmStore
import com.japanmicrosystem.eqms.flux.Action

/**
 * HolderAction Class
 *
 * @author D.Noguchi
 * @since 2018/05/01
 */
sealed class HolderAction<out T>:Action<T> {
}