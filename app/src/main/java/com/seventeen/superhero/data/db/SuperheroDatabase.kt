package com.seventeen.superhero.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.seventeen.superhero.data.SuperheroResponse

@Database(entities = [SuperheroResponse::class], version = 1)
@TypeConverters(ResultConverter::class)
abstract class SuperheroDatabase : RoomDatabase() {
    abstract fun superheroDao(): SuperheroDao
}