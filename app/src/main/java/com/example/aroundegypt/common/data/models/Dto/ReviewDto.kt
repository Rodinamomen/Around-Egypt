package com.example.aroundegypt.common.data.models.Dto

import com.google.gson.annotations.SerializedName

internal data class ReviewDto(
    @SerializedName("comment")
    val reviewComment: String? = null,
    @SerializedName("created_at")
    val reviewCreatedAt: String? = null,
    @SerializedName("experience")
    val reviewExperience: String? = null,
    @SerializedName("id")
    val reviewId: String? = null,
    @SerializedName("name")
    val reviewName: String? = null,
    @SerializedName("rating")
    val reviewRating: Int? = null
)