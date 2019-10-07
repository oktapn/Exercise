package com.okta.exercisetunaiku.deps


import com.okta.exercisetunaiku.networking.NetworkModule
import com.okta.exercisetunaiku.ui.alamatktp.AlamatKtpFragment
import dagger.Component
import javax.inject.Singleton


/**
 * Created by okta on 11/13/2018.
 */
@Singleton
@Component(modules =  arrayOf(NetworkModule::class))
interface Deps {

    fun inject(alamatKtpFragment: AlamatKtpFragment)

}
