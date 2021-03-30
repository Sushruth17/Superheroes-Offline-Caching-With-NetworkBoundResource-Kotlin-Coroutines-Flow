package com.seventeen.superhero.ui.indvsuperhero.tabs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.seventeen.superhero.R
import com.seventeen.superhero.databinding.FragmentAppearanceTabBinding
import com.seventeen.superhero.ui.indvsuperhero.IndvSuperheroFragmentArgs
import com.seventeen.superhero.utils.UtilsString

class AppearanceTab : Fragment(R.layout.fragment_appearance_tab)  {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentAppearanceTabBinding.bind(view)

        val appearance = UtilsString.superheroData?.appearance

        binding.apply {
            gender.text = "Gender: ${appearance?.gender}"
            race.text = "Race: ${appearance?.race}"
            height.text = "Height: ${appearance?.height?.get(0).toString()}"
            weight.text = "Weight: ${appearance?.weight?.get(0).toString()}"
            hairColor.text = "Hair Color: ${appearance?.hairColor}"
            eyeColor.text = "Eye Color: ${appearance?.eyeColor}"
        }
    }
}