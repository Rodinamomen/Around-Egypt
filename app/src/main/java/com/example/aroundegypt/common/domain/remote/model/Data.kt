package com.example.aroundegypt.common.domain.remote.model

data class Data(
    val address: String,
    val city: City,
    val coverPhoto: String,
    val description: String,
    val detailedDescription: String,
    val dataId: String,
    var isLiked: Boolean,
    var likesNumber: Int,
    val recommended: Int,
    val title: String,
    val tour360ViewLink: String,
    val viewsNumber: Int
)
