package com.github.juanncode.pokedex_challenge.screens.detail


sealed interface DetailEvent {

    data class GetPokemon(val id: Int): DetailEvent
    data object CleanError: DetailEvent
}

