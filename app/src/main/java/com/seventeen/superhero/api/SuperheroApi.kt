package com.seventeen.superhero.api

import com.seventeen.superhero.data.SuperheroResponse
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface SuperheroApi {

    companion object {
        private const val access_token = "3974204582618528"
        const val BASE_URL = "https://superheroapi.com/api/${access_token}/"
    }

    @GET("search/1")
    suspend fun getSuperhero(): SuperheroResponse

}