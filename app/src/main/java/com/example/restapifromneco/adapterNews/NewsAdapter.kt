package com.example.restapifromneco.adapterNews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restapifromneco.R
import com.example.restapifromneco.modelNews.NewsModel

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.ViewHolder>(){

    private var newsList = emptyList<NewsModel>()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var tvN_title : TextView = view.findViewById(R.id.tv_title)
        var tvN_descrp : TextView = view.findViewById(R.id.tv_descp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvN_title.text = newsList[position].title
        holder.tvN_descrp.text = newsList[position].descp
    }
    override fun getItemCount(): Int {
        return newsList.size
    }

    fun setNews(list: List<NewsModel>){
        newsList = list
    }
}