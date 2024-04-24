package com.example.cat_api_assessment.data.service.paging

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

// I have made this generic to be possible to be implemented in multiple APIs.
interface PagingDataService {
    suspend fun <T : Any> getPagingDataFlow(
        limit: Int,
        apiCall: suspend (page: Int) -> Response<List<T>>
    ): Flow<PagingData<T>>
}