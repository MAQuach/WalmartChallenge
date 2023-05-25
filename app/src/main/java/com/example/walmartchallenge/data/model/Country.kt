package com.example.walmartchallenge.data.model

import com.google.gson.annotations.SerializedName

/**
 * The data structure that the API returns a list of
 */
data class Country(

    @SerializedName("capital")
    val capital: String? = null,

    @SerializedName("code")
    val code: String? = null,

    @SerializedName("currency")
    val currency: Currency? = null,

    @SerializedName("flag")
    val flag: String? = null,

    @SerializedName("language")
    val language: Language? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("region")
    val region: String? = null,

    @SerializedName("demonym")
    val demonym: String? = null
)
