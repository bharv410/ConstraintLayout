package com.google.googleio

import android.R.attr.pivotX
import android.R.attr.pivotY
import android.os.Bundle
import android.support.constraint.helper.Layer
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.*


class LayerActivity : AppCompatActivity() {

    lateinit var layer: Layer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layer)


        layer = findViewById<Layer>(R.id.layer)

        layer.setOnClickListener(View.OnClickListener {
//            rotateView(findViewById(R.id.button10))
            funAnimation(layer)




//            circularRevealCard(findViewById(R.id.button10))
        })
    }

    private fun circularRevealCard(view: View) {
        val finalRadius = Math.max(view.width, view.height).toFloat()

        // create the animator for this view (the start radius is zero)
        val circularReveal = ViewAnimationUtils.createCircularReveal(view, 0, 0, 0f, finalRadius * 1.1f)
        circularReveal.duration = 300

        // make the view visible and start the animation
        view.visibility = View.VISIBLE
        circularReveal.start()
    }

    private fun rotateView(view: View){
        // Create an animation instance
        // Create an animation instance
        val an: Animation = RotateAnimation(0.0f, 360.0f, pivotX.toFloat(), pivotY.toFloat())

        // Set the animation's parameters

        // Set the animation's parameters
        an.duration = 10000 // duration in ms

        an.repeatCount = 0 // -1 = infinite repeated

        an.repeatMode = Animation.REVERSE // reverses each repeat

        an.fillAfter = true // keep rotation after animation


        // Aply animation to image view

        // Aply animation to image view
        view.setAnimation(an)

        an.start()

    }

    private fun funAnimation(view: View){

        val growTo = 1.2f
        val duration = 1200

        val grow = ScaleAnimation(1f, growTo, 1f, growTo,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f)
        grow.duration = (duration / 2).toLong()
        val shrink = ScaleAnimation(growTo, 1f, growTo, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f)
        shrink.duration = (duration / 2).toLong()
        shrink.startOffset = (duration / 2).toLong()
        val growAndShrink = AnimationSet(true)
        growAndShrink.interpolator = LinearInterpolator()
        growAndShrink.addAnimation(grow)
        growAndShrink.addAnimation(shrink)
        view.startAnimation(growAndShrink)
    }
}