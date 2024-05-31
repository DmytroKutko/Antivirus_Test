package com.antivirus.testapp.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.antivirus.testapp.feature.home.presentation.HomeScreen
import com.antivirus.testapp.navigation.Screen

fun NavGraphBuilder.home(navController: NavController) {
    composable(
        route = Screen.HomeScreen.route
    ) {
        HomeScreen(navController)
    }
}