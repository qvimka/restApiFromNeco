package com.example.restapifromneco.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.restapifromneco.adapterNews.NewsAdapter
import com.example.restapifromneco.databinding.ActivityMain2Binding
import com.example.restapifromneco.modelNews.NewsModel
import android.util.Log



class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding
    lateinit var adapter: NewsAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initialNews()
    }

    private fun initialNews(){
        recyclerView = binding.rvViewNews
        adapter = NewsAdapter()
        recyclerView.adapter = adapter
        adapter.setNews(myNews())
    }

    fun myNews(): ArrayList<NewsModel>{
        val newsList = ArrayList<NewsModel>()
        val news = NewsModel("Очистка пруда", "Приходите все")
        newsList.add(news)
        val news2 = NewsModel("Лучшая защита - нападение", "Приходите все")
        newsList.add(news2)
        val news3 = NewsModel("Как мы убираем мусор?", "Приходите все")
        newsList.add(news3)
        return  newsList
    }
    fun clicktoAPI(view: View) {
        Log.d("TAGIS", "MeYOU!")
        val intent2 = Intent(this@MainActivity2, MainActivityProductApi::class.java)
        startActivity(intent2)
    }
}