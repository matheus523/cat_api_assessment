package com.example.cat_api_assessment.domain

import androidx.paging.PagingData
import com.example.cat_api_assessment.data.model.CatBreed
import com.example.cat_api_assessment.data.repository.catBreed.CatBreedRepository
import com.example.cat_api_assessment.utils.Constants.DEFAULT_API_PAGES_LIMIT
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCatBreedsWithPagingDataFlowUseCase @Inject constructor(
    private val catBreedRepository: CatBreedRepository
) {
    suspend fun execute(limit: Int = DEFAULT_API_PAGES_LIMIT): Flow<PagingData<CatBreed>> {
        return catBreedRepository.getCatBreedsWithPagingDataFlow(limit = limit)
    }
}