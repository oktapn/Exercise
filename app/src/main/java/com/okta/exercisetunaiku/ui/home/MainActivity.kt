package com.okta.exercisetunaiku.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okta.exercisetunaiku.R
import com.okta.exercisetunaiku.ui.datadiri.DataDiriActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnRegister.setOnClickListener {
            val intent = Intent(this,DataDiriActivity::class.java)
            startActivity(intent)
        }
    }
}
