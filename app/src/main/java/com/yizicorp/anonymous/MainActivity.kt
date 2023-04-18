package com.yizicorp.anonymous

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {


    var data = ArrayList<Products>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val rcylr = findViewById<RecyclerView>(R.id.rcylr)


        rcylr.layoutManager = LinearLayoutManager(this)


        gtallproduct()
    }

    private fun gtallproduct() {
        val rcylr = findViewById<RecyclerView>(R.id.rcylr)

        val retrofit = Servicebuilder.buildService(ServiceInterface::class.java)

        retrofit.getAllproducts().enqueue(object : retrofit2.Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                try {

                    // to avoid nulpointerException
                    val responseBody = response.body()!!
                    data= responseBody.products

                    var adapter = ProductAdapter(data)
                    rcylr.adapter = adapter





                }
                catch (ex : java.lang.Exception){
                    ex.printStackTrace()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("Failed","Api Failed"+ t.message)
            }

        })
    }
}