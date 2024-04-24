package com.example.cat_api_assessment.data.service.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.cat_api_assessment.utils.Constants.DEFAULT_PREFETCH_DISTANCE
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class PagingDataServiceImpl : PagingDataService {
    override suspend fun <T : Any> getPagingDataFlow(
        limit: Int,
        apiCall: suspend (page: Int) -> Response<List<T>>
    ): Flow<PagingData<T>> {
        return Pager(
            config = PagingConfig(pageSize = limit, prefetchDistance = DEFAULT_PREFETCH_DISTANCE),
            pagingSourceFactory = {
                PagingSourceLoader(apiCall = { page: Int -> apiCall(page) })
            }
        ).flow
    }
}