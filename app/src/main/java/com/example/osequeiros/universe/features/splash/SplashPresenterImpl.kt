package com.example.osequeiros.universe.features.splash

import android.util.DisplayMetrics
import android.view.animation.*
import android.widget.TextView
import java.util.*

/**
 * Created by osequeiros on 28/05/17.
 * Implementación del Splash presenter
 */
class SplashPresenterImpl (private var splashView: SplashView) : SplashPresenter {

    val TIME_DURATION_ANIMATION = 1600
    val TIME_DELAY_START_ANIMATION = 100
    val TIME_SPLASH = 2000

    var timer = Timer()

    /** Método para comenzar con delay la animación */
    override fun startAnimation() {
        val animateTask = object : TimerTask() {
            override fun run() = splashView.runOnMainThread()
        }
        timer = Timer()
        timer.schedule(animateTask, TIME_DELAY_START_ANIMATION.toLong())
    }

    /** Método para animar cada letra  */
    override fun animatedChars(chars: List<TextView>, dm: DisplayMetrics) {
        // Barra de estado :
        //int statusBar = dm.heightPixels - mFrameLayout.getMeasuredHeight();

        // Recuperamos el ancho del char :
        val width = chars[0].width

        // Contador :
        var cont = -4

        // Bucle para cada char
        for (v in chars) {

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
            splashView.showAnimation(v, animation)
        }
    }

    /** Método para lanzar la siguiente actividad */
    override fun launchNextView() {
        val task = object : TimerTask() {
            override fun run() = splashView.launchNextView("SignInActivity")
        }
        timer.schedule(task, TIME_SPLASH.toLong())
    }

    /** Pausar la animación */
    override fun pauseAnimation() {
        timer.cancel()
    }
}