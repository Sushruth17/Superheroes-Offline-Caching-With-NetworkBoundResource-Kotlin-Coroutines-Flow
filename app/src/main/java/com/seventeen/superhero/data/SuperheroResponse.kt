package com.seventeen.superhero.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.seventeen.superhero.data.db.ResultConverter
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "superheroes")
data class SuperheroResponse(

	@PrimaryKey(autoGenerate = true)
	val id: Int = 0,

	@field:SerializedName("results-for")
	val resultsFor: String? = null,

	@field:SerializedName("response")
	val response: String? = null,

	@TypeConverters(ResultConverter::class)
	@field:SerializedName("results")
	var results: List<ResultsItem> = listOf()
): Parcelable