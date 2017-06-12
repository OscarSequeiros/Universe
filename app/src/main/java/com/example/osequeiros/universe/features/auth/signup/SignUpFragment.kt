package com.example.osequeiros.universe.features.auth.signup

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.osequeiros.universe.R

/**
 * Created by osequeiros on 3/06/17.
 * Fragmeng Sign Up
 */

class SignUpFragment: Fragment() {

    companion object {
        fun newInstance(): SignUpFragment = SignUpFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /*override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        val view: View = inflater!!.inflate(R.layout.fragment_sign_up, container, false)

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }*/
}
