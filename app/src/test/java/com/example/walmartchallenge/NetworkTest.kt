package com.example.walmartchallenge

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test

import java.net.URL

class CustomizedNetworkClientTest {

    @ExperimentalCoroutinesApi
    @ObsoleteCoroutinesApi
    @Test
    fun test() {
        runBlocking {
            val url = URL(
                "https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json"
            )
            val json = url.readText()
            print(json)
        }
    }
}
