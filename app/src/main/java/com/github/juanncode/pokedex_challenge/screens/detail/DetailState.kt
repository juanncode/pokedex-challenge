package com.github.juanncode.pokedex_challenge.screens.detail

import com.github.juanncode.domain.PokemonDetail
import com.github.juanncode.domain.utils.ErrorGeneric

data class DetailState(
    val pokemon: PokemonDetail? = null,
    val error: ErrorGeneric? = null,
    val isLoading: Boolean = false
)
