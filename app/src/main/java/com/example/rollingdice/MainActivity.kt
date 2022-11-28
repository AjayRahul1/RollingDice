package com.example.rollingdice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollDiceButton = findViewById<Button>(R.id.rollDiceButton)
        rollDiceButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val luckyNumWon: TextView = findViewById(R.id.luckyNumWon)
        if (diceRoll == 1) {
            Snackbar.make(
                findViewById(R.id.main_activity_roll_dice),
                "It's Lucky Number $diceRoll time",
                Snackbar.LENGTH_SHORT
            ).show()
            luckyNumWon.text = getString(R.string.it_is_your_lucky_num)
        } else {
            luckyNumWon.text = getString(R.string.not_your_lucky_num)
        }
        // Update the screen with the dice roll
        val diceImage: ImageView = findViewById(R.id.rollDiceImage)
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}