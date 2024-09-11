package com.github.juanncode.data.mappers

import com.github.juanncode.data.database.PokemonEntity
import com.github.juanncode.data.datasources.remote.model.PokemonDto
import com.github.juanncode.domain.Pokemon

fun PokemonDto.toDomain(): Pokemon {
    val idPokemon = getIdFromUrl(url)
    return Pokemon(
        id = idPokemon,
        name = name,
        url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$idPokemon.png"
    )
}

fun getIdFromUrl(route: String) : Int {
    println("Pokemon id ")

    val urlParts = route.split("/")
    return (urlParts[urlParts.size - 2]).toInt()
}

fun PokemonEntity.toDomain() = Pokemon(
    id = id,
    name = name,
    url = url
)

fun Pokemon.toEntity() = PokemonEntity(
    id = id,
    name = name,
    url = url
)