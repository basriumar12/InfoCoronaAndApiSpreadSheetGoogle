package id.bas.coronainfo

import id.bas.coronainfo.model.ResponseCorona
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("exec")
    fun getDataCorona (@Query("id") id : String,
                       @Query("sheet") sheet : String
                       )
                : Call<ResponseCorona>
}