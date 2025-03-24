package com.example.aroundegypt.features.experience.di

import com.example.aroundegypt.common.domain.remote.IRestApiProvider
import com.example.aroundegypt.features.experience.data.repo.ExperienceRepo
import com.example.aroundegypt.features.experience.data.repo.remote.ExperienceRemoteRepo
import com.example.aroundegypt.features.experience.domain.interactors.GetExperienceUC
import com.example.aroundegypt.features.experience.domain.interactors.LikeExperienceUC
import com.example.aroundegypt.features.experience.domain.repo.IExperienceRpo
import com.example.aroundegypt.features.experience.domain.repo.remote.IExperienceRemoteRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object ExperienceModule {
    @Provides
    fun provideExperienceRemoteDatasource(restApiNetworkProvider: IRestApiProvider): IExperienceRemoteRepo =
        ExperienceRemoteRepo(restApiNetworkProvider)


    @Provides
    fun provideExperienceRepo(
        remoteDS: IExperienceRemoteRepo,

        ): IExperienceRpo =
        ExperienceRepo(remoteDS)

    @Provides
    fun provideGetExperienceUC(repository: IExperienceRpo): GetExperienceUC =
        GetExperienceUC(repository)

    @Provides
    fun provideLikeExperiencesUC(repository: IExperienceRpo): LikeExperienceUC =
        LikeExperienceUC(repository)
}