package com.okta.exercisetunaiku.utils

import android.content.Context
import android.content.SharedPreferences
import com.okta.exercisetunaiku.model.alamatktp.AlamatKtp
import com.okta.exercisetunaiku.model.datadiri.DataDiri
import com.okta.exercisetunaiku.utils.Constant.KEY_ALAMAT
import com.okta.exercisetunaiku.utils.Constant.KEY_JENISTEMPATT
import com.okta.exercisetunaiku.utils.Constant.KEY_NAMALENGKAP
import com.okta.exercisetunaiku.utils.Constant.KEY_NOBLOK
import com.okta.exercisetunaiku.utils.Constant.KEY_NOKTP
import com.okta.exercisetunaiku.utils.Constant.KEY_NOREK
import com.okta.exercisetunaiku.utils.Constant.KEY_PENDIDIKAN
import com.okta.exercisetunaiku.utils.Constant.KEY_PROVINSI
import com.okta.exercisetunaiku.utils.Constant.KEY_TGLLAHIR
import com.okta.exercisetunaiku.utils.Constant.PREF_NAME

class SharedPrefferences(private var context: Context) {

    private var sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor

    init {
        editor = sharedPreferences.edit()
        editor.apply()
    }

    fun createDataDiriTemp(dataDiri: DataDiri) {
        editor.putString(KEY_NOKTP, dataDiri.nomorktp)
        editor.putString(KEY_NAMALENGKAP, dataDiri.namalengkap)
        editor.putString(KEY_NOREK, dataDiri.nomorrekening)
        editor.putString(KEY_PENDIDIKAN, dataDiri.tingkatpendidikan)
        editor.putString(KEY_TGLLAHIR, dataDiri.tanggallahir)
        editor.commit()
    }

    val dataDiri: DataDiri
        get() {
            val datadiri = DataDiri()
            datadiri.nomorktp = sharedPreferences.getString(KEY_NOKTP, null)
            datadiri.namalengkap = sharedPreferences.getString(KEY_NAMALENGKAP, null)
            datadiri.nomorrekening = sharedPreferences.getString(KEY_NOREK, null)
            datadiri.tingkatpendidikan = sharedPreferences.getString(KEY_PENDIDIKAN, null)
            datadiri.tanggallahir = sharedPreferences.getString(KEY_TGLLAHIR, null)
            return datadiri
        }

    fun createTempAlamatKtp(alamatKtp: AlamatKtp) {
        editor.putString(KEY_ALAMAT, alamatKtp.alamatktp)
        editor.putString(KEY_JENISTEMPATT, alamatKtp.jenistempattinggal)
        editor.putString(KEY_NOBLOK, alamatKtp.nomorblok)
        editor.putString(KEY_PROVINSI, alamatKtp.provinsi)
        editor.commit()
    }

    val alamatKtp: AlamatKtp
        get() {
            val alamatKtp = AlamatKtp()
            alamatKtp.alamatktp = sharedPreferences.getString(KEY_ALAMAT,null)
            alamatKtp.jenistempattinggal = sharedPreferences.getString(KEY_JENISTEMPATT,null)
            alamatKtp.nomorblok = sharedPreferences.getString(KEY_NOBLOK,null)
            alamatKtp.provinsi = sharedPreferences.getString(KEY_PROVINSI,null)
            return alamatKtp
        }

    fun clearTempdata() {
        editor.clear()
        editor.commit()
    }

}