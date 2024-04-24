package com.example.cat_api_assessment.di

import com.example.cat_api_assessment.data.repository.catBreed.dataSource.CatBreedRemote
import com.example.cat_api_assessment.data.repository.catBreed.dataSourceImpl.CatBreedRemoteImpl
import com.example.cat_api_assessment.data.service.api.CatApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideCatBreedRemote(catApi: CatApi): CatBreedRemote {
        return CatBreedRemoteImpl(catApi = catApi)
    }
}