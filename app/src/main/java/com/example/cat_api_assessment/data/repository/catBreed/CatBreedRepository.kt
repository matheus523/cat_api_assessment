package com.example.cat_api_assessment.data.repository.catBreed

import androidx.paging.PagingData
import com.example.cat_api_assessment.data.model.CatBreed
import kotlinx.coroutines.flow.Flow

interface CatBreedRepository {
    suspend fun getCatBreedsWithPagingDataFlow(limit: Int): Flow<PagingData<CatBreed>>
}