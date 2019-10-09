package com.okta.exercisetunaiku.ui.reviewdata

import androidx.lifecycle.ViewModel
import com.okta.exercisetunaiku.model.datadiri.DataDiri

class ReviewDataViewModel : ViewModel() {

    var data = DataDiri()

    val dataDiri: DataDiri
        get() {
            val datadiri = DataDiri()
            datadiri.nomorktp = data.nomorktp
            datadiri.namalengkap = data.namalengkap
            datadiri.nomorrekening = data.nomorrekening
            datadiri.tingkatpendidikan = data.tingkatpendidikan
            datadiri.tanggallahir = data.tanggallahir
            datadiri.alamatktp = data.alamatktp
            datadiri.jenistempattinggal = data.jenistempattinggal
            datadiri.nomorblok = data.nomorblok
            datadiri.provinsi = data.provinsi
            return datadiri
        }
}