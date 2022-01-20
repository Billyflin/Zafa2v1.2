package com.example.zafa2v11

import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import kotlinx.android.synthetic.main.activity_qractivity.*
import java.util.*

import android.graphics.BitmapFactory
import androidx.core.graphics.drawable.toBitmap


class QRActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qractivity)
        initIU()

    }

    private fun initIU() {
        button3.setOnClickListener {
            imageView4.setImageDrawable(getDrawable(R.drawable.glich))
            val BitLogo = imageView4.drawable.toBitmap()
            val bitLogo = BitmapFactory.decodeResource(resources,R.drawable.fondo_negro);
            imageView7.setImageBitmap(
//                createQRGradientImage(
//                    "Hola",
//                    350.dpToPx(),
//                    350.dpToPx()
//                )?.let { it1 ->
//                    mergeBitmaps(BitLogo,
//                        it1
//                    )
//                }
            bitLogo
            )
        }
    }

}