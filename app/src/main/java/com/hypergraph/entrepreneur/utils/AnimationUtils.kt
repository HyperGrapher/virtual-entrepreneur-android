package com.hypergraph.entrepreneur.utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.Color
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.ViewCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.reactivex.Completable
import io.reactivex.subjects.CompletableSubject


fun FloatingActionButton.animateIt(time: Long) {
    val imageAlphaHolder1 = PropertyValuesHolder.ofInt("imageAlpha", 65)
    val customSizeHolder1 = PropertyValuesHolder.ofInt("customSize", 210)
    val objectAnimator1 =
        ObjectAnimator.ofPropertyValuesHolder(this, imageAlphaHolder1, customSizeHolder1)
    objectAnimator1.duration = time
    objectAnimator1.doOnEnd {

        val imageAlphaHolder2 = PropertyValuesHolder.ofInt("imageAlpha", 1000)
        val customSizeHolder2 = PropertyValuesHolder.ofInt("customSize", 223)
        val objectAnimator2 =
            ObjectAnimator.ofPropertyValuesHolder(this, imageAlphaHolder2, customSizeHolder2)
        objectAnimator2.duration = time
        objectAnimator2.start()

    }

    objectAnimator1.start()
}

// RxJava
fun View.fadeIn(duration: Long, yTranslation: Float): Completable {
    val animationSubject = CompletableSubject.create()
    return animationSubject.doOnSubscribe {
        ViewCompat.animate(this)
            .setDuration(duration)
            .alpha(1f)
            .translationY(yTranslation)
            .setInterpolator(DecelerateInterpolator())
            .withEndAction {
                animationSubject.onComplete()
            }
    }
}

fun View.flipIt() {

    val oa1 = ObjectAnimator.ofFloat(this, "scaleX", 1f, 0f)
    val oa2 = ObjectAnimator.ofFloat(this, "scaleX", 0f, 1f)
    oa1.interpolator = DecelerateInterpolator()
    oa2.interpolator = AccelerateDecelerateInterpolator()
    oa1.duration = 75
    oa2.duration = 75

    oa1.addListener(object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator) {
            super.onAnimationEnd(animation)
            this@flipIt.setBackgroundColor(Color.parseColor("#de395d"))
            oa2.start()
        }
    })
    oa1.start()

}


/**
 *  Hide or show animation for curvedBottomNav by animating translationY
 *  Animation accelerates or decelerates according to the state of nav bar
 */

fun View.moveIt(value: Float, hidden: Boolean) {

    val animator = ObjectAnimator.ofFloat(this, "translationY", value)
    animator.interpolator =
        if (hidden) DecelerateInterpolator() else AccelerateDecelerateInterpolator()
    animator.duration = 550

    animator.addListener(object : AnimatorListenerAdapter() {
    })
    animator.start()

}



