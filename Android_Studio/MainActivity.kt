package com.example.a8ball

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a8ball.ui.theme._8ballTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _8ballTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Magic8BallScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Magic8BallScreen(modifier: Modifier = Modifier) {
    var answer by remember { mutableStateOf("Shake to reveal your answer!") }

    val answers = listOf(
        "Yes",
        "No",
        "Maybe",
        "Ask again later",
        "Definitely",
        "I don't think so",
        "Absolutely",
        "Very doubtful",
        "Without a doubt",
        "Signs point to yes"
    )

    Surface(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BasicText(
                text = answer,
                style = androidx.compose.material3.MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Button(onClick = {
                answer = answers[Random.nextInt(answers.size)]
            }) {
                Text("Shake")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Magic8BallScreenPreview() {
    _8ballTheme {
        Magic8BallScreen()
    }
}
