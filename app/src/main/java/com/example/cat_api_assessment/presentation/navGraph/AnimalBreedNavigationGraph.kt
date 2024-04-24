package com.example.cat_api_assessment.presentation.navGraph

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.cat_api_assessment.presentation.route.AnimalBreedRoute
import com.example.cat_api_assessment.utils.Constants.NAV_ANIMATION_DURATION

fun NavGraphBuilder.animalBreedNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ANIMAL_BREED,
        startDestination = AnimalBreedRoute.AnimalBreedListRoute.route,
    ) {
        composable(
            route = AnimalBreedRoute.AnimalBreedListRoute.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(NAV_ANIMATION_DURATION)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(NAV_ANIMATION_DURATION)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(NAV_ANIMATION_DURATION)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(NAV_ANIMATION_DURATION)
                )
            },
        ) {

        }
    }
}