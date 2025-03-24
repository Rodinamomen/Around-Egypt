package com.example.aroundegypt.features.experience.domain.repo.remote

import com.example.aroundegypt.common.data.models.Dto.LikesResponseDto
import com.example.aroundegypt.features.experience.data.model.dto.ExperienceDto

internal interface IExperienceRemoteRepo {
    suspend fun getExperience(id: String): ExperienceDto
    suspend fun likeExperience(id:String):LikesResponseDto
}