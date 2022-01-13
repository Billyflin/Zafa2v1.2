package com.example.zafa2v11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }
    private fun initUI(){
        btnRegister.setOnClickListener{registerView()}
        btnLogin.setOnClickListener { funciona() }
    }

    private fun funciona() {
        startActivity( Intent(this,QRActivity::class.java))
    }

    private fun registerView() {
        startActivity( Intent(this,RegisterActivityTelefono::class.java))
    }
}