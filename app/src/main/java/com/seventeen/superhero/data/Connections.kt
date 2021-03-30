package com.seventeen.superhero.data

import com.google.gson.annotations.SerializedName

data class Connections(

	@field:SerializedName("relatives")
	val relatives: String? = null,

	@field:SerializedName("group-affiliation")
	val groupAffiliation: String? = null
)