package com.seventeen.superhero.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(

	@field:SerializedName("url")
	val url: String? = null
): Parcelable