package com.seventeen.superhero.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Work(

	@field:SerializedName("occupation")
	val occupation: String? = null,

	@field:SerializedName("base")
	val base: String? = null
): Parcelable