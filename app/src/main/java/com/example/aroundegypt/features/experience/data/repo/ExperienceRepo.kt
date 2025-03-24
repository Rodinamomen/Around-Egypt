package com.example.aroundegypt.features.experience.data.repo

import com.example.aroundegypt.common.domain.remote.model.Data
import com.example.aroundegypt.features.experience.data.mappers.ExperienceMapper
import com.example.aroundegypt.features.experience.domain.repo.IExperienceRpo
import com.example.aroundegypt.features.experience.domain.repo.remote.IExperienceRemoteRepo
import com.example.aroundegypt.features.home.data.mappers.LikesResponseMapper
import com.example.aroundegypt.features.home.domain.models.LikesResponse

internal class ExperienceRepo(private val remoteDataSourceRepo: IExperienceRemoteRepo) :
    IExperienceRpo {
    override suspend fun getExperience(id: String): Data {
        return ExperienceMapper.dtoToDomain(remoteDataSourceRepo.getExperience(id))
    }

    override suspend fun likeExperience(id: String): LikesResponse {
        return LikesResponseMapper.dtoToDomain(remoteDataSourceRepo.likeExperience(id))
    }
}