package com.okta.exercisetunaiku.deps


import com.okta.exercisetunaiku.networking.NetworkModule
import com.okta.exercisetunaiku.ui.alamatktp.AlamatKtpActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules =  arrayOf(NetworkModule::class))
interface Deps {

    fun inject(alamatKtpActivity: AlamatKtpActivity)

}
