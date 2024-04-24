package com.example.cat_api_assessment.presentation.ui.animalList

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.cat_api_assessment.R
import com.example.cat_api_assessment.data.model.AnimalBreed
import com.example.cat_api_assessment.presentation.ui.components.PaginationListView
import com.example.cat_api_assessment.presentation.ui.components.dialog.AlertDialogView

@Composable
fun AnimalListView(
    pagingItems: LazyPagingItems<AnimalBreed>,
    animalViewState: AnimalViewState,
    onError: (LoadState.Error) -> Unit,
    onDialogButtonClick: () -> Unit,
) {
    if (animalViewState.hasError) {
        AlertDialogView(
            title = stringResource(id = R.string.error_title),
            body = stringResource(id = R.string.error_body),
            buttonText = stringResource(id = R.string.retry)
        ) { onDialogButtonClick() }
    }

    PaginationListView(pagingItems = pagingItems, onError = onError) { index: Int ->
        AnimalListElement(animalBreed = pagingItems[index]!!)
    }
}