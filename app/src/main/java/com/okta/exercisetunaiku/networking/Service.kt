package com.okta.exercisetunaiku.networking


import com.okta.exercisetunaiku.model.provinsi.ProvinsiResponse
import rx.Observable
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class Service(private val networkService: NetworkService) {


    fun getProvinsi(getProvinsiCallback: GetProvinsiCallback): Subscription {
        return networkService.getProvinsi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorResumeNext { throwable -> Observable.error(throwable) }
            .subscribe(object : Subscriber<ProvinsiResponse>() {
                override fun onCompleted() {

                }

                override fun onError(e: Throwable) {
                    getProvinsiCallback.onError(NetworkError(e))
                }

                override fun onNext(provinsiResponse: ProvinsiResponse) {
                    getProvinsiCallback.onSuccess(provinsiResponse)
                }
            })
    }

    interface GetProvinsiCallback {
        fun onSuccess(provinsiResponse: ProvinsiResponse)

        fun onError(networkError: NetworkError)
    }
}
