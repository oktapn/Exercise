package com.okta.exercisetunaiku.model.provinsi


import com.google.gson.annotations.SerializedName

data class Semuaprovinsi(
    @SerializedName("id")
    val id: String,
    @SerializedName("nama")
    val nama: String
)