package com.github.juanncode.data.datasources.remote.responses

import com.google.gson.annotations.SerializedName

data class GenerationVi(
    @SerializedName("omegaruby-alphasapphire")
    val omegarubyAlphasapphire: com.github.juanncode.data.datasources.remote.responses.OmegarubyAlphasapphire,
    @SerializedName("x-y")
    val xY: com.github.juanncode.data.datasources.remote.responses.XY
)