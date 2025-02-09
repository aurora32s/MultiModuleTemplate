package com.seomseom.network.ext

import com.seomseom.common.exception.NetworkStatusException
import com.seomseom.common.exception.NoneDataException
import retrofit2.Response

/**
 * Response에서 body 추출
 */
internal fun <T> Response<T>.getBodyOrThrow(): T {
    if (isSuccessful.not() || body() == null) throw NoneDataException()
    return body()!!
}

/**
 * Response의 Error Code와 Exception 관리
 */
internal fun <T> checkResponseIsSuccess(
    response: Response<T>
) {
    val message = response.message()
    val code = response.code()
    if (code != 200) {
        throw NetworkStatusException(
            statusMessage = message,
            code = code
        )
    }
}