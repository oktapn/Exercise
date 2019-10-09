package com.okta.exercisetunaiku.model.province


import com.google.gson.annotations.SerializedName

data class ProvinceResponse(
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("semuaprovinsi")
    val semuaprovinsi: List<Semuaprovinsi>
)