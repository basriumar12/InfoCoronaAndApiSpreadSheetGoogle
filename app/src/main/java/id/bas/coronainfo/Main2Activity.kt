//package id.bas.coronainfo
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.widget.Toast
//import id.bas.coronainfo.model.ResponseCorona
//import kotlinx.android.synthetic.main.activity_main.*
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class Main2Activity : AppCompatActivity() {
//
//    var id = "1EvpbuSl7rXFiD1th3Rru5PqHcHrk7AS0Y5L3LT8yZtw"
//    var sheet = "corona"
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        getData()
//    }
//
//    private fun getData() {
//        ApiRetrofit.create(BASE).getDataCorona(id,sheet).enqueue(object : Callback<ResponseCorona>{
//            override fun onFailure(call: Call<ResponseCorona>, t: Throwable) {
//                //untuk response error
//
//                Toast.makeText(this@Main2Activity,"Error dapatkan data", Toast.LENGTH_LONG).show()
//            }
//
//            override fun onResponse(
//                call: Call<ResponseCorona>,
//                response: Response<ResponseCorona>
//            ) {
//                if (response.isSuccessful){
//                    tv_positif.text = "Data Positif :"+response.body()?.data?.get(0)?.positif.toString()
//                    tv_meninggal.text =  "Data Meninggal :"+response.body()?.data?.get(0)?.meninggal.toString()
//                    tv_sembuh.text =  "Data Sembuh :"+response.body()?.data?.get(0)?.sembuh.toString()
//                }
//
//            }
//        })
//    }
//}
