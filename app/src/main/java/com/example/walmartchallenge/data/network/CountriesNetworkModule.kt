package com.example.walmartchallenge.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CountriesNetworkModule {

    val countriesDelegate: CountriesDelegate by lazy {
        initRetrofit()
    }

    /**
     * @return Built Retrofit for the countries API
     */
    private fun initRetrofit(): CountriesDelegate {
        return Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/")
            .client(createOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountriesDelegate::class.java)
    }

    /**
     * @return Built OkHttp client with BODY logging
     */
    private fun createOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }
}
