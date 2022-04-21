package com.example.my_dice_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            roll()
        }
    }

    private fun roll() {
        val diceOne = Dice(6)
        val rollDiceResult1 = diceOne.rollDice()
        val rollDiceResult2 = diceOne.rollDice()
        val rollDiceResult3 = diceOne.rollDice()


        val diceImage1: ImageView = findViewById(R.id.dice1)
        val diceImage2: ImageView = findViewById(R.id.dice2)
        val diceImage3: ImageView = findViewById(R.id.dice3)
        val toast1 = Toast.makeText(this,"YOU WIN",Toast.LENGTH_SHORT)
        val toast2 = Toast.makeText(this,"YOU LOSE",Toast.LENGTH_SHORT)


        fun diceImageResource(diceSides: Int):Int {
           return when (diceSides){

            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6


        }}
        diceImage1.setImageResource(diceImageResource(rollDiceResult1))
        diceImage2.setImageResource(diceImageResource(rollDiceResult2))
        diceImage3.setImageResource(diceImageResource(rollDiceResult3))


        if(rollDiceResult1 == 6 && rollDiceResult2==6 || rollDiceResult1 == 6 && rollDiceResult3 == 6){
            toast1.show()
        }
        else if (rollDiceResult2 == 6 && rollDiceResult1 == 6 || rollDiceResult2 == 6 && rollDiceResult3 == 6){
            toast1.show()
        }
        else if (rollDiceResult3 == 6 && rollDiceResult1 == 6 ||  rollDiceResult3 == 6 && rollDiceResult2 == 6){
            toast1.show()
        }



        if(rollDiceResult1 + rollDiceResult2 == 9 || rollDiceResult2  + rollDiceResult3 == 9 ){
            toast2.show()
        }
        else if (rollDiceResult2 + rollDiceResult1 == 9  ||  rollDiceResult2 + rollDiceResult3 == 9){
            toast2.show()
        }
        else if (rollDiceResult3 + rollDiceResult1 == 9  ||  rollDiceResult3 + rollDiceResult2 == 9){
            toast2.show()
        }
    }

class Dice(var sides: Int) {
    fun rollDice(): Int {
        return (1..sides).random()
    }
}}















