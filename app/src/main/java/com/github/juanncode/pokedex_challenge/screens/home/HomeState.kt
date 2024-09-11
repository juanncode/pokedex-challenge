package com.github.juanncode.pokedex_challenge.screens.home

import com.github.juanncode.domain.Pokemon
import com.github.juanncode.domain.utils.ErrorGeneric

data class HomeState(
    val loading: Boolean = false,
    val error: ErrorGeneric? = null,
    val pokemons: List<Pokemon> = emptyList(),
)
