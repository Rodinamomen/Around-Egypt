package com.example.aroundegypt.common.data.models.Dto

import com.google.gson.annotations.SerializedName

internal data class ExperiencesDto(
    @SerializedName("data")
    val data: List<DataDto>? = null,
    @SerializedName("meta")
    val meta: MetaDto? = null,
    @SerializedName("pagination")
    val pagination: PaginationDto? = null
)