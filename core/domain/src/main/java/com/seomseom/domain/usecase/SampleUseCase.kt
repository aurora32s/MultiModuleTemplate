package com.seomseom.domain.usecase

import com.seomseom.domain.repository.sample.SampleRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class SampleUseCase @Inject constructor(
    private val sampleRepository: SampleRepository
) {
    suspend operator fun invoke(): Result<List<String>> {
        return sampleRepository.get()
    }
}