package com.fadlan.seiproject.Endpoint

import com.fadlan.seiproject.Login.LoginData
import com.fadlan.seiproject.Login.LoginRespons
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiLogin {
    @POST("postlogin.php")
    fun userLogin(@Body loginData: LoginData): Call<LoginRespons>
}
