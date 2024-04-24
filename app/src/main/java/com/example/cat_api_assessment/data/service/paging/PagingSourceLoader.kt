package com.example.cat_api_assessment.data.service.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cat_api_assessment.utils.Constants.DEFAULT_FIRST_PAGE_NUMBER
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class PagingSourceLoader<T : Any>(
    private val apiCall: suspend (page: Int) -> Response<List<T>>,
) : PagingSource<Int, T>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        return try {
            val currentPage: Int = params.key ?: DEFAULT_FIRST_PAGE_NUMBER
            val response: Response<List<T>> = apiCall(currentPage)
            LoadResult.Page(
                data = response.body()!!,
                prevKey = if (currentPage == DEFAULT_FIRST_PAGE_NUMBER) null else currentPage - 1,
                nextKey = if (response.body()!!.isEmpty()) null else currentPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition
    }
}