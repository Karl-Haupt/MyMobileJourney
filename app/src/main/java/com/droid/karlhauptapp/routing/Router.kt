package com.droid.karlhauptapp.routing

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.droid.karlhauptapp.component.AppDrawer.AppDrawerHeader
import com.droid.karlhauptapp.screen.CourseScreen
import com.droid.karlhauptapp.screen.JourneyScreen
import com.droid.karlhauptapp.screen.WelcomeScreen

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object JourneyRoute : Screen("journey_screen")
    object CourseScreen : Screen("course_screen")
}

@Composable
fun Router() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            AppDrawerHeader(navController)
            WelcomeScreen(navController)
        }
        composable(route = Screen.JourneyRoute.route) {
            AppDrawerHeader(navController)
            JourneyScreen(navController)
        }
        composable(route = Screen.CourseScreen.route) {
            AppDrawerHeader(navController)
            CourseScreen(navController)
        }
    }
}


