package com.example.osequeiros.universe.features.auth

import android.app.Fragment
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.osequeiros.universe.R
import com.example.osequeiros.universe.features.auth.signin.SignInFragment

/**
 * Created by osequeiros on 25/04/17.
 * Actividad de Login
 */

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        //replaceFragment(SignInFragment.newInstance(), false, 0, 0, 0, 0)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
            //finish()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    /**
     * @param fragment Fragment a insertar
     * @param addToBackSack flag de stackeo
     * @param animIdInV1 animacion de entrada
     */
    fun replaceFragment(fragment: Fragment, addToBackSack: Boolean,
                        animIdInV1: Int = 0, animIdOutV1: Int = 0,
                        animIdInV2: Int = 0, animIdOutV2: Int = 0) {

        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.setCustomAnimations(animIdInV1, animIdOutV1, animIdInV2, animIdOutV2)
        transaction.replace(R.id.fragment_container_auth, fragment, "tag")

        if (addToBackSack) transaction.addToBackStack(null)
        transaction.commit()
    }

}
