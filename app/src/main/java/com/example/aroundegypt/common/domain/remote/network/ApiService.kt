package com.example.aroundegypt.common.domain.remote.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

@JvmSuppressWildcards
interface ApiService {
    @POST("{path}")
    suspend fun <RequestResponse> post(
        @Path("path", encoded = true) endpoint: String,
        @QueryMap params: Map<String, Any>,
        @HeaderMap headers: Map<String, Any>,
        @Body requestBody: Any
    ): Response<RequestResponse>

    @GET("{path}")
    suspend fun <RequestResponse> get(
        @Path("path", encoded = true) endpoint: String,
        @QueryMap params: Map<String, Any>? = emptyMap(),
        @HeaderMap headers: Map<String, Any>
    ): Response<RequestResponse>

    @PUT("{path}")
    suspend fun <RequestResponse, RequestBody> put(
        @Path("path", encoded = true) endpoint: String,
        @QueryMap params: Map<String, Any>,
        @HeaderMap headers: Map<String, Any>,
        @Body requestBody: Any
    ): Response<RequestResponse>

    @DELETE("{path}")
    suspend fun <RequestResponse, RequestBody> delete(
        @Path("path", encoded = true) endpoint: String,
        @QueryMap params: Map<String, Any>,
        @HeaderMap headers: Map<String, Any>,
        @Body requestBody: Any
    ): Response<RequestResponse>
}