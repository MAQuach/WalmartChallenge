package com.example.walmartchallenge.data.network

import com.example.walmartchallenge.data.model.Countries
import retrofit2.Response
import retrofit2.http.GET

// https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json

interface CountriesDelegate {
    @GET("peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json")
    suspend fun getCountries(): Response<Countries>
}
