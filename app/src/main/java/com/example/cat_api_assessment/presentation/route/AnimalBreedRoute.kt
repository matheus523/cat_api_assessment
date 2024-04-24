package com.example.cat_api_assessment.presentation.route

sealed class AnimalBreedRoute(val route: String) {
    data object AnimalBreedListRoute : IntroRoute(route = "animalBreedListRoute")
    data object AnimalBreedDetailRoute : IntroRoute(route = "animalBreedDetailRoute")
}