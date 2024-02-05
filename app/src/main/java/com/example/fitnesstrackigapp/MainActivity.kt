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
import androidx.navigation.compose.rememberNavController
import com.example.fitnesstrackigapp.Screens.Login.ProfileSet
import com.example.fitnesstrackigapp.Screens.Login.SignUpScreen
import com.example.fitnesstrackigapp.Screens.Onboarding.OnBoardingPage
import com.example.fitnesstrackigapp.Screens.Onboarding.OnboardingPages
import com.example.fitnesstrackigapp.Screens.Onboarding.StartedPage
import com.example.fitnesstrackigapp.ui.theme.FitnessTrackigAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            FitnessTrackigAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  FitNav(navController = navController)
                    //SignUpScreen()
                    //ProfileSet()

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