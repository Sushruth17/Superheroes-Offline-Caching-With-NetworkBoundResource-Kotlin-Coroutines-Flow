package com.seventeen.superhero.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SuperheroResponse(

	@field:SerializedName("results-for")
	val resultsFor: String? = null,

	@field:SerializedName("response")
	val response: String? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null
): Parcelable