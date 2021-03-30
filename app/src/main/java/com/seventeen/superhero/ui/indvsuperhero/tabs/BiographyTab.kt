package com.seventeen.superhero.ui.indvsuperhero.tabs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.seventeen.superhero.R
import com.seventeen.superhero.databinding.FragmentAppearanceTabBinding
import com.seventeen.superhero.databinding.FragmentBiographyTabBinding
import com.seventeen.superhero.ui.indvsuperhero.IndvSuperheroFragmentArgs
import com.seventeen.superhero.utils.UtilsString

class BiographyTab : Fragment(R.layout.fragment_biography_tab)  {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentBiographyTabBinding.bind(view)

        val biography = UtilsString.superheroData?.biography

        binding.apply {
            fullName.text = "Full Name: ${biography?.fullName}"
            alterEgos.text = "Alter Egos: ${biography?.alterEgos}"
            aliases.text = "Aliases: ${biography?.aliases}"
            placeOfBirth.text = "Place of birth: ${biography?.placeOfBirth}"
            firstAppearance.text = "First Appearance: ${biography?.firstAppearance}"
            publisher.text = "Publisher: ${biography?.publisher}"
        }
    }
}