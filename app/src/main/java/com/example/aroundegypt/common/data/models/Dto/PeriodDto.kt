package com.example.aroundegypt.common.data.models.Dto

import com.google.gson.annotations.SerializedName

internal data class PeriodDto(
    @SerializedName("created_at")
    val periodCreatedAt: String? = null,
    @SerializedName("id")
    val periodId: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null,
    @SerializedName("value")
    val periodValue: String? = null
)