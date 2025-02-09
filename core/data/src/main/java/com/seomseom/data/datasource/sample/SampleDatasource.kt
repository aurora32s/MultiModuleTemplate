package com.seomseom.data.datasource.sample

interface SampleDatasource {
    suspend fun get(): Result<List<String>>
}