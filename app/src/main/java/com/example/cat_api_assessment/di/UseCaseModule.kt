package com.example.cat_api_assessment.di

import com.example.cat_api_assessment.data.repository.catBreed.CatBreedRepository
import com.example.cat_api_assessment.domain.GetCatBreedsWithPagingDataFlowUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {
    @Provides
    fun provideGetCatBreedsUseCase(
        catBreedRepository: CatBreedRepository
    ): GetCatBreedsWithPagingDataFlowUseCase {
        return GetCatBreedsWithPagingDataFlowUseCase(catBreedRepository = catBreedRepository)
    }
}