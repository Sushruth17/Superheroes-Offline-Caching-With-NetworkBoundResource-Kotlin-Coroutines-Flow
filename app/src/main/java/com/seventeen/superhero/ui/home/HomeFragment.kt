package com.seventeen.superhero.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.azoft.carousellayoutmanager.CarouselLayoutManager
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.azoft.carousellayoutmanager.CenterScrollListener
import com.seventeen.superhero.R
import com.seventeen.superhero.data.ResultsItem
import com.seventeen.superhero.data.SuperheroResponse
import com.seventeen.superhero.databinding.FragmentHomeBinding
import com.seventeen.superhero.utils.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), HomeAdapter.OnItemClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeBinding.bind(view)
        val homeAdapter = HomeAdapter(this)

        binding.apply {
            recyclerView.apply {
                adapter = homeAdapter
                val lm = CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL)
                layoutManager = lm
                addOnScrollListener(CenterScrollListener())
                lm.setPostLayoutListener(CarouselZoomPostLayoutListener())
            }


            homeViewModel.superheroes.observe(viewLifecycleOwner) { result ->
                Log.i("test","result------${result.data}")
                homeAdapter.submitList(result.data)
                homeAdapter.notifyDataSetChanged()

                progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                textViewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                textViewError.text = result.error?.localizedMessage
            }

        }
    }

    override fun onItemClick(result: ResultsItem) {
        val action = HomeFragmentDirections.actionNavigationHomeToIndvSuperhero(result)
        findNavController().navigate(action)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}