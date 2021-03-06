package com.example.osequeiros.universe.features.splash

import android.view.View
import android.view.animation.AnimationSet

/**
 * Created by osequeiros on 28/05/17.
 * Vista del Splash
 */
interface SplashView {

    fun showAnimation(view: View, animation: AnimationSet)

    fun runOnMainThread()

    fun launchNextView(tag: String)
}