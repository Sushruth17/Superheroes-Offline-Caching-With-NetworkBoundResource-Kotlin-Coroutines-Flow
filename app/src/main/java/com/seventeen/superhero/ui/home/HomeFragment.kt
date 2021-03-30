package com.seventeen.superhero.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.seventeen.superhero.R
import com.seventeen.superhero.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentHomeBinding.inflate(layoutInflater)
        val homeAdapter = HomeAdapter()

//        binding.apply {
//            recyclerView.apply {
//                layoutManager = LinearLayoutManager(activity)
//                adapter = homeAdapter
//            }
//        }
        val rv = getView()?.findViewById<RecyclerView>(R.id.recycler_view)
        rv?.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rv?.adapter = homeAdapter


        homeViewModel.superheros.observe(viewLifecycleOwner) { superheros ->
            homeAdapter.submitList(listOf(superheros))
        }

    }
}