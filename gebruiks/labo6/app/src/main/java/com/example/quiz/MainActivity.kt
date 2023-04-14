package com.example.quiz

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.*
import com.example.quiz.model.Question
import com.example.quiz.model.QuizMaster
import com.example.quiz.ui.theme.QuizTheme

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
    Column {
        QuestionScreen()
        AnswerScreen()
    }
}

@Composable
fun QuestionScreen() {
    Text(text = current.currentQuestion.question, fontSize = 16.sp)
}

@Composable
fun AnswerScreen() {
    Row {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "V")
        }
    }
}

