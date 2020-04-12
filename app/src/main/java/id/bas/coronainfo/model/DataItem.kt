package id.bas.coronainfo.model

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("meninggal")
	val meninggal: Int? = null,

	@field:SerializedName("data_tambahan")
	val dataTambahan: String? = null,

	@field:SerializedName("positif")
	val positif: Int? = null,

	@field:SerializedName("sembuh")
	val sembuh: Int? = null,

	@field:SerializedName("tanggal")
	val tanggal: String? = null
)