package com.example.apiintegration

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

      @GET("products")

    fun getproductdata(): Call<MyData>
}