package com.okta.exercisetunaiku.ui.alamatktp

import android.util.Log
import androidx.lifecycle.ViewModel
import com.okta.exercisetunaiku.model.datadiri.DataDiri
import com.okta.exercisetunaiku.model.provinsi.ProvinsiResponse
import com.okta.exercisetunaiku.networking.NetworkError
import com.okta.exercisetunaiku.networking.Service
import rx.subscriptions.CompositeSubscription

class AlamatKtpViewModel(val service: Service, val view: AlamatKtpView) : ViewModel() {
    private val subscriptions = CompositeSubscription()

    var dataDiris = DataDiri()

    fun initialDatadiri(dataDiri: DataDiri?){
        if (dataDiri != null) {
            dataDiris = dataDiri
        }
    }

    fun getProvinsi() {
        view.showWait()
        val subscription = service.getProvinsi(object : Service.GetProvinsiCallback {
            override fun onSuccess(provinsiResponse: ProvinsiResponse) {
                view.removeWait()
                Log.d("RProv success", "my Message Prov $provinsiResponse")
                view.getResponse(provinsiResponse)
            }

            override fun onError(networkError: NetworkError) {
                view.removeWait()
                Log.d("RProv error", "my Message Prov ${networkError.error.toString()}")
                view.onFailure(networkError.appErrorMessage)
            }
        })
        subscriptions.add(subscription)
    }

    fun setDataDiri(alamatktp: String, tempattinggal: String, noblok: String, provinsi: String) {
        dataDiris.alamatktp = alamatktp
        dataDiris.jenistempattinggal = tempattinggal
        dataDiris.nomorblok = noblok
        dataDiris.provinsi = provinsi
    }
}