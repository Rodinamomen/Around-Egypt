package com.example.aroundegypt.common.data.repo.remote

import com.example.aroundegypt.common.data.models.exception.AroundEgyptException
import com.example.aroundegypt.common.domain.remote.IRestApiProvider
import com.example.aroundegypt.common.domain.remote.network.ApiService
import com.google.gson.Gson
import retrofit2.Response
import java.lang.reflect.Type
import java.net.HttpURLConnection

internal class RestApiProvider(private val apiService: ApiService, private val gson: Gson) :
    IRestApiProvider {
    override suspend fun <ResponseBody, RequestBody> post(
        endpoint: String,
        params: Map<String, Any>?,
        headers: Map<String, Any>?,
        requestBody: RequestBody?,
        type: Type
    ): ResponseBody {
        val response = apiService.post<ResponseBody>(
            endpoint = endpoint,
            params = params ?: hashMapOf(),
            headers = headers ?: hashMapOf(),
            requestBody = requestBody ?: Unit
        )
        return handleResponse(response, type)
    }

    override suspend fun <ResponseBody> get(
        endpoint: String,
        params: Map<String, Any>?,
        headers: Map<String, Any>?,
        type: Type
    ): ResponseBody {
        val response = apiService.get<ResponseBody>(
            endpoint = endpoint,
            params = params ?: hashMapOf(),
            headers = headers ?: hashMapOf()
        )
        return handleResponse(response, type)
    }

    override suspend fun <ResponseBody, RequestBody> put(
        endpoint: String,
        params: Map<String, Any>,
        headers: Map<String, Any>?,
        requestBody: RequestBody?,
        type: Type
    ): ResponseBody {
        val response = apiService.put<ResponseBody, RequestBody>(
            endpoint = endpoint,
            params = params,
            headers = headers ?: hashMapOf(),
            requestBody = requestBody ?: Unit
        )
        return handleResponse(response, type)
    }

    override suspend fun <ResponseBody, RequestBody> delete(
        endpoint: String,
        params: Map<String, Any>?,
        headers: Map<String, Any>?,
        requestBody: RequestBody?,
        type: Type
    ): ResponseBody {
        val response = apiService.delete<ResponseBody, RequestBody>(
            endpoint = endpoint,
            params = params ?: hashMapOf(),
            headers = headers ?: hashMapOf(),
            requestBody = requestBody ?: Unit
        )
        return handleResponse(response, type)
    }

    private fun <ResponseBody> handleResponse(
        response: Response<ResponseBody>,
        responseType: Type
    ): ResponseBody {
        if (response.isSuccessful) {
            val responseString =
                response.body()
                    ?: throw AroundEgyptException.Client.Unhandled(httpErrorCode = response.code())
            return gson.fromJson(gson.toJson(responseString), responseType)
        } else {
            when (response.code()) {


                HttpURLConnection.HTTP_INTERNAL_ERROR -> throw AroundEgyptException.Server.InternalServerError(
                    httpErrorCode = response.code(),
                    message = response.errorBody()?.string()
                )

                else -> throw AroundEgyptException.Client.Unhandled(
                    httpErrorCode = response.code(),
                    message = response.errorBody()?.string()
                )
            }
        }
    }
}