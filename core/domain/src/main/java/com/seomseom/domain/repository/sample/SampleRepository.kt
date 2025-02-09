package com.seomseom.domain.repository.sample

interface SampleRepository {
    suspend fun get(): Result<List<String>>
}