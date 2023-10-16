package com.example.quiz

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.quiz.model.QuizMaster

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizScreen()
        }
    }
}

var current : QuizMaster = QuizMaster

@Preview( uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode" )
@Composable
fun QuizPreview() {
    QuizScreen()
}

@Composable
fun QuizScreen() {
    Column(verticalArrangement = Arrangement.SpaceEvenly) {
        QuestionScreen()
        AnswerScreen()
    }
}

@Composable
fun QuestionScreen() {
    Text(text = current.currentQuestion.question, fontSize = 24.sp)
}

@Composable
fun AnswerScreen() {
    var answer = ""
    Row() {
        TextField(value = "", onValueChange = {})
        Button(onClick = {
            if (answer == current.currentQuestion.answer) {current.nextQuestion()}
        }, content = { Text(text = "V") })
    }
}

