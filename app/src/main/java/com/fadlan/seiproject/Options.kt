package com.fadlan.seiproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Options : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

        val lihatUserButton = findViewById<Button>(R.id.lihatuser)
        val tambahUserButton = findViewById<Button>(R.id.tambahuser)

        lihatUserButton.setOnClickListener {
            val intent = Intent(this@Options, ListUser::class.java)
            startActivity(intent)
        }

        tambahUserButton.setOnClickListener {
            val intent = Intent(this@Options, AddUser::class.java)
            startActivity(intent)
        }
    }
}
