package com.stu71930.lab2_assignment.controllers

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stu71930.lab2_assignment.views.MainView
import com.stu71930.lab2_assignment.views.MovieDetails

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Driver.MainView,
    ) {
        composable(route = Driver.MainView)
        {
            MainView(navController = navController)
        }
        composable(route = Driver.MovieDetails) { backStackEntry ->
            val movieId: String? = backStackEntry.arguments?.getString("movieId")
            MovieDetails(movieName = movieId, navController = navController)
        }
    }
}