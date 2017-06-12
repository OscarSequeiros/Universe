package com.example.osequeiros.universe.features.auth.signup

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.osequeiros.universe.R
import kotlinx.android.synthetic.main.activity_sign_up.*

/**
 * Created by osequeiros on 10/06/17.
 * Actividad Sign Up
 */

class SignUpActivity : AppCompatActivity(), SignUpView {

    lateinit var presenter: SignUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        presenter = SignUpPresenterImpl(this)

        setUpActions()
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_right)
    }

    fun setUpActions() {

        /** Lanzar la actividad Sing In */
        btn_signup_go_singin.setOnClickListener {
            /*val intent = Intent().setClass(this, SignInActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.enter_from_right, R.anim.exit_right)
            finish()*/
            super.onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
