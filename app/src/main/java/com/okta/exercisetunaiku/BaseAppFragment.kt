package com.okta.exercisetunaiku

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.okta.exercisetunaiku.deps.DaggerDeps
import com.okta.exercisetunaiku.deps.Deps
import com.okta.exercisetunaiku.networking.NetworkModule

import java.io.File

open class BaseAppFragment : Fragment() {
    lateinit var deps: Deps
        internal set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cacheFile = File(context?.cacheDir, "responses")
        deps = DaggerDeps.builder().networkModule(NetworkModule(cacheFile)).build()
    }
}
