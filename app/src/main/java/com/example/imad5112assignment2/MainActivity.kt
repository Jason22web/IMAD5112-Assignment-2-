package com.example.imad5112assignment2


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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

        val questionText = findViewById<TextView>(R.id.txtQuestions)
        val hackButton = findViewById<Button>(R.id.btnTrue)
        val hoaxButton = findViewById<Button>(R.id.btnFalse)
        val feedbackText = findViewById<TextView>(R.id.feedbacktxt)
        val nextButton = findViewById<Button>(R.id.btnNext)

        questionText.text = questions[currentQuestions]
        feedbackText.text = ""
        var answered = false

        hackButton.setOnClickListener {
            if (!answered){
                checkAnswer(true,feedbackText)
                answered = true
            }
        }
        hoaxButton.setOnClickListener {
            if (!answered){
                checkAnswer(false, feedbackText)
                answered = true
            }
        }
        hackButton.setOnClickListener {
            if (!answered){
                checkAnswer(true, feedbackText)
                answered = true
            }
        }
        hoaxButton.setOnClickListener {
            if (!answered){
                checkAnswer(false, feedbackText)
            }
        }
        hackButton.setOnClickListener {
            if (!answered){
                checkAnswer(true, feedbackText)
            }
        }
        hoaxButton.setOnClickListener {
            if (!answered){
                checkAnswer(false, feedbackText)
            }
        }
        hackButton.setOnClickListener {
            if (!answered){
                checkAnswer(true, feedbackText)
            }
        }
        hoaxButton.setOnClickListener {
            if (!answered)
                checkAnswer(false, feedbackText)
        }

        hoaxButton.setOnClickListener {
            if (!answered) {
                checkAnswer(false, feedbackText)
                answered = true
            }
        }
        hackButton.setOnClickListener {
            if (!answered) {
                checkAnswer(true, feedbackText)
            }
        }

        nextButton.setOnClickListener {
            currentQuestions++
            if (currentQuestions < questions.size) {
                showQuizScreen()
            }else {
                showScoreScreen()
                }
            }
        }

    private fun checkAnswer(userAnswer: Boolean, feedbackText: TextView) {
        val correct = answers[currentQuestions]
        if (userAnswer == correct) {
            feedbackText.text = "Correct!"
            score++
            feedbackList.add ("Q${currentQuestions + 1}")
        }else {
            feedbackText.text = "Incorrect"
            feedbackList.add ("Q${currentQuestions + 1}")
        }
    }

    private  fun showScoreScreen() {
        setContentView(R.layout.score_layout)

        val scoreText = findViewById<TextView>(R.id.textOutput)
        val finalFeedback = findViewById<TextView>(R.id.finalfeedback)
        val exitButton = findViewById<Button>(R.id.exitbtn)
        val reviewButton = findViewById<Button>(R.id.btnScoreStart)

        scoreText.text = "You got $score out of ${questions.size}"
        finalFeedback.text = if (score >= 9) "Awesome you're a life hacker" else "You can get there just keep practicing!"

        reviewButton.setOnClickListener {
            val facts = questions.mapIndexed { index, q ->
                "${index + 1}. $q\nAnswer: ${answers[index]}"
            }.joinToString("\n\n")
            Toast.makeText(this, facts, Toast.LENGTH_LONG).show()
        }
        exitButton.setOnClickListener {
            finish()
        }
    }
}


