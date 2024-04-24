package com.example.cat_api_assessment.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.cat_api_assessment.presentation.theme.AppTheme
import com.example.cat_api_assessment.presentation.theme.Dimensions
import com.example.cat_api_assessment.presentation.ui.components.dialog.LoadingDialog
import com.example.cat_api_assessment.utils.Orientation
import com.example.cat_api_assessment.utils.WindowType

private const val LARGE_SCREEN_GRID_CELLS: Int = 2
private const val SMALL_SCREEN_GRID_CELLS: Int = 1

@Composable
fun <T : Any> PaginationListView(
    pagingItems: LazyPagingItems<T>,
    modifier: Modifier = Modifier,
    onError: (LoadState.Error) -> Unit,
    getItemView: @Composable (itemIndex: Int) -> Unit,
) {
    val dimensions: Dimensions = AppTheme.dimensions
    val orientation: Orientation = AppTheme.orientation
    val windowType: WindowType = AppTheme.windowType

    val gridCells: Int =
        if (orientation == Orientation.Landscape || windowType == WindowType.LARGE) LARGE_SCREEN_GRID_CELLS
        else SMALL_SCREEN_GRID_CELLS

    LazyVerticalStaggeredGrid(
        modifier = modifier.fillMaxSize(),
        columns = StaggeredGridCells.Fixed(gridCells),
        verticalItemSpacing = dimensions.mediumSpacing,
        horizontalArrangement = Arrangement.spacedBy(dimensions.mediumSpacing),
        content = {
            items(pagingItems.itemCount) { index: Int -> getItemView(index) }
            pagingItems.apply {
                when {
                    loadState.refresh is LoadState.Loading -> item { LoadingDialog() }
                    loadState.refresh is LoadState.Error ->
                        onError(pagingItems.loadState.refresh as LoadState.Error)

                    loadState.append is LoadState.Loading -> item {
                        Row(
                            modifier = modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) { CircularProgressIndicator() }
                    }

                    loadState.append is LoadState.Error ->
                        onError(pagingItems.loadState.refresh as LoadState.Error)
                }
            }
        },
    )
}