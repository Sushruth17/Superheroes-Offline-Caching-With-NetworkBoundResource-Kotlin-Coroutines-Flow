package com.seventeen.superhero.ui.indvsuperhero.tabs

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import at.grabner.circleprogress.CircleProgressView
import com.seventeen.superhero.R
import com.seventeen.superhero.data.Powerstats
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
            setCircularProgressValues(cpvIntelligence, powerstats?.intelligence!!.toFloat())
            setCircularProgressValues(cpvStrength, powerstats.strength!!.toFloat())
            setCircularProgressValues(cpvSpeed, powerstats.speed!!.toFloat())
            setCircularProgressValues(cpvDurability, powerstats.durability!!.toFloat())
            setCircularProgressValues(cpvPower, powerstats.power!!.toFloat())
            setCircularProgressValues(cpvCombat, powerstats.combat!!.toFloat())
        }
    }

    private fun setCircularProgressValues(cpv: CircleProgressView, statsValue: Float){
        cpv.apply{
            setValueAnimated(10F, statsValue, 2000L)
            textSize = 30
            setTextColor(Color.BLACK)
        }
    }
}