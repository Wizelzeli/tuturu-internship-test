package com.example.tuturuintershiptest.domain.repository

import com.example.tuturuintershiptest.domain.entities.Facts

interface FactsRepository {
    suspend fun getCatFacts(): Facts
}