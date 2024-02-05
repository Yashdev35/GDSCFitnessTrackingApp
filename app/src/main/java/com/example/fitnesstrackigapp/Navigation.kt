package com.example.fitnesstrackigapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fitnesstrackigapp.Screens.Login.ProfileSet
import com.example.fitnesstrackigapp.Screens.Login.SignUpScreen
import com.example.fitnesstrackigapp.Screens.Login.WelcomeScreen
import com.example.fitnesstrackigapp.Screens.Onboarding.OnboardingPages
import com.example.fitnesstrackigapp.Screens.Onboarding.StartedPage

@Composable
fun FitNav(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.GetStarted.route){
        composable(Screen.GetStarted.route){
            StartedPage(navigateToOnBoarding = {
                navController.navigate(Screen.OnBoarding.route)
            })
        }
        composable(Screen.OnBoarding.route){
            OnboardingPages(navToSignUp = {
                navController.navigate(Screen.SignUp.route)
            })
        }
        composable(Screen.SignUp.route){
            SignUpScreen(navigateToWel ={
                name->
                navController.navigate("${Screen.Welcome.route}/$name")
            }
            )
        }
        composable(Screen.Home.route){
            //HomeScreen()
        }
        composable("${Screen.Welcome.route}/{name}"){
            val name = it.arguments?.getString("name")?:""
            WelcomeScreen(name = name) {
                navController.navigate(Screen.ProfileSetup.route)
            }
        }
        composable(Screen.ProfileSetup.route){
            ProfileSet()
        }
    }
}