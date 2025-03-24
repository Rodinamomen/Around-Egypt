package com.example.aroundegypt.features.home.data.repo.remote

import com.example.aroundegypt.common.data.models.Dto.ExperiencesDto
import com.example.aroundegypt.common.data.models.Dto.LikesResponseDto
import com.example.aroundegypt.common.domain.remote.IRestApiProvider
import com.example.aroundegypt.features.home.domain.repo.remote.IHomeRemoteDataSourceRepo

internal class HomeRemoteDataSourceRepo(private val restApiProvider: IRestApiProvider) :
    IHomeRemoteDataSourceRepo {
    override suspend fun getExperiences(): ExperiencesDto {
        return restApiProvider.get(
            endpoint = "experiences",
            type = ExperiencesDto::class.java
        )
    }

    override suspend fun getRecommendedExperiences(): ExperiencesDto {
        return restApiProvider.get(
            endpoint = "experiences", params = mapOf("filter[recommended]" to true),
            type = ExperiencesDto::class.java
        )
    }

    override suspend fun likeExperience(id: String): LikesResponseDto {
        return restApiProvider.post(
            endpoint = "experiences/$id/like",
            type = LikesResponseDto::class.java,
            requestBody = Unit
        )
    }

    override suspend fun search(title: String): ExperiencesDto {
        return restApiProvider.get(
            endpoint = "experiences",
            params = mapOf("filter[title]" to title),
            type = ExperiencesDto::class.java
        )
    }
}