package com.seomseom.network.util

import com.seomseom.network.ext.checkResponseIsSuccess
import com.seomseom.network.ext.getBodyOrThrow
import retrofit2.Response

/**
 * API 호출 및 Response 검증 Util
 */
object ApiCallUtil {
    suspend operator fun <T> invoke(
        action: suspend () -> Response<T>
    ): T {
        // 1. Response 코드 검사
        val response = action()
        checkResponseIsSuccess(response)
        // 2. Body 검사
        return response.getBodyOrThrow()
    }
}