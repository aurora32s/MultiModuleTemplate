package com.seomseom.network.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * network module 의 이미지 정보 Response
 */
@Serializable
data class SampleResponse(
    val id: String, // 이미지 id
    val author: String, // 이미지 창작자 명
    val width: Int, // 이미지 가로 길이
    val height: Int, // 이미지 세로 길이
    @SerialName("download_url")
    val imageUrl: String // 이미지 URL
)