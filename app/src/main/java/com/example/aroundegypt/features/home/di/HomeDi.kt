package com.example.aroundegypt.features.home.di

import com.example.aroundegypt.common.domain.remote.IRestApiProvider
import com.example.aroundegypt.features.home.data.repo.HomeRepo
import com.example.aroundegypt.features.home.data.repo.remote.HomeRemoteDataSourceRepo
import com.example.aroundegypt.features.home.domain.interactor.GetExperiencesUC
import com.example.aroundegypt.features.home.domain.interactor.GetRecommendedExperiencesUC
import com.example.aroundegypt.features.home.domain.interactor.LikeExperienceUC
import com.example.aroundegypt.features.home.domain.interactor.SearchUC
import com.example.aroundegypt.features.home.domain.repo.IHomeRepo
import com.example.aroundegypt.features.home.domain.repo.remote.IHomeRemoteDataSourceRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object HomeDi {
    @Provides
    fun provideHomeRemoteDatasource(restApiNetworkProvider: IRestApiProvider): IHomeRemoteDataSourceRepo =
        HomeRemoteDataSourceRepo(restApiNetworkProvider)


    @Provides
    fun provideHomeRepo(
        remoteDS: IHomeRemoteDataSourceRepo,

        ): IHomeRepo =
        HomeRepo(remoteDS)

    @Provides
    fun provideGetExperiencesUC(repository: IHomeRepo): GetExperiencesUC =
        GetExperiencesUC(repository)

    @Provides
    fun provideGetRecommendedExperiencesUC(repository: IHomeRepo): GetRecommendedExperiencesUC =
        GetRecommendedExperiencesUC(repository)

    @Provides
    fun provideLikeExperiencesUC(repository: IHomeRepo): LikeExperienceUC =
        LikeExperienceUC(repository)

    @Provides
    fun provideSearchExperiencesUC(repository: IHomeRepo): SearchUC =
        SearchUC(repository)
}