package com.seomseom.network.api

import com.seomseom.network.model.response.SampleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SampleApi {
    /**
     * 이미지 리스트 요청
     * @param page 페이지 번호
     * @param limit 페이지 당 이미지 개수
     */
    @GET("v2/list")
    suspend fun getImagesInfo(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<List<SampleResponse>>
}