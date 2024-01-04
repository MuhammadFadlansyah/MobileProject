package com.fadlan.seiproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.fadlan.seiproject.Engine.NetworkService
import com.fadlan.seiproject.Login.LoginData
import com.fadlan.seiproject.Login.LoginRespons
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.btnlogin)
        val unameEditText = findViewById<EditText>(R.id.username)
        val passEditText = findViewById<EditText>(R.id.password)

        btnLogin.setOnClickListener {
            val unameText = unameEditText.text.toString().trim()
            val passText = passEditText.text.toString().trim()

            if (unameText.isEmpty() || passText.isEmpty()) {
                Toast.makeText(this@MainActivity, "Username and Password are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val loginData = LoginData(unameText, passText)

            // Melakukan permintaan login menggunakan Retrofit
            NetworkService.apiLogin.userLogin(loginData).enqueue(object : Callback<LoginRespons> {
                override fun onResponse(call: Call<LoginRespons>, response: Response<LoginRespons>) {
                    if (response.isSuccessful) {
                        val loginResponse = response.body()
                        if (loginResponse != null) {
                            if (!loginResponse.error) {
                                // Login berhasil, Anda dapat melakukan tindakan sesuai di sini (misalnya, navigasi ke layar berikutnya)
                                // Contoh:
                                Toast.makeText(this@MainActivity, "Login Successful", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this@MainActivity, Options::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                // Login gagal, tampilkan pesan kesalahan
                                Toast.makeText(this@MainActivity, loginResponse.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    } else {
                        // Tidak berhasil terhubung ke server atau respons tidak berhasil
                        Toast.makeText(this@MainActivity, "Failed to connect", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<LoginRespons>, t: Throwable) {
                    // Gagal melakukan permintaan ke server
                    Toast.makeText(this@MainActivity, "Error: " + t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
