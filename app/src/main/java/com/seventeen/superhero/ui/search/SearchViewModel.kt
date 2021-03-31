package com.seventeen.superhero.ui.search

import android.util.Log
import androidx.lifecycle.*
import com.seventeen.superhero.api.SuperheroApi
import com.seventeen.superhero.data.SuperheroResponse
import com.seventeen.superhero.data.db.SuperheroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    api: SuperheroApi
): ViewModel(){

    var name = ""
    private val superheroLiveData = MutableLiveData<List<SuperheroResponse>>()
    val superheroes: LiveData<List<SuperheroResponse>> = superheroLiveData

    init {
        viewModelScope.launch {
            Log.i("name", "name---->$name")
            val superheroes = api.getSuperhero(name)
            delay(2000)
            superheroLiveData.value = listOf(superheroes)
        }
    }

}