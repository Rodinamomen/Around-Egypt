package com.example.aroundegypt.common.data.models.exception

import androidx.annotation.StringRes

sealed class AroundEgyptException(message: String?) : Exception() {
    sealed class Server(message: String?) : AroundEgyptException(message) {
        data class InternalServerError(
            override val message: String? = null,
            val httpErrorCode: Int
        ) : Server(message = "Internal server error with code:${httpErrorCode}, and the failure reason: $message")

        data class GateWayTimeOut(override val message: String? = null) : Server(message)
    }

    sealed class Local(message: String?) : AroundEgyptException(message) {
        data class RequestValidation(
            override val message: String? = null,
            val errors: Map<String, Int> = hashMapOf(),
        ) : Local(message)

        data class IOOperation(@StringRes val messageRes: Int, override val message: String? = "") :
            Local(message)
    }

    sealed class Client(message: String?) : AroundEgyptException(message) {

        data class Unhandled(val httpErrorCode: Int, override val message: String? = null) :
            Client(message = "Unhandled client error with code:${httpErrorCode}, and the failure reason: $message")
    }

    sealed class UnKnownException(message: String?) : AroundEgyptException(message) {
        data class UnKnown(override val message: String? = null) : UnKnownException(message)
    }
}