package id.bas.coronainfo

import id.bas.coronainfo.model.ResponseCorona
import id.bas.coronainfo.model.ResponseInsert
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {


    @GET("exec")
    fun getDataCorona (@Query("id") id : String,
                       @Query("sheet") sheet : String
                       )
                : Call<ResponseCorona>


    @POST("exec")
    fun postData (
        @Query("action")action : String,
        @Query("sheetName")sheetName : String,
        @Query("positif")positif : String,
        @Query("meninggal")meninggal : String,
        @Query("sembuh")sembuh : String

    ) : Call<ResponseInsert>
}