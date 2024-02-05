package com.example.fitnesstrackigapp

sealed class Screen(val route: String) {
    object OnBoarding : Screen("onboarding_screen")
    object GetStarted : Screen("get_started_screen")
    object Login : Screen("login_screen")
    object SignUp : Screen("signup_screen")
    object Home : Screen("home_screen")
    object Welcome : Screen("welcome_screen")
    object ProfileSetup : Screen("profile_set_screen")
}