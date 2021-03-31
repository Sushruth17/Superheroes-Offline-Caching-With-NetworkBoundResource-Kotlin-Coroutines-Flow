package com.seventeen.superhero.ui.search

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.azoft.carousellayoutmanager.CarouselLayoutManager
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.azoft.carousellayoutmanager.CenterScrollListener
import com.seventeen.superhero.R
import com.seventeen.superhero.data.ResultsItem
import com.seventeen.superhero.databinding.FragmentSearchBinding
import com.seventeen.superhero.ui.home.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search), HomeAdapter.OnItemClickListener {

    private val searchViewModel: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentSearchBinding.bind(view)

        val homeAdapter = HomeAdapter(this)

        binding.apply {

            recyclerView.apply {
                adapter = homeAdapter
                val lm = CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL)
                layoutManager = lm
                addOnScrollListener(CenterScrollListener())
                lm.setPostLayoutListener(CarouselZoomPostLayoutListener())
            }

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    if (query != null) {
                        searchViewModel.name = query
                        searchViewModel.superheroes.observe(viewLifecycleOwner) { result ->
                            Log.i("test","result------${result}")
                            if (result.isNotEmpty())
                            homeAdapter.submitList(result)
                            homeAdapter.notifyDataSetChanged()

                            progressBar.isVisible = result.isNullOrEmpty()
                            textViewError.isVisible = result.isNullOrEmpty()
//                            textViewError.text =
                        }
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return true
                } })


        }

    }

    override fun onItemClick(result: ResultsItem) {
        val action = SearchFragmentDirections.actionNavigationDashboardToIndvSuperhero(result)
        findNavController().navigate(action)
    }

}