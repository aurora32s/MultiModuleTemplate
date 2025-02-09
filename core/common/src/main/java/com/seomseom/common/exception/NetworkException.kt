package com.seomseom.common.exception

/**
 * 네트워크와 관련된 Custom Exception
 */
class NoneDataException : Exception()

/**
 * 400 / 500 / 600 대 에러 발생
 */
class NetworkStatusException(
    val statusMessage: String,
    val code: Int
) : Exception()