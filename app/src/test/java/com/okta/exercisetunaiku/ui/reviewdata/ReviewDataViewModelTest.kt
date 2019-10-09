package com.okta.exercisetunaiku.ui.reviewdata

import com.okta.exercisetunaiku.model.datadiri.DataDiri
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ReviewDataViewModelTest{

    private var reviewDataViewModel: ReviewDataViewModel? = null
    private val nomorktp = "1234567890000000"
    private val namalengkap = "OKTA"
    private val nomorrekening = "12345678"
    private val pendidikan = "S1"
    private val tgllahir = "11-10-1996"
    private val alamatktp = "JL KS TUBUN 2C NO 32 SLIPI PALMERAH JAKARTA BARAT DKI JAKARTA"
    private val tempattinggal = "RUMAH"
    private val noblok = "NO 32"
    private val provinsi = "DKI JAKARTA"

    @Before
    fun init() {
        reviewDataViewModel = ReviewDataViewModel()
    }

    @Test
    fun testFormDataReview() {
        val dataDiri = DataDiri()
        dataDiri.nomorktp = nomorktp
        dataDiri.namalengkap = namalengkap
        dataDiri.nomorrekening = nomorrekening
        dataDiri.tingkatpendidikan = pendidikan
        dataDiri.tanggallahir = tgllahir
        dataDiri.alamatktp = alamatktp
        dataDiri.jenistempattinggal = tempattinggal
        dataDiri.nomorblok = noblok
        dataDiri.provinsi = provinsi
        reviewDataViewModel?.data = dataDiri
        assertEquals(dataDiri.nomorktp,reviewDataViewModel?.dataDiri?.nomorktp)
        assertEquals(dataDiri.namalengkap,reviewDataViewModel?.dataDiri?.namalengkap)
        assertEquals(dataDiri.nomorrekening,reviewDataViewModel?.dataDiri?.nomorrekening)
        assertEquals(dataDiri.tingkatpendidikan,reviewDataViewModel?.dataDiri?.tingkatpendidikan)
        assertEquals(dataDiri.tanggallahir,reviewDataViewModel?.dataDiri?.tanggallahir)
        assertEquals(dataDiri.alamatktp,reviewDataViewModel?.dataDiri?.alamatktp)
        assertEquals(dataDiri.jenistempattinggal,reviewDataViewModel?.dataDiri?.jenistempattinggal)
        assertEquals(dataDiri.nomorblok,reviewDataViewModel?.dataDiri?.nomorblok)
        assertEquals(dataDiri.provinsi,reviewDataViewModel?.dataDiri?.provinsi)
    }
}