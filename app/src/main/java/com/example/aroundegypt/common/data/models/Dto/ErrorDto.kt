package com.example.aroundegypt.common.data.models.Dto

import com.google.gson.annotations.SerializedName

internal data class ErrorDto(
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("message")
    val message: String? = null
)
