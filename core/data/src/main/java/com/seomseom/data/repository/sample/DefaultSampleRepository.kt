package com.seomseom.data.repository.sample

import com.seomseom.data.datasource.sample.SampleDatasource
import com.seomseom.domain.repository.sample.SampleRepository
import javax.inject.Inject

class DefaultSampleRepository @Inject constructor(
    private val sampleDatasource: SampleDatasource
) : SampleRepository {
    override suspend fun get(): Result<List<String>> {
        return sampleDatasource.get()
    }
}