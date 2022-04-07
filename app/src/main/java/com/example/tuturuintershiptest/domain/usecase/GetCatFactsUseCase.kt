package com.example.tuturuintershiptest.domain.usecase

import com.example.tuturuintershiptest.data.FactsRepositoryImpl
import com.example.tuturuintershiptest.domain.entities.Facts

class GetCatFactsUseCase {
    suspend fun execute(): Facts {
        val factsRepositoryImpl = FactsRepositoryImpl()
        return factsRepositoryImpl.getCatFacts()
    }
}