package com.seventeen.superhero.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.seventeen.superhero.data.db.SuperheroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: SuperheroRepository
): ViewModel() {

    val superheroes = repository.getSuperheroes().asLiveData()


/*    private val superheroLiveData = MutableLiveData<List<SuperheroResponse>>()
    val superheroes: LiveData<List<SuperheroResponse>> = superheroLiveData
    private val superherosList = mutableListOf<SuperheroResponse>()


    private val defaultList = arrayListOf(
        "batman", "ironman", "superman", "hulk", "captain america", "Black Panther"
    )

    init {
        viewModelScope.launch {
            for (i in defaultList) {
                val superheros = api.getSuperhero(i)
                Log.i("test", "superheros-->$superheros")
                delay(2000)
                superherosList.add(superheros)
                superheroLiveData.value = superherosList
            }
        }
    }*/
}