package com.github.juanncode.data.datasources.remote.responses

import com.google.gson.annotations.SerializedName

data class VersionGroupDetail(
    @SerializedName("level_learned_at")
    val levelLearnedAt: Int,
    @SerializedName("move_learn_method")
    val moveLearnMethod: com.github.juanncode.data.datasources.remote.responses.MoveLearnMethod,
    @SerializedName("version_group")
    val versionGroup: com.github.juanncode.data.datasources.remote.responses.VersionGroup
)