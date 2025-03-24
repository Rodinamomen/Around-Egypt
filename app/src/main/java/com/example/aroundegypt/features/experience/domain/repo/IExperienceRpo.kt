package com.example.aroundegypt.features.experience.domain.repo

import com.example.aroundegypt.common.domain.remote.model.Data
import com.example.aroundegypt.features.home.domain.models.LikesResponse

internal interface IExperienceRpo {
    suspend fun getExperience(id: String): Data
    suspend fun likeExperience(id:String):LikesResponse
}