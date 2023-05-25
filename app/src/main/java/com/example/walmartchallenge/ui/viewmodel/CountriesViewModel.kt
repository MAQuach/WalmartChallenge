package com.example.walmartchallenge.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walmartchallenge.data.model.Countries
import com.example.walmartchallenge.data.repository.CountriesRepository
import com.example.walmartchallenge.data.repository.CountriesRepositoryImpl
import com.example.walmartchallenge.util.UIState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountriesViewModel(
    private val countriesRepository: CountriesRepository = CountriesRepositoryImpl(),
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _response = MutableLiveData<UIState<Countries>>()
    val response: LiveData<UIState<Countries>>
        get() = _response

    init {
        getCountries()
    }

    /**
     * Fetch the API response and post to LiveData
     */
    private fun getCountries() {
        viewModelScope.launch(dispatcher) {
            _response.postValue(UIState.Loading)

            try {
                val response = countriesRepository.getCountries()

                if (response.isSuccessful) {
                    response.body()?.let {
                        _response.postValue(UIState.Success(it))
                    } ?: throw Exception("Response is null")

                } else {
                    throw Exception(response.errorBody()?.string())
                }

            } catch (e: Exception) {
                _response.postValue(UIState.Error(e))
            }
        }
    }
}
