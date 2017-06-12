package com.example.osequeiros.universe.features.auth.signin

import android.app.Fragment
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.osequeiros.universe.R
import com.example.osequeiros.universe.features.auth.LoginActivity
import com.example.osequeiros.universe.features.auth.signup.SignUpFragment
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.GoogleApiClient

/**
 * Created by osequeiros on 3/06/17.
 * Fragment SignIn
 */

class SignInFragment {

    companion object {
        fun newInstance(): SignInFragment = SignInFragment()
        lateinit var presenter : SignInPresenterImpl
        lateinit var mGoogleApiClient : GoogleApiClient
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        presenter = SignInPresenterImpl(this)

        return inflater!!.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val thisActivity = activity

        btn_login_sign_up.setOnClickListener {
            thisActivity as LoginActivity
            thisActivity.replaceFragment(SignUpFragment.newInstance(), true,
                    R.anim.enter_from_left, R.anim.exit_left,
                    R.anim.enter_from_right, R.anim.exit_right)
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        var mGoogleApiClient = GoogleApiClient.Builder(activity)
                //.enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build()

        btn_login_google.setOnClickListener { signInGoogle() }
    }

    fun signInGoogle() {
        val signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
        //startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
    .requestEmail()
    .build()*/
}