package com.github.juanncode.data.datasources.remote.responses

import com.google.gson.annotations.SerializedName

data class GenerationIv(
    @SerializedName("diamond-pearl")
    val diamondPearl: com.github.juanncode.data.datasources.remote.responses.DiamondPearl,
    @SerializedName("heartgold-soulsilver")
    val heartgoldSoulsilver: com.github.juanncode.data.datasources.remote.responses.HeartgoldSoulsilver,
    val platinum: com.github.juanncode.data.datasources.remote.responses.Platinum
)