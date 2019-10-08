package com.okta.exercisetunaiku.model.tempattinggal

enum class TempatTinggal(private val theState: String) {
    Pilih("Pilih Tempat Tinggal..."),
    Rumah("Rumah"),
    Kantor("Kantor");

    override fun toString(): String {
        return theState
    }
}