package com.example.rollthedice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRoll: Button = findViewById(R.id.btnRoll)
        btnRoll.setOnClickListener {
            rollAnimation()
        }
        rollDice()
    }

    private fun rollDice() {
        val randomInt: Int = getRandom(6)
        val txtResult: TextView = findViewById(R.id.txtResult)
        txtResult.text = randomInt.toString()

        val drawableResult = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val imgDice: ImageView = findViewById(R.id.imgDice)
        imgDice.setImageResource(drawableResult)
        //Toast.makeText(this, randomInt.toString(), Toast.LENGTH_SHORT).show()
    }

    private fun getRandom(max: Int): Int {
        return (1..max).random()
    }

    private fun rollAnimation(){
        object: CountDownTimer(3000,100){
            override fun onTick(millisUntilFinished: Long) {
                rollDice()
            }

            override fun onFinish() {
                //do something when the timer is finished
            }
        }.start()
    }
}