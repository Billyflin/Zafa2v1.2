package com.example.zafa2v11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    companion object{
        lateinit var prefs: Prefs
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs=Prefs(applicationContext)
        startActivity(Intent(this, MainActivity::class.java))
        finish();
    }


}