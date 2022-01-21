package com.example.zafa2v11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_register_telefono.*

//EMAIL
class Register2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)
        initUI()
        val stb = AnimationUtils.loadAnimation(this, R.anim.stb);
        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);
        val alpha = AnimationUtils.loadAnimation(this, R.anim.alpha)

        val imageButton3 = findViewById<ImageButton>(R.id.imageButton3)
        val textView = findViewById<TextView>(R.id.textView)
        val labelUser = findViewById<TextInputEditText>(R.id.labelUser)

        imageButton3.startAnimation(alpha)
        textView.startAnimation(ttb)
        labelUser.startAnimation(stb)


    }

    private fun initUI() {
        buttonConditional()
    }
    private fun buttonConditional(){
//        if (labelUser.text.isNotEmpty()){
        imageButton3.setOnClickListener { startActivity( Intent(this,QRActivity::class.java))  }

//        }
    }
}