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

    private val superherosList = mutableListOf<SuperheroResponse>()

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

            progressBar.visibility = View.VISIBLE

            homeViewModel.superheros.observe(viewLifecycleOwner) { result ->
                Log.i("test","result------$result")
//                if (result != null)
//                    superherosList.add(result)
                homeAdapter.submitList(result)
                homeAdapter.notifyDataSetChanged()

                progressBar.visibility = View.GONE

//                progressBar.isVisible = result is Resource.Loading<*> && result.isNullOrEmpty()
//                textViewError.isVisible = result is Resource.Error<*> && result.isNullOrEmpty()
//                textViewError.text = result.error.localizedMessage
            }

        }
//        val rv = getView()?.findViewById<RecyclerView>(R.id.recycler_view)
//        rv?.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
//        rv?.adapter = homeAdapter




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