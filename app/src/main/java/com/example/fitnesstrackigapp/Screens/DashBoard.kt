package com.example.fitnesstrackigapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Dashboard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Greeting(name = "User Name")
        Spacer(modifier = Modifier.height(16.dp))
        WaterIntakeProgress(waterIntake = 1500, goal = 2500)
        Spacer(modifier = Modifier.height(16.dp))
        CaloriesBurnt(caloriesBurnt = 500)
        Spacer(modifier = Modifier.height(16.dp))
        TodaysGoal(goal = 10000)
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name!", style = MaterialTheme.typography.h5)
}

@Composable
fun WaterIntakeProgress(waterIntake: Int, goal: Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Water Intake", style = MaterialTheme.typography.subtitle1)
            Spacer(modifier = Modifier.height(8.dp))
            CircularProgressBar(progress = waterIntake.toFloat() / goal.toFloat())
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Today's Water Intake: $waterIntake ml")
            Text(text = "Goal: $goal ml")
        }
    }
}

@Composable
fun CircularProgressBar(progress: Float) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(150.dp)
    ) {
        CircularProgressIndicator(
            progress = progress,
            modifier = Modifier.size(150.dp),
            color = MaterialTheme.colors.primary
        )
        Text(
            text = "${(progress * 100).toInt()}%",
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.primary
        )
    }
}

@Composable
fun CaloriesBurnt(caloriesBurnt: Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Calories Burnt", style = MaterialTheme.typography.subtitle1)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "$caloriesBurnt calories burnt today")
        }
    }
}

@Composable
fun TodaysGoal(goal: Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Today's Goal", style = MaterialTheme.typography.subtitle1)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Your goal for today is to achieve $goal steps")
        }
    }
}

@Preview
@Composable
fun PreviewDashboard() {
    Dashboard()
}
