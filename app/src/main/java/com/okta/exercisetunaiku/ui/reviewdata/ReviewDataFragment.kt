package com.okta.exercisetunaiku.ui.reviewdata


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.okta.exercisetunaiku.R

/**
 * A simple [Fragment] subclass.
 */
class ReviewDataFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review_data, container, false)
    }


}
