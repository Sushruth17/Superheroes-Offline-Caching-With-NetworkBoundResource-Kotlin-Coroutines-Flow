package com.seventeen.superhero.ui.indvsuperhero

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.seventeen.superhero.ui.indvsuperhero.tabs.AppearanceTab
import com.seventeen.superhero.ui.indvsuperhero.tabs.BiographyTab
import com.seventeen.superhero.ui.indvsuperhero.tabs.PowerstatsTab

@Suppress("DEPRECATION")
internal class IndvSuperheroAdapter(
    var context: Context?,
    fm: FragmentManager,
    var totalTabs: Int
    ) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                PowerstatsTab()
            }
            1 -> {
                AppearanceTab()
            }
            2 -> {
                BiographyTab()
            }
            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs
    }


}