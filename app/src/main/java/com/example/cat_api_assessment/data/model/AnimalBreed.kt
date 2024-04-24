package com.example.cat_api_assessment.data.model

data class AnimalBreed(
    val animalName: String,
    val animalCountryCode: String,
    val animalTemperament: List<String>,
    val animalImage: Image?,
)
