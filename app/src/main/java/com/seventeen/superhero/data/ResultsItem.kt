package com.seventeen.superhero.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultsItem(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("image")
	val image: Image? = null,

	@field:SerializedName("appearance")
	val appearance: Appearance? = null,

	@field:SerializedName("work")
	val work: Work? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("powerstats")
	val powerstats: Powerstats? = null,

	@field:SerializedName("biography")
	val biography: Biography? = null,

	@field:SerializedName("connections")
	val connections: Connections? = null
): Parcelable