package com.seventeen.superhero.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.seventeen.superhero.data.SuperheroResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface SuperheroDao {

    @Query("SELECT * FROM superheroes")
    fun getAllSuperheroes(): Flow<List<SuperheroResponse>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSuperheroes(superheroes: List<SuperheroResponse>)

    @Query("DELETE FROM superheroes")
    suspend fun deleteAllSuperheroes()
}