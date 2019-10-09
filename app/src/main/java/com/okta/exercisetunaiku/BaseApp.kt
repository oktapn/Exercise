package com.okta.exercisetunaiku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.okta.exercisetunaiku.deps.DaggerDeps
import com.okta.exercisetunaiku.deps.Deps
import com.okta.exercisetunaiku.networking.NetworkModule

import java.io.File

open class BaseApp : AppCompatActivity() {
    lateinit var deps: Deps
        internal set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cacheFile = File(cacheDir, "responses")
        deps = DaggerDeps.builder().networkModule(NetworkModule(cacheFile)).build()
    }
}
