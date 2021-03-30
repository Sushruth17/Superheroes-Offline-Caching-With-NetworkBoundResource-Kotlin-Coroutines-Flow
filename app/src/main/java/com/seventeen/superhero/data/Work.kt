package com.seventeen.superhero.data

import com.google.gson.annotations.SerializedName

data class Work(

	@field:SerializedName("occupation")
	val occupation: String? = null,

	@field:SerializedName("base")
	val base: String? = null
)