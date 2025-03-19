package com.example.myrecyclerapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerapp.databinding.ItemCountryBinding

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    private var countries = listOf<Country>()

    class CountryViewHolder(private val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            binding.tvNameRegion.text = country.name + ", " + country.region
            binding.tvCode.text = country.code
            binding.tvCapital.text = country.capital
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount() = countries.size

    fun setCountries(newCountries: List<Country>) {
        countries = newCountries
        notifyDataSetChanged()
    }
}
