package com.example.fitnesstrackigapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.fitnesstrackigapp.Screens.LandingPage
import com.example.fitnesstrackigapp.Screens.Login.ProfileSet
import com.example.fitnesstrackigapp.Screens.Login.SignUpScreen
import com.example.fitnesstrackigapp.Screens.Onboarding.OnBoardingPage
import com.example.fitnesstrackigapp.Screens.Onboarding.OnboardingPages
import com.example.fitnesstrackigapp.Screens.Onboarding.StartedPage
import com.example.fitnesstrackigapp.Screens.WorkoutScreens.CardioWorkoutScreen
import com.example.fitnesstrackigapp.Screens.WorkoutScreens.WeightTrainingScreen
import com.example.fitnesstrackigapp.data.UserCredsDatabase
import com.example.fitnesstrackigapp.data.UserCredsViewModel
import com.example.fitnesstrackigapp.ui.theme.FitnessTrackigAppTheme
import java.time.LocalTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        scheduleDailyAlarm(applicationContext, 20,7,"its morbing time")
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            FitnessTrackigAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  FitNav(navController)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FitnessTrackigAppTheme {
        Greeting("Android")
    }
}