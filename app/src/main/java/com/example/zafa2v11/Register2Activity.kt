package com.example.zafa2v11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register_telefono.*

//EMAIL
class Register2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)
        initUI()
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