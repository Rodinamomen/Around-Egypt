package com.example.aroundegypt.features.experience.data.repo.remote

import com.example.aroundegypt.common.data.models.Dto.LikesResponseDto
import com.example.aroundegypt.common.domain.remote.IRestApiProvider
import com.example.aroundegypt.features.experience.data.model.dto.ExperienceDto
import com.example.aroundegypt.features.experience.domain.repo.remote.IExperienceRemoteRepo

internal class ExperienceRemoteRepo(private val restApiProvider: IRestApiProvider) :
    IExperienceRemoteRepo {
    override suspend fun getExperience(id: String): ExperienceDto {

        return restApiProvider.get(endpoint = "experiences/$id", type = ExperienceDto::class.java)
    }

    override suspend fun likeExperience(id: String): LikesResponseDto {
        return restApiProvider.post(
            endpoint = "experiences/$id/like",
            type = LikesResponseDto::class.java,
            requestBody = Unit
        )
    }
}