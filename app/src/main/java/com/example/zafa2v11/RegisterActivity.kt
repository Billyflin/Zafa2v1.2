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

//TELEFONO
class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_telefono)
        initUI()

        val stb = AnimationUtils.loadAnimation(this, R.anim.stb);
        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);
        val ttb2 = AnimationUtils.loadAnimation(this, R.anim.ttb2)
        val ttb3 = AnimationUtils.loadAnimation(this, R.anim.ttb3)

        val imageButton3 = findViewById(R.id.imageButton3) as ImageButton
        val imageView6 = findViewById(R.id.imageView6) as ImageView
        val textView = findViewById(R.id.textView) as TextView
        val labelUser2 = findViewById(R.id.labelUser2) as TextInputEditText


        imageButton3.startAnimation(ttb3)
        imageView6.startAnimation(stb)
        textView.startAnimation(ttb)
        labelUser2.startAnimation(stb)

    }

    private fun initUI() {
        buttonConditional()
    }

    private fun buttonConditional() {
//        if (labelUser.text.isNotEmpty()){
        imageButton3.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    PhoneConfimationActivity::class.java
                )
            )
        }

//        }
    }
}