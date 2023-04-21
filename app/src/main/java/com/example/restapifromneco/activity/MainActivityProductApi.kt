package com.example.restapifromneco.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restapifromneco.databinding.ActivityMain3Binding
import com.example.restapifromneco.retrofit.Api
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityProductApi : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breeds/image/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        binding.button4.setOnClickListener {
            val api = retrofit.create(Api::class.java)
            CoroutineScope(Dispatchers.IO).launch {
                val product = api.getApi()
                runOnUiThread {
                    binding.textView2.text = product.status
                    Picasso.get().load(product.message).into(binding.imageView)
                }
            }
        }
    }
}