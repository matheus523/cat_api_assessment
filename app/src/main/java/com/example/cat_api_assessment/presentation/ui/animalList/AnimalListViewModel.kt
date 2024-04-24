package com.example.cat_api_assessment.presentation.ui.animalList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.cat_api_assessment.data.model.AnimalBreed
import com.example.cat_api_assessment.data.model.CatBreed
import com.example.cat_api_assessment.domain.GetCatBreedsWithPagingDataFlowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimalListViewModel @Inject constructor(
    private val getCatBreedsWithPagingDataFlowUseCase: GetCatBreedsWithPagingDataFlowUseCase
) : ViewModel() {
    private val _animalViewState: MutableStateFlow<AnimalViewState> =
        MutableStateFlow(AnimalViewState())
    val animalViewState: StateFlow<AnimalViewState> = _animalViewState.asStateFlow()

    private val _animalState: MutableStateFlow<PagingData<AnimalBreed>> =
        MutableStateFlow(value = PagingData.empty())
    val animalState: MutableStateFlow<PagingData<AnimalBreed>> get() = _animalState

    init {
        onEvent(AnimalEvent.GetCatBreed)
    }

    fun onEvent(event: AnimalEvent) {
        _animalViewState.update { animalViewState: AnimalViewState ->
            animalViewState.copy(hasError = false)
        }
        viewModelScope.launch {
            when (event) {
                is AnimalEvent.GetCatBreed -> {
                    getCatBreeds()
                }
            }
        }
    }

    fun handelLoadStateError(error: LoadState.Error) {
        // Here we can see the error and display the correct error popup to the user.
        _animalViewState.update { animalViewState: AnimalViewState ->
            animalViewState.copy(hasError = true)
        }
    }

    private suspend fun getCatBreeds() {
        getCatBreedsWithPagingDataFlowUseCase.execute()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
            .collect { response: PagingData<CatBreed> ->
                _animalState.value = response.map { catBreed ->
                    catBreed.getAnimalBreed()
                }
            }
    }
}

sealed class AnimalEvent {
    data object GetCatBreed : AnimalEvent()
}