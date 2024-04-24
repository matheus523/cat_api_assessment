package com.example.cat_api_assessment.presentation.navGraph

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.cat_api_assessment.data.model.AnimalBreed
import com.example.cat_api_assessment.presentation.route.AnimalBreedRoute
import com.example.cat_api_assessment.presentation.ui.animalList.AnimalEvent
import com.example.cat_api_assessment.presentation.ui.animalList.AnimalListView
import com.example.cat_api_assessment.presentation.ui.animalList.AnimalListViewModel
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
            val animalViewModel: AnimalListViewModel = hiltViewModel()
            val pagingItems: LazyPagingItems<AnimalBreed> =
                animalViewModel.animalState.collectAsLazyPagingItems()
            val animalViewState by animalViewModel.animalViewState.collectAsState()

            AnimalListView(
                pagingItems = pagingItems,
                animalViewState = animalViewState,
                onError = { error: LoadState.Error ->
                    animalViewModel.handelLoadStateError(error = error)
                },
                onDialogButtonClick = {
                    animalViewModel.onEvent(event = AnimalEvent.GetCatBreed)
                }
            )
        }
    }
}