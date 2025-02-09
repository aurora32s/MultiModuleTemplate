package com.seomseom.data.di

import com.seomseom.data.datasource.sample.DefaultSampleDatasource
import com.seomseom.data.datasource.sample.SampleDatasource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DatasourceModule {
    @Binds
    @Singleton
    fun bindSampleDatasource(
        sampleDatasource: DefaultSampleDatasource
    ): SampleDatasource
}