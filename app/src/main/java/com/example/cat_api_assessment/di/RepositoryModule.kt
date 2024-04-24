package com.example.cat_api_assessment.di

import com.example.cat_api_assessment.data.repository.catBreed.CatBreedRepository
import com.example.cat_api_assessment.data.repository.catBreed.CatBreedRepositoryImpl
import com.example.cat_api_assessment.data.repository.catBreed.dataSource.CatBreedRemote
import com.example.cat_api_assessment.data.service.paging.PagingDataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideCatBreedRepository(
        catBreedRemote: CatBreedRemote,
        pagingDataService: PagingDataService,
    ): CatBreedRepository {
        return CatBreedRepositoryImpl(
            catBreedRemote = catBreedRemote,
            pagingDataService = pagingDataService
        )
    }
}