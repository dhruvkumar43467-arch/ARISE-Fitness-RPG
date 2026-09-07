package com.arise.fitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AriseFitnessApp()
        }
    }
}

@Composable
fun AriseFitnessApp() {

    var started by remember { mutableStateOf(false) }

    if (started) {
        HomeScreen()
    } else {
        StartScreen(
            onStart = {
                started = true
            }
        )
    }
}

@Composable
fun StartScreen(onStart: () -> Unit) {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "ARISE",
                style = MaterialTheme.typography.displayLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "FITNESS RPG",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = onStart
            ) {
                Text("START")
            }
        }
    }
}

@Composable
fun HomeScreen() {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "PLAYER DASHBOARD",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Level 1")

            Spacer(modifier = Modifier.height(8.dp))

            Text("XP: 0 / 100")

            Spacer(modifier = Modifier.height(24.dp))

            Text("Welcome to ARISE.")
        }
    }
}
