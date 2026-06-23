package com.example.randomquoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RandomQuoteApp()
        }
    }
}

data class Quote(
    val text: String,
    val author: String
)

@Composable
fun RandomQuoteApp() {

    val quotes = listOf(
        Quote("Believe in yourself.", "Unknown"),
        Quote("Success is not final.", "Winston Churchill"),
        Quote("Stay hungry, stay foolish.", "Steve Jobs"),
        Quote("Dream big and dare to fail.", "Norman Vaughan"),
        Quote("Never give up.", "Unknown")
    )

    var currentQuote by remember {
        mutableStateOf(quotes.random())
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Random Quote Generator",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "\"${currentQuote.text}\"",
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "- ${currentQuote.author}",
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    currentQuote =
                        quotes[Random.nextInt(quotes.size)]
                }
            ) {
                Text("New Quote")
            }
        }
    }
}