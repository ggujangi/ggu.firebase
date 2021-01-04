package com.ggu.firebase.data

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
data class Result<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): Result<T> =
            Result(status = Status.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): Result<T> =
            Result(status = Status.ERROR, data = data, message = message)

        fun <T> loading(data: T?): Result<T> =
            Result(status = Status.LOADING, data = data, message = null)
    }
}