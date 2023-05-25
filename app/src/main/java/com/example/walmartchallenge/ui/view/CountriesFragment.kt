package com.example.walmartchallenge.ui.view

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walmartchallenge.databinding.FragmentCountriesBinding
import com.example.walmartchallenge.ui.adapter.CountriesAdapter
import com.example.walmartchallenge.ui.viewmodel.CountriesViewModel
import com.example.walmartchallenge.util.UIState

class CountriesFragment : Fragment() {

    private lateinit var binding: FragmentCountriesBinding

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[CountriesViewModel::class.java]
    }

    private val countriesAdapter by lazy {
        CountriesAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCountriesBinding.inflate(inflater, container, false)
        // Configure the RecyclerView
        binding.countriesRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
        }

        // Observe UIState and respond appropriately
        viewModel.response.observe(viewLifecycleOwner) {
            when (it) {
                is UIState.Loading -> {
                    Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT)
                        .show()
                }

                is UIState.Success -> {
                    countriesAdapter.updateCountries(it.data)
                }

                is UIState.Error -> {
                    AlertDialog.Builder(requireActivity())
                        .setTitle("Oops! Error encountered!")
                        .setMessage(it.error.localizedMessage)
                        .setNegativeButton("DISMISS") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .create()
                        .show()
                }
            }
        }

        return binding.root
    }
}
