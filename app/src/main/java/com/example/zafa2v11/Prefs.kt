package com.example.zafa2v11

import android.content.Context

class Prefs(val context: Context) {

    private val SHARED_PASS= "pass"
    private val SHARED_NAME= "Mydtb"
    private val SHARED_USERNAME= "username"

    val storage = context.getSharedPreferences(SHARED_NAME,0)

    fun saveName(name:String){
        storage.edit().putString(SHARED_USERNAME, name).apply()
    }

    fun savePass(pass:String){
        storage.edit().putString(SHARED_PASS, pass).apply()

    }
    fun getName():String{
        return storage.getString(SHARED_USERNAME,"")!!
    }
    fun getPass():String{
        return storage.getString(SHARED_PASS,"")!!
    }
    fun wipe(){
        storage.edit().clear().apply()
    }
}