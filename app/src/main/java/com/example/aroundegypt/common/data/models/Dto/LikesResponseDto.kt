package com.example.aroundegypt.common.data.models.Dto

import com.google.gson.annotations.SerializedName

internal data class LikesResponseDto(
    @SerializedName("data")
    val numberOfLikes: Int?=null,
    @SerializedName("meta")
    val meta: MetaDto?=null,
    @SerializedName("pagination")
    val pagination: PaginationDto?=null
)