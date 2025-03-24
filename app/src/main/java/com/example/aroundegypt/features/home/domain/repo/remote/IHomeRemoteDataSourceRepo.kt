package com.example.aroundegypt.features.home.domain.repo.remote

import com.example.aroundegypt.common.data.models.Dto.ExperiencesDto
import com.example.aroundegypt.common.data.models.Dto.LikesResponseDto

internal interface IHomeRemoteDataSourceRepo {
    suspend fun getExperiences(): ExperiencesDto
    suspend fun getRecommendedExperiences(): ExperiencesDto
    suspend fun likeExperience(id: String): LikesResponseDto
    suspend fun search(title:String):ExperiencesDto
}