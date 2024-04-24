package com.example.cat_api_assessment.presentation.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.cat_api_assessment.presentation.route.IntroRoute

@Composable
fun RootNavigationGraph(navController: NavHostController, startDestination: IntroRoute) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.INTRO
    ) {
        introNavGraph(navController = navController, startDestination = startDestination)
        animalBreedNavGraph(navController = navController)
    }
}

object Graph {
    const val ROOT: String = "root_graph"
    const val INTRO: String = "intro_graph"
    const val ANIMAL_BREED: String = "animal_breed_graph"
}