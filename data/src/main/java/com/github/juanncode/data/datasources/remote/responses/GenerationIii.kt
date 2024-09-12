package com.github.juanncode.data.datasources.remote.responses

import com.google.gson.annotations.SerializedName

data class GenerationIii(
    val emerald: com.github.juanncode.data.datasources.remote.responses.Emerald,
    @SerializedName("firered-leafgreen")
    val fireredLeafgreen: com.github.juanncode.data.datasources.remote.responses.FireredLeafgreen,
    @SerializedName("ruby-sapphire")
    val rubySapphire: com.github.juanncode.data.datasources.remote.responses.RubySapphire
)