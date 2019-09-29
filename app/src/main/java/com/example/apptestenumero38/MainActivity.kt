package com.example.apptestenumero38

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView_main.layoutManager = LinearLayoutManager(this)
        fechJson()
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this, cad_service_code::class.java)
            startActivity(intent)
        }
    }

    fun fechJson() {
        val url = "https://reqres.in/api/users?page=1"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()
                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                runOnUiThread {
                    myRecyclerView_main.adapter = MainAdapter(homeFeed)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Falha ao tentar executar a requisicao")
            }
        })
    }
}

class HomeFeed(val data: List<Dado>)
class Dado(val id: Int, val email: String, val first_name: String, val last_name: String, val avatar: String)