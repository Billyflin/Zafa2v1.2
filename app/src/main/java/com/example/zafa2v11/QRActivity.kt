package com.example.zafa2v11

import android.content.res.Resources
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import com.example.zafa2v11.qr.qrGen
import kotlinx.android.synthetic.main.activity_qractivity.*
import java.util.*


class QRActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qractivity)
        initIU()

    }

    private fun initIU() {
            imageView7.setImageDrawable(getDrawable(R.drawable.glich))
            val uwu =qrGen()
            imageView4.setImageBitmap(
//                createQRGradientImage(
//                    "Hola",
//                    350.dpToPx(),
//                    350.dpToPx()
//                )?.let { it1 ->
//                    mergeBitmaps(BitLogo,
//                        it1
//                    )
//                }
                    uwu.createQRGradientImage("Hola",350.dpToPx(),
                    350.dpToPx())
            )

    }
    fun Int.dpToPx(): Int {
        return (this * Resources.getSystem().displayMetrics.density).toInt()
    }

}