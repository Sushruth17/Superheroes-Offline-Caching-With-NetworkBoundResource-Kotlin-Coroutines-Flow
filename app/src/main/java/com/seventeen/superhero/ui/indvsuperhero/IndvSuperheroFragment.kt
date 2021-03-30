package com.seventeen.superhero.ui.indvsuperhero

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.seventeen.superhero.R
import com.seventeen.superhero.databinding.FragmentIndvSuperheroBinding

class IndvSuperheroFragment: Fragment(R.layout.fragment_indv_superhero) {

    private val args by navArgs<IndvSuperheroFragmentArgs>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentIndvSuperheroBinding.bind(view)

        binding.apply {
            Glide.with(this@IndvSuperheroFragment)
                .load(args.result.image?.url)
                .into(imv)
        }



    }


}