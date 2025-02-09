package com.seomseom.data.di

import com.seomseom.data.repository.sample.DefaultSampleRepository
import com.seomseom.domain.repository.sample.SampleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindSampleRepository(
        sampleRepository: DefaultSampleRepository
    ): SampleRepository
}