package com.okta.exercisetunaiku.ui.alamatktp

import com.okta.exercisetunaiku.model.datadiri.DataDiri
import com.okta.exercisetunaiku.model.provinsi.ProvinsiResponse
import com.okta.exercisetunaiku.networking.NetworkError
import com.okta.exercisetunaiku.networking.Service
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

class AlamatKtpViewModelTest {
    private val alamatktp = "JL KS TUBUN 2C NO 32 SLIPI PALMERAH JAKARTA BARAT DKI JAKARTA"
    private val tempattinggal = "RUMAH"
    private val noblok = "NO 32"
    private val provinsi = "DKI JAKARTA"

    @Mock
    private
    lateinit var view: AlamatKtpView

    @Mock
    @Inject
    lateinit var service: Service
    lateinit var alamatKtpViewModel: AlamatKtpViewModel


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        alamatKtpViewModel = AlamatKtpViewModel(service, view)
    }


    @Test
    fun service() {
        val subscriptions = CompositeSubscription()
        GlobalScope.launch {
            Mockito.`when`(
                service.getProvinsi(object : Service.GetProvinsiCallback {
                    override fun onSuccess(provinsiResponse: ProvinsiResponse) {
                        Mockito.verify(view).getResponse(provinsiResponse)
                    }

                    override fun onError(networkError: NetworkError) {
                        Mockito.verify(view).onFailure(networkError.appErrorMessage)
                    }
                })
            ).thenReturn(subscriptions)
            alamatKtpViewModel.getProvinsi()
            Mockito.verify(view).showWait()
        }
    }

    @Test
    fun testFormAlamatKtp() {
        val dataDiri = DataDiri()
        dataDiri.alamatktp = alamatktp
        dataDiri.jenistempattinggal = tempattinggal
        dataDiri.nomorblok = noblok
        dataDiri.provinsi = provinsi
        alamatKtpViewModel?.setDataDiri(alamatktp, tempattinggal, noblok, provinsi)
        Assert.assertEquals(dataDiri.alamatktp, alamatKtpViewModel?.dataDiris?.alamatktp)
        Assert.assertEquals(
            dataDiri.jenistempattinggal,
            alamatKtpViewModel?.dataDiris?.jenistempattinggal
        )
        Assert.assertEquals(dataDiri.nomorblok, alamatKtpViewModel?.dataDiris?.nomorblok)
        Assert.assertEquals(dataDiri.provinsi, alamatKtpViewModel?.dataDiris?.provinsi)
    }
}