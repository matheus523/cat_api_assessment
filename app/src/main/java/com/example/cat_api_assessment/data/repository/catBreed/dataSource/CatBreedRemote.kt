package com.example.cat_api_assessment.data.repository.catBreed.dataSource

import com.example.cat_api_assessment.data.model.CatBreed
import retrofit2.Response

interface CatBreedRemote {
    suspend fun getCatBreedsWithPagination(page: Int, limit: Int): Response<List<CatBreed>>
}