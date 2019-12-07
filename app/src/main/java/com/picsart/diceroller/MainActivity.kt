package com.picsart.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    private var resultRoll = 0

    fun findWinner() {
        if (resultPlayer1.text.toString().toInt() > resultPlayer2.text.toString().toInt()) {
            winnerView.setText("The winner is Player 1 !!!")
        } else {
            winnerView.setText("The winner is Player 2!!!")
        }
        if (resultPlayer1.text.toString().toInt() == resultPlayer2.text.toString().toInt()) {
            winnerView.setText("The winner are Players !!!")
        }
    }

    fun randomDice(): Int {
        val random = (1..6).random()
        when (random) {
            1 -> {
                resultRoll += random
                return R.drawable.dice1
            }
            2 -> {
                resultRoll += random
                return R.drawable.dice2
            }
            3 -> {
                resultRoll += random
                return R.drawable.dice3
            }
            4 -> {
                resultRoll += random
                return R.drawable.dice4
            }
            5 -> {
                resultRoll += random
                return R.drawable.dice5
            }
            6 -> {
                resultRoll += random
                return R.drawable.dice6
            }
            else -> return -1
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val winnerView = findViewById<TextView>(R.id.winnerView)
        winnerView.setText("The game is start")

        val player1_dice1 = findViewById<ImageView>(R.id.player1_dice1)
        val player1_dice2 = findViewById<ImageView>(R.id.player1_dice2)
        val resultPlayer1 = findViewById<TextView>(R.id.resultPlayer1)

        val player2_dice1 = findViewById<ImageView>(R.id.player2_dice1)
        val player2_dice2 = findViewById<ImageView>(R.id.player2_dice2)
        val resultPlayer2 = findViewById<TextView>(R.id.resultPlayer2)


        val player1Button = findViewById<Button>(R.id.player1Button)
        player1Button.setOnClickListener {

            player1_dice1.setImageResource(randomDice())
            player1_dice2.setImageResource(randomDice())
            resultPlayer1.setText(resultRoll.toString())
            findWinner()
            resultRoll = 0
        }


        val player2Button = findViewById<Button>(R.id.player2Button)
        player2Button.setOnClickListener {

            player2_dice1.setImageResource(randomDice())
            player2_dice2.setImageResource(randomDice())
            resultPlayer2.setText(resultRoll.toString())
            findWinner()
            resultRoll = 0
        }
    }


}
