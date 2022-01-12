package com.example.zafa2v11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register_telefono.*

class RegisterActivityTelefono : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_telefono)
        initUI()

    }

    private fun initUI() {
        imageButton.setOnClickListener { cambiarAQRPrueba() }
    }

    private fun cambiarAQRPrueba() {
        startActivity( Intent(this,QRActivity::class.java))
    }
}