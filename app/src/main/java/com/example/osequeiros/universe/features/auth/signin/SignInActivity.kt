package com.example.osequeiros.universe.features.auth.signin

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.example.osequeiros.universe.R
import com.example.osequeiros.universe.features.auth.signup.SignUpActivity
import com.example.osequeiros.universe.util.Patterns
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.activity_sign_in.*

/**
 * Created by osequeiros on 10/06/17.
 * Sign In Activity
 */

class SignInActivity : AppCompatActivity(), SignInView {

    lateinit var presenter: SignInPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        presenter = SignInPresenterImpl(this)

        setUpReactions()
        setUpActions()
    }

    override fun onRestart() {
        super.onRestart()
        //setUpActions()
    }

    fun setUpReactions() {
        /** Validación del email: */
        val userObservable: Observable<Boolean> = RxTextView.textChanges(edit_login_user)
                .map { t -> Patterns.emailPattern.matcher(t).matches() }
        //userObservable.distinctUntilChanged()
                //.doOnNext{ b -> Log.d("[Rx]", "Email " + ( if(b) "Valid" else "Invalid")) }
                ///.map { b -> if (b) Color.BLACK else Color.RED }
                //.subscribe { color -> edit_login_user.setTextColor(color!!) }

        /** Validación de password */
        val passObservable: Observable<Boolean> = RxTextView.textChanges(edit_login_password)
                .map { t -> t.length > 5 }
        //passObservable.distinctUntilChanged()
                //.doOnNext{ b -> Log.d("[Rx]", "Pass " + ( if(b) "Valid" else "Invalid")) }
                //.map { b -> if (b) Color.BLACK else Color.RED }
                //.subscribe { color -> edit_login_password.setTextColor(color!!) }

        /** Observer para el botón de login con email */
        val signInEnabled: Observable<Boolean> = Observable.combineLatest(
                userObservable, passObservable, BiFunction { u, p -> u && p })
        signInEnabled.distinctUntilChanged()
                .subscribe { enabled -> btn_login_mail.isEnabled = enabled }

        signInEnabled.distinctUntilChanged()
                .map { b -> if (b) R.color.colorMail else R.color.colorDisabled }
                .subscribe { color -> btn_login_mail.backgroundTintList = ContextCompat
                        .getColorStateList(this, color) }
    }

    fun setUpActions() {
        btn_login_facebook.setOnClickListener {
            // Do login with facebook
        }

        btn_login_google.setOnClickListener { }

        btn_login_twitter.setOnClickListener { }

        /** Lanzar la actividad de SignUp */
        btn_login_sign_up.setOnClickListener {
            val intent = Intent().setClass(this, SignUpActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.enter_from_left, R.anim.exit_left)
        }
    }
}