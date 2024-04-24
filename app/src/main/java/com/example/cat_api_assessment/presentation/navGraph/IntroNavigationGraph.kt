package com.example.cat_api_assessment.presentation.navGraph

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.cat_api_assessment.R
import com.example.cat_api_assessment.presentation.route.IntroRoute
import com.example.cat_api_assessment.presentation.ui.intro.IntroView
import com.example.cat_api_assessment.utils.Constants.NAV_ANIMATION_DURATION

fun NavGraphBuilder.introNavGraph(navController: NavHostController, startDestination: IntroRoute) {
    navigation(
        route = Graph.INTRO,
        startDestination = startDestination.route,
    ) {
        composable(
            route = IntroRoute.CatBreedIntroRoute.route,
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
            }
        ) {
            IntroView(
                imageResourceId = R.drawable.the_cat_api_image,
                introButtonTextId = R.string.cat_intro_button_text,
                introTextId = R.string.cat_intro_text,
                onButtonClick = {

                }
            )
        }
    }
}