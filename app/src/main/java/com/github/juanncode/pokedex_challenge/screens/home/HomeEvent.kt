package com.github.juanncode.pokedex_challenge.screens.home

sealed interface HomeEvent {
    data object ClearText: HomeEvent
    data object CleanError: HomeEvent
}