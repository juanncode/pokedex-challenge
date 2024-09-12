package com.github.juanncode.data.datasources.remote.responses

import com.google.gson.annotations.SerializedName

data class GameIndice(
    @SerializedName("game_index")
    val gameIndex: Int,
    val version: com.github.juanncode.data.datasources.remote.responses.Version
)