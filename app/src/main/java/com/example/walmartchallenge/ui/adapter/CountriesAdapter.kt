package com.example.walmartchallenge.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.walmartchallenge.data.model.Country
import com.example.walmartchallenge.databinding.ListItemCountryBinding

class CountriesAdapter(
    private val countryList: MutableList<Country> = mutableListOf()
) : RecyclerView.Adapter<CountriesViewHolder>() {

    /**
     * Replace RecyclerView with newCountries
     */
    fun updateCountries(newCountries: List<Country>) {
        countryList.clear()
        countryList.addAll(newCountries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CountriesViewHolder(
        ListItemCountryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = countryList.size

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.setup(countryList[position])
    }
}

class CountriesViewHolder(private val binding: ListItemCountryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun setup(country: Country) {
        binding.countryRegionTextview.text =
            "${country.name}, ${country.region}"
        binding.countryCodeTextview.text = country.code
        binding.countryCapitalTextview.text = country.capital
    }
}
