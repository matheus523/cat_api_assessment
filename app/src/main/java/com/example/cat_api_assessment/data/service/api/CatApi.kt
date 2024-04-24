package com.example.cat_api_assessment.data.service.api

import com.example.cat_api_assessment.data.model.CatBreed
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CatApi {
    @GET("breeds")
    suspend fun getCatBreedsWithPagination(
        @Header("x-api-key") apiKey: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int,
    ): Response<List<CatBreed>>
}