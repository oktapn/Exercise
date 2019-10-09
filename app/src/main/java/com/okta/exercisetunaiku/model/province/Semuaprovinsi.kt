package com.okta.exercisetunaiku.model.province


import com.google.gson.annotations.SerializedName

data class Semuaprovinsi(
    @SerializedName("id")
    val id: String,
    @SerializedName("nama")
    val nama: String
)