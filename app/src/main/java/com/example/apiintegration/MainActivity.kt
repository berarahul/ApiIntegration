package com.example.apiintegration

import android.annotation.SuppressLint
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter
    @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerview)

     val retrofitBuilder=Retrofit.Builder()
     .baseUrl("https://dummyjson.com/")
     .addConverterFactory(GsonConverterFactory.create())
     .build()
     .create(ApiInterface::class.java)

        val retrofitdata=retrofitBuilder.getproductdata()

          // ctrl+shift space press
        retrofitdata.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {

              // if api call is a success then you use the data of API and show in your app

                var responcebody=response.body()
                      var productlist=responcebody?.products!!
              myAdapter= MyAdapter(this@MainActivity,productlist)
                recyclerView.adapter=myAdapter
                recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)

            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {

            // if API call fails
                Log.d("main acticitiy","onFailure"+t.message)

            }
        })
    }
}