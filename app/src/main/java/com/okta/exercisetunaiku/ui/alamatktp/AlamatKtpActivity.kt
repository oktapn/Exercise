package com.okta.exercisetunaiku.ui.alamatktp

import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.okta.exercisetunaiku.BaseApp
import com.okta.exercisetunaiku.R
import com.okta.exercisetunaiku.model.datadiri.DataDiri
import com.okta.exercisetunaiku.model.provinsi.ProvinsiResponse
import com.okta.exercisetunaiku.model.tempattinggal.TempatTinggal
import com.okta.exercisetunaiku.networking.Service
import com.okta.exercisetunaiku.ui.reviewdata.ReviewDataActivity
import com.okta.exercisetunaiku.utils.Constant.KEY_BUNDLE
import com.okta.exercisetunaiku.utils.Constant.KEY_DATAKTP
import kotlinx.android.synthetic.main.activity_alamat_ktp.*
import kotlinx.android.synthetic.main.activity_data_diri.*
import java.util.ArrayList
import javax.inject.Inject


class AlamatKtpActivity : BaseApp(), AlamatKtpView {

    private var viewModel: AlamatKtpViewModel? = null
    @Inject
    lateinit var service: Service

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alamat_ktp)
        deps.inject(this)
        val actionBar = supportActionBar
        actionBar!!.title = "Alamat KTP"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        viewModel = ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return AlamatKtpViewModel(service, this@AlamatKtpActivity) as T
            }
        })[AlamatKtpViewModel::class.java]
        viewModel?.getProvinsi()
        setBtnNextAction()
        etNoBlokFilter()
        setSpinnerTingkatPendidikan()
        val datadiri: DataDiri? = intent.getParcelableExtra(KEY_DATAKTP) as? DataDiri
        viewModel?.initialDatadiri(datadiri)
        Log.d("RData success", "my Message Prov ${viewModel?.dataDiris}")
    }

    private fun setSpinnerTingkatPendidikan() {
        spnJnsTempatTinggal.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, TempatTinggal.values()
        )
    }

    private fun etNoBlokFilter() {
        etNoBlok.filters = arrayOf(InputFilter { cs, start, end, spanned, dStart, dEnd ->
            // TODO Auto-generated method stub
            if (cs == "") { // for backspace
                return@InputFilter cs
            }
            if (cs.toString().matches("[a-zA-Z0-9 ]+".toRegex())) {
                cs
            } else ""
        })
    }

    private fun setBtnNextAction() {
        btnNextAlamatKtp.setOnClickListener {
            when {
                etAlamatKtp.text.isEmpty() -> {
                    Snackbar.make(
                        root_layout_alamat_ktp,
                        "Isi Alamat KTP",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                spnJnsTempatTinggal.selectedItem.toString() == "Pilih Tempat Tinggal..." -> {
                    Snackbar.make(
                        root_layout_alamat_ktp,
                        "Pilih Tempat Tinggal",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                etNoBlok.text.isEmpty() -> {
                    Snackbar.make(
                        root_layout_alamat_ktp,
                        "Isi Nomor Blok",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                spnProvinsi.selectedItem.toString() == "Pilih Provinsi..." -> {
                    Snackbar.make(
                        root_layout_alamat_ktp,
                        "Pilih Provinsi",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                else -> {
                    val alktp = etAlamatKtp.text.toString()
                    val tmpttinggal = spnJnsTempatTinggal.selectedItem.toString()
                    val nomorblok = etNoBlok.text.toString()
                    val provinsi = spnProvinsi.selectedItem.toString()
                    viewModel?.setDataDiri(alktp, tmpttinggal, nomorblok, provinsi)
                    val intent = Intent(this, ReviewDataActivity::class.java)
                    intent.putExtra(KEY_DATAKTP, viewModel?.dataDiris)
                    startActivity(intent)
                }
            }
        }
    }

    override fun showWait() {
        pBar.visibility = View.VISIBLE
    }

    override fun removeWait() {
        pBar.visibility = View.GONE
    }

    override fun onFailure(appErrorMessage: String) {
        Log.d("RProv error Act", "my Message Prov $appErrorMessage")
        Snackbar.make(
            root_layout_alamat_ktp,
            appErrorMessage,
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun getResponse(provinsiResponse: ProvinsiResponse) {
        Log.d("RProv success Act", "my Message Prov $provinsiResponse")
        val listProvinsi = ArrayList<String>()
        listProvinsi.add("Pilih Provinsi...")
        for (i in 0 until provinsiResponse.semuaprovinsi.size) {
            val reponseprov = provinsiResponse.semuaprovinsi[i].nama
            listProvinsi.add(reponseprov)
        }
        spnProvinsi.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, listProvinsi
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.itemId == android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item)
    }
}
