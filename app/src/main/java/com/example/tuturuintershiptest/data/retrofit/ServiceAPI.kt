package com.example.tuturuintershiptest.data.retrofit

import com.example.tuturuintershiptest.domain.entities.Facts
import retrofit2.http.GET

interface ServiceAPI  {
    @GET("facts/random?animal_type=cat&amount=100")
    suspend fun getFacts(): Facts
}