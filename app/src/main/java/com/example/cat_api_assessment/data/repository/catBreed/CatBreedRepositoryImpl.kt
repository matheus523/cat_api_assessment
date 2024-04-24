package com.example.cat_api_assessment.data.repository.catBreed

import androidx.paging.PagingData
import com.example.cat_api_assessment.data.model.CatBreed
import com.example.cat_api_assessment.data.repository.catBreed.dataSource.CatBreedRemote
import com.example.cat_api_assessment.data.service.paging.PagingDataService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CatBreedRepositoryImpl @Inject constructor(
    private val catBreedRemote: CatBreedRemote,
    private val pagingDataService: PagingDataService,
) :
    CatBreedRepository {
    override suspend fun getCatBreedsWithPagingDataFlow(limit: Int): Flow<PagingData<CatBreed>> {
        return pagingDataService.getPagingDataFlow(
            limit = limit,
            apiCall = { page: Int ->
                catBreedRemote.getCatBreedsWithPagination(page = page, limit = limit)
            }
        )
    }
}