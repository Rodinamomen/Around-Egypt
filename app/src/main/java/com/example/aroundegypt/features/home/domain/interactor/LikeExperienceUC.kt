package com.example.aroundegypt.features.home.domain.interactor

import com.example.aroundegypt.common.data.models.Resource
import com.example.aroundegypt.common.data.models.exception.AroundEgyptException
import com.example.aroundegypt.features.home.domain.models.LikesResponse
import com.example.aroundegypt.features.home.domain.repo.IHomeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion

class LikeExperienceUC(private val homeRepo: IHomeRepo) {
    operator fun invoke(id: String): Flow<Resource<LikesResponse>> = flow {
        emit(Resource.Loading(true))
        val remoteResponse = homeRepo.likeExperience(id)
        emit(Resource.Success(remoteResponse))
    }.catch { throwable ->
        val failureResource = if (throwable is AroundEgyptException) throwable else
            AroundEgyptException.UnKnownException.UnKnown(message = throwable.message.toString())
        emit(Resource.Failure(failureResource))
    }.onCompletion {
        emit(Resource.Loading(false))
    }.flowOn(Dispatchers.IO)
}