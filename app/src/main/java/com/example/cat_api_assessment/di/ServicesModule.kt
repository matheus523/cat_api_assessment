package com.example.cat_api_assessment.di

import com.example.cat_api_assessment.BuildConfig
import com.example.cat_api_assessment.data.service.api.CatApi
import com.example.cat_api_assessment.data.service.paging.PagingDataService
import com.example.cat_api_assessment.data.service.paging.PagingDataServiceImpl
import com.example.cat_api_assessment.utils.Constants.CONNECTION_TIMEOUT
import com.example.cat_api_assessment.utils.Constants.READ_TIMEOUT
import com.example.cat_api_assessment.utils.Constants.WRITE_TIMEOUT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServicesModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(BuildConfig.CAT_URL_V1)
            .build()
    }

    @Singleton
    @Provides
    fun provideCatApiService(retrofit: Retrofit): CatApi {
        return retrofit.create(CatApi::class.java)
    }

    @Singleton
    @Provides
    fun providePagingDataService(): PagingDataService {
        return PagingDataServiceImpl()
    }
}