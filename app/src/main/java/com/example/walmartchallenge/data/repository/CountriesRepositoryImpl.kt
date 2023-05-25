package com.example.walmartchallenge.data.repository

import com.example.walmartchallenge.data.model.Countries
import com.example.walmartchallenge.data.network.CountriesDelegate
import com.example.walmartchallenge.data.network.CountriesNetworkModule
import retrofit2.Response

class CountriesRepositoryImpl(
    private val countriesDelegate: CountriesDelegate = CountriesNetworkModule.countriesDelegate
) : CountriesRepository {

    override suspend fun getCountries(): Response<Countries> =
        countriesDelegate.getCountries()
}
