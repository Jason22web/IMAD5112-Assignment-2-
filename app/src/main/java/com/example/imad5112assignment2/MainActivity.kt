package com.example.imad5112assignment2


import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.imad5112assignment2.ui.theme.IMAD5112ASSIGNMENT2Theme

class MainActivity : ComponentActivity() {

    private val questions = arrayOf(
        "Putting a small glass of water in the microwave with your pizza prevents the crust from getting chewy.",
        "Entering your ATM PIN in reverse will silently alert the police and lock the machine during a robbery.",
        "You can tell if an alkaline battery is full or empty by dropping it; empty batteries bounce higher.",
        "Burying a wet smartphone in a bowl of dry white rice is the best way to extract internal moisture.",
        "You can remove permanent marker from a whiteboard by drawing over it with a dry-erase marker.",
        "Using Premium 91-octane gas in a car designed for Regular 87-octane will increase horsepower.",
        "Rubbing a walnut on a scratch in wooden furniture can hide the scratch.",
        "Holding the Close Door button and your floor number simultaneously in an elevator acts as a priority code.",
        "Turning your toaster on its side to make a grilled cheese sandwich is a safe and effective hack.",
        "Placing a wooden spoon across the top of a boiling pot of water prevents it from boiling over."
    )

    private val answers = arrayOf(true, false, true, false, true, false, true, false, false, true)
    private var currentQuestions = 0
    private var score = 0
    private val feedbackList= mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showWelcomeScreen()
    }

    private fun showWelcomeScreen() {
        setContentView(R.layout.activity_welcome)
        val startButton = findViewById<Button>(R.id.startButton)
        startButton.setOnClickListener {
            currentQuestions = 0
            score = 0
            feedbackList.clear()
            showQuizScreen()
        }
    }

    private fun showQuizScreen() {

        val questionText = findViewById<Text>(R.id.txtQuestions)
        }
    }
}
