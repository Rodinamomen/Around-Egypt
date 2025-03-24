package com.example.aroundegypt.features.home.data.repo

import com.example.aroundegypt.common.data.mappers.ExperiencesMapper
import com.example.aroundegypt.common.domain.remote.model.Experiences
import com.example.aroundegypt.features.home.data.mappers.LikesResponseMapper
import com.example.aroundegypt.features.home.domain.models.LikesResponse
import com.example.aroundegypt.features.home.domain.repo.IHomeRepo
import com.example.aroundegypt.features.home.domain.repo.remote.IHomeRemoteDataSourceRepo

internal class HomeRepo(private val remoteDataSourceRepo: IHomeRemoteDataSourceRepo) : IHomeRepo {
    override suspend fun getExperiences(): Experiences {
        return ExperiencesMapper.dtoToDomain(remoteDataSourceRepo.getExperiences())
    }

    override suspend fun getRecommendedExperiences(): Experiences {
        return ExperiencesMapper.dtoToDomain(remoteDataSourceRepo.getRecommendedExperiences())
    }

    override suspend fun likeExperience(id: String): LikesResponse {
        return LikesResponseMapper.dtoToDomain(remoteDataSourceRepo.likeExperience(id))
    }

    override suspend fun search(title: String): Experiences {
        return ExperiencesMapper.dtoToDomain(remoteDataSourceRepo.search(title))
    }
}