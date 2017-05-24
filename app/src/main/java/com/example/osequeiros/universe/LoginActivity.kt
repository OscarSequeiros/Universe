package com.example.osequeiros.universe

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by osequeiros on 25/04/17.
 * Actividad de Login
 */

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initialize()
    }

    fun initialize() {
        text_login_title.typeface = Typeface.createFromAsset(assets,
                "fonts/Merriweather-Regular.ttf")
    }

}
