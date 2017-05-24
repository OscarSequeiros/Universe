package com.example.osequeiros.universe

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.view.animation.*
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*

class SplashActivity : AppCompatActivity() {

    var timer = Timer()

    companion object {
        private val TIME_DURATION_ANIMATION = 1600
        private val TIME_SPLASH = 2000
        private val TIME_DELAY_START_ANIMATION = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    public override fun onPause() {
        super.onPause()
        timer.cancel()
    }

    public override fun onResume() {
        super.onResume()

        // Tarea para la animación después de un delay de 0.2 segundos :
        val animateTask = object : TimerTask() {
            override fun run() {
                runOnUiThread { animated() }
            }
        }

        timer = Timer()
        timer.schedule(animateTask, TIME_DELAY_START_ANIMATION.toLong())

        // Tarea para lanzar la siguiente actividad :
        val task = object : TimerTask() {
            override fun run() {
                val intent = Intent().setClass(this@SplashActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        // Mostramos el Splash
        timer = Timer()
        timer.schedule(task, TIME_SPLASH.toLong())
    }

    /** Método para animar las letras  */
    private fun animated() {
        val chars = Arrays
                .asList<TextView>(text_u, text_n, text_i, text_v, text_e1, text_r, text_s, text_e2)
        animatedEveryChar(chars)
    }

    /** Método para animar cada letra  */
    private fun animatedEveryChar(chars: List<TextView>) {

        // Se recuperan las métricas de la pantalla :
        val dm = DisplayMetrics()
        this.windowManager.defaultDisplay.getMetrics(dm)

        // Barra de estado :
        //int statusBar = dm.heightPixels - mFrameLayout.getMeasuredHeight();

        // Recuperamos el ancho del char :
        val width = chars[0].width

        val type = Typeface.createFromAsset(assets, "fonts/Merriweather-Regular.ttf")

        // Contador :
        var cont = -4

        // Bucle para cada char
        for (v in chars) {
            // Cambiamos el tipo de letra :
            v.typeface = type

            // Recuperamos la posición actual de la vista :
            val originalPos = IntArray(2)
            v.getLocationOnScreen(originalPos)

            // Establecemos la posición de la nueva vista :
            var xDest = dm.widthPixels / 2 - v.measuredWidth / 2 + 2.0f *
                    width.toFloat() * cont.toFloat()
            if (cont < 0) {
                // Vistas a la derecha :
                xDest += width.toFloat()
            } else {
                // Vistas a la izquierda :
                xDest -= width.toFloat()
            }
            val yDest = dm.heightPixels / 2 - v.measuredHeight / 2 //- statusBar;

            cont++
            // Como la cantidad de chars es par, no valoramos al contador cuando sea cero :
            if (cont == 0) cont++

            val animation = AnimationSet(true)

            // Movimiento de rotación :
            val rotate = RotateAnimation(0f, (3 * 360).toFloat(),
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
            rotate.duration = TIME_DURATION_ANIMATION.toLong()
            animation.addAnimation(rotate)

            // Movimiento de traslación :
            val transl = TranslateAnimation(
                    0f, xDest - originalPos[0], 0f, (yDest - originalPos[1]).toFloat())
            transl.interpolator = DecelerateInterpolator()
            transl.duration = TIME_DURATION_ANIMATION.toLong()
            animation.addAnimation(transl)

            // Mantenemos en el estado que obtienen después de la animación
            animation.fillAfter = true

            // Asignamos la animación a la vista :
            v.startAnimation(animation)
        }
    }

    /** Sobrescribimos el método para evitar la interrupción  */
    override fun onBackPressed() {
        //super.onBackPressed();
    }
}
