package com.github.juanncode.pokedex_challenge.screens.home

import androidx.compose.foundation.text.input.TextFieldState
import com.github.juanncode.domain.Pokemon
import com.github.juanncode.domain.utils.ErrorGeneric

data class HomeState(
    val loading: Boolean = false,
    val error: ErrorGeneric? = null,
    val textFieldState: TextFieldState = TextFieldState(),
    val pokemons: List<Pokemon> = emptyList(),
    val backupPokemons: List<Pokemon> = emptyList(),
)
