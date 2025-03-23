package com.example.aroundegypt.common.di.remote

import com.example.aroundegypt.common.data.repo.remote.RestApiProvider
import com.example.aroundegypt.common.domain.remote.IRestApiProvider
import com.example.aroundegypt.common.domain.remote.network.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RemoteDataSourceDi {
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("aroundegypt.34ml.com/api/v2/experiences/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRestApiNetworkProvider(apiService: ApiService, gson: Gson): IRestApiProvider {
        return RestApiProvider(apiService, gson)
    }
}