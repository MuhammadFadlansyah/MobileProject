package com.fadlan.seiproject.Engine

import com.fadlan.seiproject.Endpoint.ApiAdd
import com.fadlan.seiproject.Endpoint.ApiData
import com.fadlan.seiproject.Endpoint.ApiLogin
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    private const val BASE_URL = "http://192.168.1.8/projecttest/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiLogin: ApiLogin = retrofit.create(ApiLogin::class.java)
    val apiData: ApiData = retrofit.create(ApiData::class.java)
    val apiAdd: ApiAdd = retrofit.create(ApiAdd::class.java)
}
