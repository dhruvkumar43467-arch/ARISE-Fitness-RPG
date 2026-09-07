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
            onStart = { started = true }
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

            Button(onClick = onStart) {
                Text("START")
            }
        }
    }
}

@Composable
fun HomeScreen() {

    var xp by remember { mutableStateOf(0) }

    val level = (xp / 100) + 1
    val currentXp = xp % 100

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "PLAYER DASHBOARD",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "LEVEL $level",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("XP: $currentXp / 100")

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "DAILY QUEST",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text("Complete 20 Push-Ups")

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    xp += 20
                }
            ) {
                Text("COMPLETE QUEST +20 XP")
            }
        }
    }
}
