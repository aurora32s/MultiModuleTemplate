package com.seomseom.data.datasource.sample

import com.seomseom.network.api.SampleApi
import com.seomseom.network.util.ApiCallUtil
import javax.inject.Inject

class DefaultSampleDatasource @Inject constructor(
    private val sampleApi: SampleApi
) : SampleDatasource {
    override suspend fun get(): Result<List<String>> {
        return runCatching {
            ApiCallUtil {
                sampleApi.getImagesInfo(
                    page = 1,
                    limit = 10
                )
            }.map { it.imageUrl }
        }
    }
}