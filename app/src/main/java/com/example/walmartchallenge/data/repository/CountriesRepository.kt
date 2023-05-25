package com.example.walmartchallenge.data.repository

import com.example.walmartchallenge.data.model.Countries
import retrofit2.Response

interface CountriesRepository {
    suspend fun getCountries(): Response<Countries>
}
