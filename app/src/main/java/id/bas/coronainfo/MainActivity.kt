package id.bas.coronainfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import id.bas.coronainfo.model.ResponseCorona
import id.bas.coronainfo.model.ResponseGetById
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val BASEURL ="https://script.google.com/macros/s/AKfycbzctxBEOf7kp94IBYM0GVQOmIYVgAiTScj_6iKh9ITGh8m2MRLp/"


    var id = "1EvpbuSl7rXFiD1th3Rru5PqHcHrk7AS0Y5L3LT8yZtw"
    var sheet = "corona"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      getDataById()
    }

    private fun getDataById() {
        progress_circular.visibility = View.VISIBLE
        ApiRetrofit.create(BASEURL).getDataById("id","corona","4").enqueue(
            object : Callback<ResponseGetById>{
                override fun onFailure(call: Call<ResponseGetById>, t: Throwable) {
                    progress_circular.visibility = View.GONE
                    Toast.makeText(this@MainActivity,"Gagal terima data",Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<ResponseGetById>,
                    response: Response<ResponseGetById>
                ) {
                    progress_circular.visibility = View.GONE
                    Toast.makeText(this@MainActivity,
                        "Berhasil terima data ${response.body()?.positif}",Toast.LENGTH_LONG).show()
                }
            }
        )
    }

    private fun getData() {
        ApiRetrofit.create(BASEURL).getDataCorona(id,sheet).enqueue(object : Callback<ResponseCorona>{
            override fun onFailure(call: Call<ResponseCorona>, t: Throwable) {
                //untuk response error

                Toast.makeText(this@MainActivity,"Error dapatkan data", Toast.LENGTH_LONG).show()
            }
            override fun onResponse(
                call: Call<ResponseCorona>,
                response: Response<ResponseCorona>
            ) {
                if (response.isSuccessful){
                    tv_positif.text = "Data Positif :"+response.body()?.data?.get(0)?.positif.toString()
                    tv_meninggal.text =  "Data Meninggal :"+response.body()?.data?.get(0)?.meninggal.toString()
                    tv_sembuh.text =  "Data Sembuh :"+response.body()?.data?.get(0)?.sembuh.toString()
                }
                
            }
        })
    }
}
