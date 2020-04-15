package com.hypergraph.entrepreneur

import android.os.Bundle
import android.util.Log
import com.hypergraph.entrepreneur.core.BaseActivity

/**
 * BaseActivity consists of auto executed functions on start.
 * These function shouldn't be called else where. (My own opinion)
 *
 * Other base classes can be created for convenience
 * Examples:
 * https://github.com/android10/Android-CleanArchitecture-Kotlin/tree/master/app/src/main/kotlin/com/fernandocejas/sample/core/platform
 * https://proandroiddev.com/mvi-on-android-with-livedata-coroutines-d2172bc7f775
 */


/**
 *  Animated box animation with RXJava
 *  https://github.com/xyzmes/HyperGram/blob/AnimatedBoxes/app/src/main/java/com/modernkod/instaroid/MainActivity.kt
 */

class MainActivity : BaseActivity() {

    // Keep constants in companion object
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate: ")

    }



}
