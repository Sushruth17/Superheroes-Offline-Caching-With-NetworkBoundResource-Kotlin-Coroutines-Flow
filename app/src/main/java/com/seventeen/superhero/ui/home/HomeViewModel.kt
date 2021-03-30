package com.seventeen.superhero.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seventeen.superhero.api.SuperheroApi
import com.seventeen.superhero.data.SuperheroResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    api: SuperheroApi
): ViewModel() {

    private val superheroLiveData = MutableLiveData<SuperheroResponse>()
    val superheros: LiveData<SuperheroResponse> = superheroLiveData

    init {
        viewModelScope.launch {
            val superheros = api.getSuperhero()
            Log.i("test", "superheros-->$superheros")
            delay(2000)
            superheroLiveData.value = superheros
        }
    }
}