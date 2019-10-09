package com.okta.exercisetunaiku.ui.datadiri

import androidx.lifecycle.ViewModel
import com.okta.exercisetunaiku.model.datadiri.DataDiri

class DataDiriViewModel : ViewModel() {
    var dataDiri = DataDiri()

    fun setDataDiri(noktp: String, nama: String, norek: String, pendidikan: String, tglLhr: String) {
        dataDiri.nomorktp = noktp
        dataDiri.namalengkap = nama
        dataDiri.nomorrekening = norek
        dataDiri.tingkatpendidikan = pendidikan
        dataDiri.tanggallahir = tglLhr
    }
}