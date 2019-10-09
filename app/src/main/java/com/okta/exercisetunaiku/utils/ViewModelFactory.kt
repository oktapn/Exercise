package com.okta.exercisetunaiku.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.okta.exercisetunaiku.networking.Service
import com.okta.exercisetunaiku.ui.alamatktp.AlamatKtpView

class ViewModelFactory(
    private val service: Service, val view: AlamatKtpView
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelFactory(service,view) as T
    }
}