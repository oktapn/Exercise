package com.okta.exercisetunaiku.model.pendidikan

enum class Pendidikan(private val theState: String) {
    Pilih("Pilih Pendidikan..."),
    SD("SD"),
    SMP("SMP"),
    SMA("SMA"),
    S1("S1"),
    S2("S2"),
    S3("S3");

    override fun toString(): String {
        return theState
    }
}