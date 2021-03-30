package com.seventeen.superhero.di

import android.app.Application
import androidx.room.Room
import com.seventeen.superhero.api.SuperheroApi
import com.seventeen.superhero.data.db.SuperheroDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(SuperheroApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideSuperheroApi(retrofit: Retrofit): SuperheroApi =
        retrofit.create(SuperheroApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : SuperheroDatabase =
        Room.databaseBuilder(app, SuperheroDatabase::class.java, "restaurant_database")
            .build()
}

