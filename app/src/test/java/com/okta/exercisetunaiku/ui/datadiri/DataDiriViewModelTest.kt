package com.okta.exercisetunaiku.ui.datadiri

import com.okta.exercisetunaiku.model.datadiri.DataDiri
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.jvm.internal.Reflection


class DataDiriViewModelTest {

    private var dataDiriViewModel: DataDiriViewModel? = null
    private val nomorktp = "1234567890000000"
    private val namalengkap = "OKTA"
    private val nomorrekening = "12345678"
    private val pendidikan = "S1"
    private val tgllahir = "11-10-1996"

    @Before
    fun init() {
        dataDiriViewModel = DataDiriViewModel()
    }

    @Test
    fun testFormDataDiri() {
        val dataDiri = DataDiri()
        dataDiri.nomorktp = nomorktp
        dataDiri.namalengkap = namalengkap
        dataDiri.nomorrekening = nomorrekening
        dataDiri.tingkatpendidikan = pendidikan
        dataDiri.tanggallahir = tgllahir
        dataDiriViewModel?.setDataDiri(nomorktp, namalengkap, nomorrekening, pendidikan, tgllahir)
        assertEquals(dataDiri.nomorktp,dataDiriViewModel?.dataDiri?.nomorktp)
        assertEquals(dataDiri.namalengkap,dataDiriViewModel?.dataDiri?.namalengkap)
        assertEquals(dataDiri.nomorrekening,dataDiriViewModel?.dataDiri?.nomorrekening)
        assertEquals(dataDiri.tingkatpendidikan,dataDiriViewModel?.dataDiri?.tingkatpendidikan)
        assertEquals(dataDiri.tanggallahir,dataDiriViewModel?.dataDiri?.tanggallahir)
    }
}