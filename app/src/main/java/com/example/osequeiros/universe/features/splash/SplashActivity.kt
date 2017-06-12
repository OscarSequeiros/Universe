package com.example.osequeiros.universe.features.splash

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.view.View
import android.view.animation.AnimationSet
import android.widget.TextView
import com.example.osequeiros.universe.R
import com.example.osequeiros.universe.features.auth.signin.SIgnActivityJava
import com.example.osequeiros.universe.features.auth.signin.SignInActivity
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*

class SplashActivity : AppCompatActivity(), SplashView {

    companion object {
        lateinit var presenter : SplashPresenterImpl
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter = SplashPresenterImpl(this)
    }

    public override fun onPause() {
        super.onPause()
        presenter.pauseAnimation()
    }

    public override fun onResume() {
        super.onResume()
        presenter.startAnimation()
        presenter.launchNextView()
    }

    /** Sobrescribimos el método para evitar la interrupción  */
    override fun onBackPressed() {
        //super.onBackPressed();
    }

    /** Ejecución en el hilo principal */
    override fun runOnMainThread() {
        runOnUiThread { animated() }
    }

    /** Método para animar las letras y cambiar fuente */
    private fun animated() {
        // Recuperamos el tipo de fuente :
        val type = Typeface.createFromAsset(assets, "fonts/Merriweather-Regular.ttf")
        val chars = Arrays
                .asList<TextView>(text_u, text_n, text_i, text_v, text_e1, text_r, text_s, text_e2)
        for (v in chars) {
            v.typeface = type
        }

        // Obtenemos las métricas de la pantalla :
        val dm = DisplayMetrics()
        this.windowManager.defaultDisplay.getMetrics(dm)

        presenter.animatedChars(chars, dm)
    }

    /** Método para mostrar la animación de letras */
    override fun showAnimation(view: View, animation: AnimationSet) {
        view.startAnimation(animation)
    }

    /** Método para lanzar la siguiente actividad */
    override fun launchNextView(tag: String) {
        var intent: Intent? = null
        if (tag == "SignInActivity") {
            intent = Intent().setClass(this@SplashActivity, SignInActivity::class.java)
            //intent = Intent().setClass(this@SplashActivity, SIgnActivityJava::class.java)
        }
        startActivity(intent)
        finish()
    }
}
