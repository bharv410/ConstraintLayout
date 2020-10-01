package com.google.googleio

import android.content.Intent
import android.os.Bundle
import android.support.constraint.helper.Flow
import android.support.constraint.helper.Layer
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        findViewById<Flow>(R.id.flow3).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, LayerActivity::class.java))

        })


//        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
    }
}