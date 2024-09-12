package com.github.juanncode.pokedex_challenge.screens.home

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.juanncode.domain.repository.PokemonRepository
import com.github.juanncode.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    init {

        viewModelScope.launch {
            snapshotFlow {
                state.textFieldState.text
            }.collect {
                state = if (it.isEmpty()) {
                    state.copy(pokemons = state.backupPokemons)
                } else {
                    state.copy(
                        pokemons = state.backupPokemons.filter { pok ->
                            pok.name.contains(it.toString())
                        }.toList()
                    )
                }

            }
        }

        repository.getPokemons().onEach {
            state = state.copy(pokemons = it, backupPokemons = it)
        }.launchIn(viewModelScope)

        viewModelScope.launch {
            state = state.copy(loading = true)
            val result = repository.fetchPokemons()
            state = state.copy(loading = false)
            if (result is Resource.Error) {
                state = state.copy(error = result.error)
            }
        }
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.CleanError -> state = state.copy(error = null)
            HomeEvent.ClearText -> state = state.copy(textFieldState = TextFieldState())
        }
    }

}