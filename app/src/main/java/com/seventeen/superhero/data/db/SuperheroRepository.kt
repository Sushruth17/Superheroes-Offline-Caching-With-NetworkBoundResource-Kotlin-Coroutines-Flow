package com.seventeen.superhero.data.db

import android.util.Log
import androidx.room.withTransaction
import com.seventeen.superhero.api.SuperheroApi
import com.seventeen.superhero.data.SuperheroResponse
import com.seventeen.superhero.utils.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class SuperheroRepository @Inject constructor(
    private val api: SuperheroApi,
    private val db: SuperheroDatabase
) {
    private val superheroDao = db.superheroDao()
    private val superheroesList = mutableListOf<SuperheroResponse>()
    private val defaultList = arrayListOf(
        "batman", "ironman", "superman", "hulk", "captain america", "Black Panther", "Thor"
    )

    fun getSuperheroes() = networkBoundResource(
        query = {
            superheroDao.getAllSuperheroes()
        },
        fetch = {
            delay(2000)
            superheroesList.clear()
            for (i in defaultList) {
                val superhero = api.getSuperhero(i)
                superheroesList.add(superhero)
            }
        },
        saveFetchResult = {
            db.withTransaction {
                superheroDao.deleteAllSuperheroes()
                superheroDao.insertSuperheroes(superheroesList)
            }
        }
    )
}