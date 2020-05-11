package com.aregama.ilfornos.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.aregama.ilfornos.R
import com.aregama.ilfornos.adapter.NewsAdapter
import com.aregama.ilfornos.models.News
import kotlinx.android.synthetic.main.fragment_news.*

/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val news= News(1,"В Москве прошла выставк кофейной индустрии","","24 октября",R.drawable.burgers,R.drawable.ic_craft)
        val newsList= mutableListOf<News>()

        for(i in 1..5){
            newsList.add(news)
        }

        val adapter= NewsAdapter(newsList)

        rvNews.layoutManager= LinearLayoutManager(context)
        rvNews.adapter=adapter

        adapter.onItemClick={

        }
    }


}
