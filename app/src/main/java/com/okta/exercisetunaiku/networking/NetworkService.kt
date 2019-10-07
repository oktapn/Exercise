package com.okta.exercisetunaiku.networking


import com.okta.exercisetunaiku.model.provinsi.ProvinsiResponse
import retrofit2.http.GET
import rx.Observable

interface NetworkService {
    @GET("provinsi")
    fun getProvinsi(): Observable<ProvinsiResponse>
}
