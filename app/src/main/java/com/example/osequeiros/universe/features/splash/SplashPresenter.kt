package com.example.osequeiros.universe.features.splash

import android.graphics.Typeface
import android.util.DisplayMetrics
import android.widget.TextView

/**
 * Created by osequeiros on 28/05/17.
 * Interface del Splash presenter
 */
interface SplashPresenter {

    fun animatedChars(chars: List<TextView>, dm: DisplayMetrics, type: Typeface)

    fun launchNextView()

    fun startAnimation()

    fun pauseAnimation()
}