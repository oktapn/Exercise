package com.okta.exercisetunaiku.ui.alamatktp

import com.okta.exercisetunaiku.model.provinsi.ProvinsiResponse

interface AlamatKtpView {
    fun showWait()

    fun removeWait()

    fun onFailure(appErrorMessage: String)

    fun getResponse(provinsiResponse: ProvinsiResponse)
}