package com.github.juanncode.pokedex_challenge.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.juanncode.domain.repository.PokemonRepository
import com.github.juanncode.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {
    var state by mutableStateOf(DetailState())
        private set


    fun onEvent(event: DetailEvent) {
        when(event) {
            DetailEvent.CleanError -> {
                state = state.copy(error = null)
            }
            is DetailEvent.GetPokemon -> {
                viewModelScope.launch {
                    state = state.copy(isLoading = true)
                    val response = repository.fetchPokemon(event.id)
                    state = state.copy(isLoading = false)
                    when(response) {
                        is Resource.Error -> state = state.copy(error = response.error)
                        is Resource.Success -> state = state.copy(pokemon = response.value)
                    }
                }
            }
        }
    }
}