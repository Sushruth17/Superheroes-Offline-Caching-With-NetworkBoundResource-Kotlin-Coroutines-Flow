package com.seventeen.superhero.ui.indvsuperhero.tabs

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import at.grabner.circleprogress.CircleProgressView
import com.seventeen.superhero.R
import com.seventeen.superhero.databinding.FragmentPowerstatsTabBinding
import com.seventeen.superhero.ui.indvsuperhero.IndvSuperheroFragmentArgs
import com.seventeen.superhero.utils.UtilsString

class PowerstatsTab : Fragment(R.layout.fragment_powerstats_tab)  {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentPowerstatsTabBinding.bind(view)

        val powerstats = UtilsString.superheroData?.powerstats

        binding.apply {
            intelligence.text = "Intelligence: ${powerstats?.intelligence}"
            strength.text = "Strength: ${powerstats?.strength}"
            speed.text = "Speed: ${powerstats?.speed}"
            durability.text = "Durability: ${powerstats?.durability}"
            power.text = "Power: ${powerstats?.power}"
            combat.text = "Combat: ${powerstats?.combat}"

            circularView.maxValue = 100F
            circularView.setValueAnimated(
                    0F, powerstats?.intelligence!!.toFloat(),
                    2000L)
            circularView.setText("intell")
            circularView.isAutoTextSize = true
            circularView.setTextColorAuto(true)
            circularView.transitionName = "adhsjhd"

        }
    }
}