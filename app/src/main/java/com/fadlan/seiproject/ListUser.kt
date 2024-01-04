package com.fadlan.seiproject

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fadlan.seiproject.Engine.NetworkService
import com.fadlan.seiproject.Model.User
import com.fadlan.seiproject.ShowData.Adapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_user)

        val listview = findViewById<ListView>(R.id.listview)

        NetworkService.apiData.getUserData().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val userList: List<User>? = response.body()
                    listview.adapter = userList?.let { Adapter(this@ListUser, it) }
                } else {
                    showToast("Gagal mendapatkan data pengguna")
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                showToast("Terjadi kesalahan: ${t.message}")
            }
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(this@ListUser, message, Toast.LENGTH_SHORT).show()
    }
}
