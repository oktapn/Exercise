package com.okta.exercisetunaiku.ui.reviewdata

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.okta.exercisetunaiku.R
import com.okta.exercisetunaiku.model.datadiri.DataDiri
import com.okta.exercisetunaiku.ui.home.MainActivity
import com.okta.exercisetunaiku.utils.Constant
import kotlinx.android.synthetic.main.activity_data_diri.*
import kotlinx.android.synthetic.main.activity_review_data.*


class ReviewDataActivity : AppCompatActivity() {

    var dataDiri: DataDiri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_data)
        val actionBar = supportActionBar
        actionBar!!.title = "Review Data"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        dataDiri = intent.getSerializableExtra(Constant.KEY_DATAKTP) as? DataDiri
        setData()
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

    private fun setData() {
        rdNoKtp.text = dataDiri?.nomorktp
        rdNamaLengkap.text = dataDiri?.namalengkap
        rdNoRek.text = dataDiri?.nomorrekening
        rdTingkatPendidikan.text = dataDiri?.tingkatpendidikan
        rdTglLhr.text = dataDiri?.tanggallahir
        rdAlamatKtp.text = dataDiri?.alamatktp
        rdJnsTemptaTinggal.text = dataDiri?.jenistempattinggal
        rdNoBlok.text = dataDiri?.nomorblok
        rdProvinsi.text = dataDiri?.provinsi
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.itemId == android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item)
    }
}
