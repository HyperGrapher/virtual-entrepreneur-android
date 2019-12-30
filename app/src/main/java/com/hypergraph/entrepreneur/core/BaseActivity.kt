package com.hypergraph.entrepreneur.core

import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.hypergraph.entrepreneur.R

abstract class BaseActivity : AppCompatActivity() {

    /**
     * BaseActivity consists of auto executed functions on start.
     * These function shouldn't be called else where. (My own opinion)
     *
     * Other base classes can be created for convenience
     * Examples:
     * https://github.com/android10/Android-CleanArchitecture-Kotlin/tree/master/app/src/main/kotlin/com/fernandocejas/sample/core/platform
     */

    // Keep constants in companion object
    companion object {
        const val TAG = "BaseActivity"
        const val SPLASH_SCREEN_DELAY: Long = 1750
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        // Hide system bar
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // TODO: make required network calls while splash screen showing
        //      populate lists and all non-UI stuff via coroutines


        // Delay for splash screen
        // TODO burasini Coroutine ile cancelable yap. onStop or onPause da Coroutine'i iptal et
        //  Bu haliyle splash screen de iken back button basilirsa Crash oluyor
        //  https://stackoverflow.com/a/58022818/2122577
        Handler().apply {
            postDelayed({ setupUi() },
                SPLASH_SCREEN_DELAY
            )
        }


    }

    private fun setupUi() {

        // This will load activity UI and Splash logo will disappear
        // Splash logo is integrated into application window
        // So when UI is loaded main activity's BG color will
        // paint over the application window / splash logo

        setContentView(R.layout.activity_main)


    }


}
