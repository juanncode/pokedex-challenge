package com.github.juanncode.data.datasources.remote.responses

import com.google.gson.annotations.SerializedName

data class Move(
    val move: com.github.juanncode.data.datasources.remote.responses.MoveX,
    @SerializedName("version_group_details")
    val versionGroupDetails: List<com.github.juanncode.data.datasources.remote.responses.VersionGroupDetail>
)