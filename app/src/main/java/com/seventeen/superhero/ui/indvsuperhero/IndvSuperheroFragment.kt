package com.seventeen.superhero.ui.indvsuperhero

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.seventeen.superhero.R
import com.seventeen.superhero.databinding.FragmentIndvSuperheroBinding


class IndvSuperheroFragment: Fragment(R.layout.fragment_indv_superhero) {

    private val args by navArgs<IndvSuperheroFragmentArgs>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentIndvSuperheroBinding.bind(view)

        (activity as AppCompatActivity?)!!.supportActionBar!!.title = args.result.name


        binding.apply {
            Glide.with(this@IndvSuperheroFragment)
                .load(args.result.image?.url)
                .into(imv)


            tabLayout.apply {
                addTab(tabLayout.newTab().setText("Appearance"))
                addTab(tabLayout.newTab().setText("Power Stats"))
                addTab(tabLayout.newTab().setText("Biography"))
                tabGravity = TabLayout.GRAVITY_FILL
            }

            val fragmentManager = (activity as FragmentActivity).supportFragmentManager
            val adapter = IndvSuperheroAdapter(requireContext(), fragmentManager,
                tabLayout.tabCount)
            viewPager.adapter = adapter
            viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
            tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    viewPager.currentItem = tab.position
                }
                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })

        }



    }


}