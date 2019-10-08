package com.okta.exercisetunaiku.ui.datadiri

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.okta.exercisetunaiku.R
import com.okta.exercisetunaiku.model.datadiri.DataDiri
import com.okta.exercisetunaiku.model.pendidikan.Pendidikan
import com.okta.exercisetunaiku.ui.alamatktp.AlamatKtpActivity
import com.okta.exercisetunaiku.utils.Constant.KEY_DATAKTP
import kotlinx.android.synthetic.main.activity_data_diri.*
import java.text.SimpleDateFormat
import java.util.*


class DataDiriActivity : AppCompatActivity() {

    var dataDiri: DataDiri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_diri)
        val actionBar = supportActionBar
        actionBar!!.title = "Data Diri"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        btnNextDataDiri.setOnClickListener {
            setBtnNextDataDiriAction()
        }
        etNamaLengkapFilter()
        setSpinnerTingkatPendidikan()
        etTglLhr.setOnClickListener {
            setDatePicketTglLahir()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setDatePicketTglLahir() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        var month = c.get(Calendar.MONTH)
        var day = c.get(Calendar.DAY_OF_MONTH)


        val dpd = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                // Display Selected date in textbox
                val calendar = Calendar.getInstance()
                calendar.set(year, monthOfYear, dayOfMonth)

                val format = SimpleDateFormat("dd-MM-yyyy")
                val strDate = format.format(calendar.time)
                etTglLhr.setText("$strDate")
            },
            year,
            month,
            day
        )

        dpd.show()
    }

    private fun setSpinnerTingkatPendidikan() {
        spnTingkatPendidikan.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, Pendidikan.values()
        )
    }

    private fun etNamaLengkapFilter() {
        val maxLength = 10
        val fArray = arrayOfNulls<InputFilter>(1)
        etNamaLengkap.filters = arrayOf(InputFilter { cs, start, end, spanned, dStart, dEnd ->
            // TODO Auto-generated method stub
            if (cs == "") { // for backspace
                return@InputFilter cs
            }
            if (cs.toString().matches("[a-zA-Z ]+".toRegex())) {
                cs
            } else ""
        })
        fArray[0] = InputFilter.LengthFilter(maxLength)
        etNamaLengkap.filters = fArray
    }

    private fun setBtnNextDataDiriAction() {
        when {
            etNoKtp.text.isEmpty() -> {
                Snackbar.make(root_layout_data_diri, "Harap Isi Nomor KTP", Snackbar.LENGTH_LONG)
                    .show()
            }
            etNoKtp.text.length != 16 -> {
                Snackbar.make(
                    root_layout_data_diri,
                    "Isi Nomor KTP Masih Kurang",
                    Snackbar.LENGTH_LONG
                ).show()

            }
            etNamaLengkap.text.isEmpty() -> {
                Snackbar.make(
                    root_layout_data_diri,
                    "Harap Isi Nama Lengkap",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            }
            etNoRek.text.isEmpty() -> {
                Snackbar.make(
                    root_layout_data_diri,
                    "Harap Isi Nomor Rekening",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            }
            etNoRek.text.length != 8 -> {
                Snackbar.make(
                    root_layout_data_diri,
                    "Isi Nomor Rekening Masih Kurang",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            }
            spnTingkatPendidikan.selectedItem.toString() == "Pilih Pendidikan..." -> {
                Snackbar.make(root_layout_data_diri, "Pilih Pendidikan", Snackbar.LENGTH_LONG)
                    .show()
            }
            etTglLhr.text.isEmpty() -> {
                Snackbar.make(
                    root_layout_data_diri,
                    "Harap Isi Tanggal Lahir",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            }
            else -> {
                dataDiri?.nomorktp = etNoKtp.text.toString()
                dataDiri?.namalengkap = etNamaLengkap.text.toString()
                dataDiri?.nomorrekening = etNoRek.text.toString()
                dataDiri?.tingkatpendidikan = spnTingkatPendidikan.selectedItem.toString()
                dataDiri?.tanggallahir = etTglLhr.text.toString()
                val intent = Intent(this, AlamatKtpActivity::class.java)
                intent.putExtra(KEY_DATAKTP, dataDiri)
                startActivity(intent)
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
