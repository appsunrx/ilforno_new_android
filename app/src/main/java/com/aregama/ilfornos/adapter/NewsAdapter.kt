package com.aregama.ilfornos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aregama.ilfornos.R
import com.aregama.ilfornos.models.News
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(val newsList:List<News>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    var onItemClick: ((News) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder (

        LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
    )

    override fun getItemCount()=newsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(newsList[position])
    }



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private  val newsBg=itemView.newsImage
        private val newsLogo=itemView.newsLogo
        private val newsTitle=itemView.newsText
        private val newsDate=itemView.newsDate

        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(newsList[adapterPosition])
            }
        }


        fun bindData(news:News){

            newsBg.setImageResource(news.image)
            newsLogo.setImageResource(news.logo)
            newsTitle.text=news.title
            newsDate.text=news.date
        }
    }
}