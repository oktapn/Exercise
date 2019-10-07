package com.okta.exercisetunaiku.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.okta.exercisetunaiku.R
import com.okta.exercisetunaiku.ui.alamatktp.AlamatKtpFragment
import com.okta.exercisetunaiku.ui.datadiri.DataDiriFragment
import com.okta.exercisetunaiku.ui.reviewdata.ReviewDataFragment
import com.okta.exercisetunaiku.utils.SharedPrefferences

class MainActivity : AppCompatActivity() {
    private lateinit var session: SharedPrefferences

    private val SELECTED_MENU = "selected_menu"
    private var navView: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navView = findViewById(R.id.nav_view)
        session = SharedPrefferences(this)
        navView!!.setOnNavigationItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.action_datadiri -> {
                    fragment = DataDiriFragment()
                }
                R.id.action_alamat -> {
                    fragment = AlamatKtpFragment()
                }
                R.id.action_review -> {
                    fragment = ReviewDataFragment()
                }
            }
            if (fragment != null) {
                supportFragmentManager
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.container, fragment)
                    .commit()
            }
            true
        }
        if (savedInstanceState != null) {
            savedInstanceState.getInt(SELECTED_MENU)
        } else {
            navView?.selectedItemId = R.id.action_datadiri
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SELECTED_MENU, navView!!.selectedItemId)
    }
}
