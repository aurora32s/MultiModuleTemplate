package com.seomseom.multiModuleTemplate.di

import com.seomseom.multiModuleTemplate.navigator.SampleNavigator
import com.seomseom.ui.navigator.Navigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {
    @Binds
    @Singleton
    fun bindSampleNavigator(
        navigator: SampleNavigator
    ): Navigator
}