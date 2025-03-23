package com.example.aroundegypt.common.data.models.Dto

import com.google.gson.annotations.SerializedName

internal data class MetaDto(
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("errors")
    val errors: List<ErrorDto>? = null
)