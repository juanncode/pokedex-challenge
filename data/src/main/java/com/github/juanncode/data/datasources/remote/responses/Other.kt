package com.github.juanncode.data.datasources.remote.responses

import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName("dream_world")
    val dreamWorld: com.github.juanncode.data.datasources.remote.responses.DreamWorld,
    @SerializedName("official-artwork")
    val officialArtwork: com.github.juanncode.data.datasources.remote.responses.OfficialArtwork
)