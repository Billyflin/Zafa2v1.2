package com.example.zafa2v11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.view.View
import kotlinx.android.synthetic.main.activity_phone_confimation.*

class PhoneConfimationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_confimation)
        button6.setOnClickListener { avant() }
        initUI()
    }

    private fun initUI() {
        if(etCodeConfimation.text.length==6){
        }
        printDifferenceDateForHours()
    }
    private fun avant(){
            var code =etCodeConfimation.text.toString()
            if (compare(code)){
                startActivity( Intent(this,QRActivity::class.java))
            }

    }
    private fun compare(code: String): Boolean {
        if (code == "123456") {
            return true
        }
        return false
    }


    private fun printDifferenceDateForHours() {
        val timer = object: CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                txt_timeleft.text = "segundos restantes: " + millisUntilFinished / 1000
            }

            override fun onFinish() {
                txt_timeleft.text = "Aún no recives el código?\n prueba pedir un nuevo código!"
                button5.visibility=View.VISIBLE
            }
        }
        timer.start()
    }
}

//        val currentTime = Calendar.getInstance().time
//        val endDateDay = "03/02/2022 21:00:00"
//        val format1 = SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.getDefault())
//        val endDate = format1.parse(endDateDay)
//
//        //milliseconds
//        var different = endDate.time - currentTime.time
//        countDownTimer = object : CountDownTimer(different, 1000) {
//
//            override fun onTick(millisUntilFinished: Long) {
//                var diff = millisUntilFinished
//                val secondsInMilli: Long = 1000
//                val minutesInMilli = secondsInMilli * 60
//                val hoursInMilli = minutesInMilli * 60
//                val daysInMilli = hoursInMilli * 24
//
//                val elapsedDays = diff / daysInMilli
//                diff %= daysInMilli
//
//                val elapsedHours = diff / hoursInMilli
//                diff %= hoursInMilli
//
//                val elapsedMinutes = diff / minutesInMilli
//                diff %= minutesInMilli
//
//                val elapsedSeconds = diff / secondsInMilli
//
//                txt_timeleft.text = "$elapsedMinutes min $elapsedSeconds sec"
//            }
//
//            override fun onFinish() {
//                txt_timeleft.text = "done!"
//            }
//        }.start()
