package id.bas.coronainfo.model

import com.google.gson.annotations.SerializedName

data class ResponseCorona(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)