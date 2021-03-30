package com.seventeen.superhero.data

import com.google.gson.annotations.SerializedName

data class Powerstats(

	@field:SerializedName("strength")
	val strength: String? = null,

	@field:SerializedName("durability")
	val durability: String? = null,

	@field:SerializedName("combat")
	val combat: String? = null,

	@field:SerializedName("power")
	val power: String? = null,

	@field:SerializedName("speed")
	val speed: String? = null,

	@field:SerializedName("intelligence")
	val intelligence: String? = null
)