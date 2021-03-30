package com.seventeen.superhero.ui.indvsuperhero.tabs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.seventeen.superhero.R
import com.seventeen.superhero.databinding.FragmentBiographyTabBinding
import com.seventeen.superhero.databinding.FragmentPowerstatsTabBinding
import com.seventeen.superhero.ui.indvsuperhero.IndvSuperheroFragmentArgs
import com.seventeen.superhero.utils.UtilsString

class PowerstatsTab : Fragment(R.layout.fragment_powerstats_tab)  {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentPowerstatsTabBinding.bind(view)

        val powerstats = UtilsString.superheroData?.powerstats

        binding.apply {
            intelligence.text = "Intelligence: ${powerstats?.intelligence}"
            strength.text = "Strength: ${powerstats?.strength}"
            speed.text = "Speed: ${powerstats?.speed}"
            durability.text = "Durability: ${powerstats?.durability}"
            power.text = "power: ${powerstats?.power}"
            combat.text = "Combat: ${powerstats?.combat}"

        }
    }
}