package com.okta.exercisetunaiku.model.provinsi


import com.google.gson.annotations.SerializedName

data class ProvinsiResponse(
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("semuaprovinsi")
    val semuaprovinsi: List<Semuaprovinsi>
)