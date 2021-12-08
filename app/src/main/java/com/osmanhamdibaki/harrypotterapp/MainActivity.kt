package com.osmanhamdibaki.harrypotterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonPlay: Button = findViewById(R.id.button_play)
        val buttonReset: Button = findViewById(R.id.button_reset)
        val teamImage: ImageView = findViewById(R.id.teamImage)
        val editTextTeamPrediction: EditText = findViewById(R.id.edit_text_team_prediction)

        buttonPlay.setOnClickListener {
            shuffleTeams()
        }

        buttonReset.setOnClickListener {
            editTextTeamPrediction.setText("")
            teamImage.setImageResource(R.drawable.hogwarts)
        }

    }

    private fun shuffleTeams() {

        val teamImage: ImageView = findViewById(R.id.teamImage)
        val editTextTeamPrediction: EditText = findViewById(R.id.edit_text_team_prediction)

        val random = Random(4)
        val randomNumber = random.randomNumber()

        val drawableResource: Int
        val teamName: String

        when (randomNumber) {
            1 -> {
                drawableResource = R.drawable.gryffindor
                teamName = "gryffindor"
            }
            2 -> {
                drawableResource = R.drawable.slytherin
                teamName = "slytherin"
            }
            3 -> {
                drawableResource = R.drawable.hufflepuff
                teamName = "hufflepuff"
            }
            else -> {
                drawableResource = R.drawable.ravenclaw
                teamName = "ravenclaw"
            }
        }

        teamImage.setImageResource(drawableResource)

        if (editTextTeamPrediction.text.toString() == teamName) {
            Toast.makeText(this, "Congratulations!", Toast.LENGTH_SHORT).show()
        }   else {
            Toast.makeText(this, "Try Again!", Toast.LENGTH_SHORT).show()
        }

    }

}

class Random(private val teamCount: Int) {

    fun randomNumber(): Int {
        return (1..teamCount).random()
    }

}