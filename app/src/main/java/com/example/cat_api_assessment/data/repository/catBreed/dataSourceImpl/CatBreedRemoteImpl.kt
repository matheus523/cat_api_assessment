package com.example.cat_api_assessment.data.repository.catBreed.dataSourceImpl

import com.example.cat_api_assessment.BuildConfig
import com.example.cat_api_assessment.data.model.CatBreed
import com.example.cat_api_assessment.data.repository.catBreed.dataSource.CatBreedRemote
import com.example.cat_api_assessment.data.service.api.CatApi
import retrofit2.Response
import javax.inject.Inject

class CatBreedRemoteImpl @Inject constructor(private val catApi: CatApi) : CatBreedRemote {
    override suspend fun getCatBreedsWithPagination(
        page: Int,
        limit: Int
    ): Response<List<CatBreed>> {
        return catApi.getCatBreedsWithPagination(
            apiKey = BuildConfig.API_KEY,
            limit = limit,
            page = page
        )
    }
}