package com.example.cat_api_assessment.presentation.route

sealed class IntroRoute(val route: String) {
    data object CatBreedIntroRoute : IntroRoute(route = "catBreedIntroRoute")
}