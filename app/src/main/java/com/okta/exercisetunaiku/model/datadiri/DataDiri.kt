package com.okta.exercisetunaiku.model.datadiri

import android.os.Parcel
import android.os.Parcelable

class DataDiri() : Parcelable {
    var nomorktp: String? = ""
    var namalengkap: String? = ""
    var nomorrekening: String? = ""
    var tingkatpendidikan: String? = ""
    var tanggallahir: String? = ""
    var alamatktp: String? = ""
    var jenistempattinggal: String? = ""
    var nomorblok: String? = ""
    var provinsi: String? = ""

    constructor(parcel: Parcel) : this() {
        nomorktp = parcel.readString()
        namalengkap = parcel.readString()
        nomorrekening = parcel.readString()
        tingkatpendidikan = parcel.readString()
        tanggallahir = parcel.readString()
        alamatktp = parcel.readString()
        jenistempattinggal = parcel.readString()
        nomorblok = parcel.readString()
        provinsi = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nomorktp)
        parcel.writeString(namalengkap)
        parcel.writeString(nomorrekening)
        parcel.writeString(tingkatpendidikan)
        parcel.writeString(tanggallahir)
        parcel.writeString(alamatktp)
        parcel.writeString(jenistempattinggal)
        parcel.writeString(nomorblok)
        parcel.writeString(provinsi)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataDiri> {
        override fun createFromParcel(parcel: Parcel): DataDiri {
            return DataDiri(parcel)
        }

        override fun newArray(size: Int): Array<DataDiri?> {
            return arrayOfNulls(size)
        }
    }
}