package com.example.tuturuintershiptest.data

import com.example.tuturuintershiptest.domain.entities.Facts
import com.example.tuturuintershiptest.data.retrofit.RetrofitClient
import com.example.tuturuintershiptest.domain.repository.FactsRepository

class FactsRepositoryImpl: FactsRepository {
    override suspend fun getCatFacts(): Facts {
        return RetrofitClient.serviceAPI.getFacts()
    }
}