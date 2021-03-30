package com.seventeen.superhero.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.seventeen.superhero.data.ResultsItem
import com.seventeen.superhero.data.SuperheroResponse
import com.seventeen.superhero.databinding.SuperheroItemBinding

class HomeAdapter : ListAdapter<SuperheroResponse, HomeAdapter.ViewHolder>(SuperheroComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            SuperheroItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem.results?.get(0))
        }
    }

    class ViewHolder(private val binding: SuperheroItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(superhero: ResultsItem?) {
            binding.apply {
                Glide.with(itemView)
                    .load(superhero?.image?.url)
                    .into(imageViewLogo)

                textViewName.text = superhero?.name
                textViewType.text = superhero?.id
                textViewAddress.text = superhero?.biography?.firstAppearance
            }
        }
    }

    class SuperheroComparator : DiffUtil.ItemCallback<SuperheroResponse>() {
        override fun areItemsTheSame(oldItem: SuperheroResponse, newItem: SuperheroResponse) =
            oldItem.resultsFor == newItem.resultsFor

        override fun areContentsTheSame(oldItem: SuperheroResponse, newItem: SuperheroResponse) =
            oldItem == newItem
    }
}