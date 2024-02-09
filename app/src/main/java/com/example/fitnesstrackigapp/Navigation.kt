package com.example.fitnesstrackigapp

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.fitnesstrackigapp.Screens.LandingPage
import com.example.fitnesstrackigapp.Screens.Login.ProfileSet
import com.example.fitnesstrackigapp.Screens.Login.SignUpScreen
import com.example.fitnesstrackigapp.Screens.Login.WelcomeScreen
import com.example.fitnesstrackigapp.Screens.Onboarding.OnboardingPages
import com.example.fitnesstrackigapp.Screens.Onboarding.StartedPage
import com.example.fitnesstrackigapp.Screens.WorkoutScreens.CalisthenicsTrainingScreen
import com.example.fitnesstrackigapp.Screens.WorkoutScreens.CardioWorkoutScreen
import com.example.fitnesstrackigapp.Screens.WorkoutScreens.WeightTrainingScreen
import com.example.fitnesstrackigapp.Screens.WorkoutScreens.YogaWorkoutScreen
import com.example.fitnesstrackigapp.data.UserCreds
import com.example.fitnesstrackigapp.data.UserCredsDatabase
import com.example.fitnesstrackigapp.data.UserCredsViewModel
import com.plcoding.composegooglesignincleanarchitecture.presentation.sign_in.SignInScreen
import com.plcoding.composegooglesignincleanarchitecture.presentation.sign_in.SignInViewModel
import kotlinx.coroutines.launch

@Composable
fun FitNav(navController: NavHostController,viewModel: UserCredsViewModel = viewModel()){
    val context = LocalContext.current
    NavHost(navController = navController, startDestination = Screen.GetStarted.route){
        composable(Screen.GetStarted.route){
            StartedPage(navController)
        }
        composable(Screen.OnBoarding.route){
            OnboardingPages(navController)
        }
        composable(Screen.SignUp.route){
            SignUpScreen(navController,viewModel = viewModel)
        }
        composable(Screen.Home.route){
            //HomeScreen()
        }
        composable(Screen.Welcome.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                    defaultValue = 0L
                    nullable = false
                }
            )
            ){bEntry->
            val id = if(bEntry.arguments != null)bEntry.arguments!!.getLong("id") else 0L
            val user = viewModel.getUserCreds(id).collectAsState(initial = null).value?: UserCreds(0,"","",0.0f,1,0f)
            WelcomeScreen(user,navController)
        }
        composable(Screen.ProfileSetup.route){
            ProfileSet()
        }
        composable(Screen.WorkingOutLanding.route){
            LandingPage(navController)
        }
        composable(Screen.CardioWorkout.route){
            CardioWorkoutScreen()
        }
        composable(Screen.Calisthenics.route){
            CalisthenicsTrainingScreen()
        }
        composable(Screen.WeightTraining.route){
            WeightTrainingScreen()
        }
        composable(Screen.Yoga.route){
            YogaWorkoutScreen()
        }
    }
}