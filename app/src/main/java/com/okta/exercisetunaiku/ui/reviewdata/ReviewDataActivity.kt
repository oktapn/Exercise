package com.okta.exercisetunaiku.ui.reviewdata

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.okta.exercisetunaiku.R
import com.okta.exercisetunaiku.model.datadiri.DataDiri
import com.okta.exercisetunaiku.ui.alamatktp.AlamatKtpViewModel
import com.okta.exercisetunaiku.ui.home.MainActivity
import com.okta.exercisetunaiku.utils.Constant
import kotlinx.android.synthetic.main.activity_review_data.*


class ReviewDataActivity : AppCompatActivity() {

    private lateinit var viewModel: ReviewDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_data)
        val actionBar = supportActionBar
        actionBar!!.title = "Review Data"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val dataDiri: DataDiri = intent.getParcelableExtra(Constant.KEY_DATAKTP) as DataDiri
        viewModel = ViewModelProviders.of(this).get(ReviewDataViewModel::class.java)
        viewModel.data = dataDiri
        Log.d("RData success", "my Message Prov ${viewModel.data}")
        setData()
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

    private fun setData() {
        rdNoKtp.text = viewModel.dataDiri.nomorktp
        rdNamaLengkap.text = viewModel.dataDiri.namalengkap
        rdNoRek.text = viewModel.dataDiri.nomorrekening
        rdTingkatPendidikan.text = viewModel.dataDiri.tingkatpendidikan
        rdTglLhr.text = viewModel.dataDiri.tanggallahir
        rdAlamatKtp.text = viewModel.dataDiri.alamatktp
        rdJnsTemptaTinggal.text = viewModel.dataDiri.jenistempattinggal
        rdNoBlok.text = viewModel.dataDiri.nomorblok
        rdProvinsi.text = viewModel.dataDiri.provinsi
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.itemId == android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item)
    }
}
