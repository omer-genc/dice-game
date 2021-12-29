package com.example.deneme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val butonBaglantisi = findViewById<Button>(R.id.button)
        val resimBaglantisi = findViewById<ImageView>(R.id.zarView)
        val puan1Baglantisi = findViewById<TextView>(R.id.puan1TV)
        val puan2Baglantisi = findViewById<TextView>(R.id.puan2TV)
        val resetBaglantisi = findViewById<Button>(R.id.resetBtn)

        var zar = 0
        var puan1 = 0
        var puan2 = 0
        var tur = 1

        butonBaglantisi.setOnClickListener {
            zar = Random.nextInt(1,6)
            if(tur % 2 == 1 ) {
                puan1 += zar
                puanGoster(puan1,puan1Baglantisi)
            }
            else {
                puan2 += zar
                puanGoster(puan2,puan2Baglantisi)
            }

            zarDegis(zar,resimBaglantisi)
            tur += 1
        }

        resetBaglantisi.setOnClickListener {
            puan1 = 0
            puan2 = 0
            tur = 1
            puanGoster(0,puan1Baglantisi)
            puanGoster(0,puan2Baglantisi)
        }
    }

    fun zarDegis(zarSayisi: Int,resimBaglantisi: ImageView){
        when(zarSayisi){
            1 -> resimBaglantisi.setImageResource(R.drawable.dice_1)
            2 -> resimBaglantisi.setImageResource(R.drawable.dice_2)
            3 -> resimBaglantisi.setImageResource(R.drawable.dice_3)
            4 -> resimBaglantisi.setImageResource(R.drawable.dice_4)
            5 -> resimBaglantisi.setImageResource(R.drawable.dice_5)
            6 -> resimBaglantisi.setImageResource(R.drawable.dice_6)
        }
    }

    fun puanGoster(puan: Int,puanBaglantisi: TextView){
        puanBaglantisi.text = "puan = " + puan.toString()
    }

}