package id.bas.coronainfo

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.bas.coronainfo.model.ResponseInsert
import kotlinx.android.synthetic.main.activity_post_data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostDataActivity : AppCompatActivity() {

    val BASEURL ="https://script.google.com/macros/s/AKfycbz6gzLBW3982bKdnqo8YuSrvaWDfLJrxdkXzuAsBus-oSqlxm8j/"
    var positif = ""
    var sembuh = ""
    var meninggal = ""
    var progressDialog : ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_data)

        btn_simpan.setOnClickListener {
             positif = edt_positif.text.toString()
             sembuh = edt_sembuh.text.toString()
             meninggal = edt_meninggal.text.toString()
            if(positif.isEmpty() || sembuh.isEmpty() || meninggal.isEmpty()){
                Toast.makeText(this@PostDataActivity,"Data tidak bisa kosong", Toast.LENGTH_LONG).show()
            } else {
                progressDialog = ProgressDialog(this)
                progressDialog?.setTitle("Loading")
                progressDialog?.show()
                postData()
            }
        }

    }

    private fun postData() {

        ApiRetrofit.create(BASEURL).postData("register","corona",positif,meninggal,sembuh)
            .enqueue(object : Callback<ResponseInsert> {
                override fun onFailure(call: Call<ResponseInsert>, t: Throwable) {
                    Toast.makeText(this@PostDataActivity,"GAGAL Insert", Toast.LENGTH_LONG).show()
                    progressDialog?.dismiss()
                }

                override fun onResponse(
                    call: Call<ResponseInsert>,
                    response: Response<ResponseInsert>
                ) {

                    if(response.isSuccessful){
                        edt_meninggal.setText("")
                        edt_positif.setText("")
                        edt_sembuh.setText("")

                        progressDialog?.dismiss()
                        Toast.makeText(this@PostDataActivity,"BERHASIL Insert", Toast.LENGTH_LONG).show()
                    }
                }
            })
    }
}
