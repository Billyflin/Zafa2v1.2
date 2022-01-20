package com.example.zafa2v11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        val ttb2 = AnimationUtils.loadAnimation(this, R.anim.ttb2);

        val imageView2 = findViewById(R.id.imageView2) as ImageView
       // val button2 = findViewById(R.id.button) as Button
        imageView2.startAnimation(ttb2)

    }
    private fun initUI(){
        button2.setOnClickListener{registerView()}
        button.setOnClickListener { funciona() }
    }

    private fun funciona() {
        startActivity( Intent(this,EventSelectorActivity::class.java))
    }

    private fun registerView() {
        startActivity( Intent(this,RegisterActivity::class.java))
    }
}