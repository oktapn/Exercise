package com.okta.exercisetunaiku.ui.alamatktp

import androidx.lifecycle.ViewModel
import com.okta.exercisetunaiku.model.provinsi.ProvinsiResponse
import com.okta.exercisetunaiku.networking.NetworkError
import com.okta.exercisetunaiku.networking.Service
import rx.subscriptions.CompositeSubscription

class AlamatKtpViewModel(val service: Service, val view: AlamatKtpView) :
    ViewModel() {
    private val subscriptions = CompositeSubscription()

    fun getProvinsi() {
        view.showWait()
        val subscription = service.getProvinsi(object : Service.GetProvinsiCallback {
            override fun onSuccess(provinsiResponse: ProvinsiResponse) {
                view.removeWait()
                view.getResponse(provinsiResponse)
            }

            override fun onError(networkError: NetworkError) {
                view.removeWait()
                view.onFailure(networkError.appErrorMessage)
            }
        })
        subscriptions.add(subscription)
    }
}