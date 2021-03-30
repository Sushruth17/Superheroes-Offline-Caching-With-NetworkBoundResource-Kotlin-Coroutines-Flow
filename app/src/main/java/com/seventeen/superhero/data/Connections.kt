package com.seventeen.superhero.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Connections(

	@field:SerializedName("relatives")
	val relatives: String? = null,

	@field:SerializedName("group-affiliation")
	val groupAffiliation: String? = null
): Parcelable