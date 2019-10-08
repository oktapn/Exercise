package com.okta.exercisetunaiku.ui.alamatktp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.view.MenuItem
import android.widget.ArrayAdapter
import com.google.android.material.snackbar.Snackbar
import com.okta.exercisetunaiku.R
import com.okta.exercisetunaiku.model.datadiri.DataDiri
import com.okta.exercisetunaiku.model.pendidikan.Pendidikan
import com.okta.exercisetunaiku.model.tempattinggal.TempatTinggal
import com.okta.exercisetunaiku.ui.reviewdata.ReviewDataActivity
import com.okta.exercisetunaiku.utils.Constant.KEY_DATAKTP
import kotlinx.android.synthetic.main.activity_alamat_ktp.*
import kotlinx.android.synthetic.main.activity_data_diri.*

class AlamatKtpActivity : AppCompatActivity() {

    var dataDiri: DataDiri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alamat_ktp)
        val actionBar = supportActionBar
        actionBar!!.title = "Alamat KTP"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        setBtnNextAction()
        etNoBlokFilter()
        setSpinnerTingkatPendidikan()
        dataDiri = intent.getSerializableExtra(KEY_DATAKTP) as? DataDiri
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
                        root_layout_data_diri,
                        "Pilih Tempat Tinggal",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                etNoBlok.text.isEmpty() -> {
                    Snackbar.make(
                        root_layout_data_diri,
                        "Isi Nomor Blok",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                spnProvinsi.selectedItem.toString() == "Pilih Provinsi..." -> {
                    Snackbar.make(
                        root_layout_data_diri,
                        "Pilih Provinsi",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                else -> {
                    val intent = Intent(this, ReviewDataActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.itemId == android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item)
    }
}
