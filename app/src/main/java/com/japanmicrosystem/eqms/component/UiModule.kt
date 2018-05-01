package com.japanmicrosystem.eqms.component

import com.japanmicrosystem.eqms.MainActivity
import com.japanmicrosystem.eqms.ui.singin.SignInActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * UiModule Class
 *
 * @author D.Noguchi
 * @since 2018/05/01
 */
@Module
internal abstract class UiModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity():MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributeSingInActivity(): SignInActivity
}