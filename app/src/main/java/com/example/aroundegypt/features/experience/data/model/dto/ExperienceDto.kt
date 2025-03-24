package com.example.aroundegypt.features.experience.data.model.dto

import com.example.aroundegypt.common.data.models.Dto.DataDto
import com.example.aroundegypt.common.data.models.Dto.MetaDto
import com.example.aroundegypt.common.data.models.Dto.PaginationDto
import com.google.gson.annotations.SerializedName

internal data class ExperienceDto(
    @SerializedName("data")
    val data: DataDto? = null,
    @SerializedName("meta")
    val meta: MetaDto? = null,
    @SerializedName("pagination")
    val pagination: PaginationDto? = null
)