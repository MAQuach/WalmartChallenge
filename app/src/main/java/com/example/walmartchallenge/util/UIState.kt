package com.example.walmartchallenge.util

import com.example.walmartchallenge.data.model.Countries

sealed class UIState<Countries> {
    object Loading : UIState<Countries>()
    data class Success<Countries>(val data: Countries) : UIState<Countries>()
    data class Error(val error: Exception) : UIState<Countries>()
}
