package com.aregama.ilfornos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aregama.ilfornos.R
import com.aregama.ilfornos.models.Restaurant
import kotlinx.android.synthetic.main.restaurants_card_view.view.*

class RestaurantsAdapter (val restaurants: List<Restaurant>) : RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>(){


    var onItemClick: ((Restaurant,View) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder (

        LayoutInflater.from(parent.context).inflate(R.layout.restaurants_card_view,parent,false)
    )


    override fun getItemCount(): Int {
        return restaurants.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindData(restaurants[position])

    }





    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val restaurantBg=itemView.restorant_bg_img
        private val restaurant_logo=itemView.restorant_logo_img
        private val restorant_sub_title=itemView.restorant_subtitle


        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(restaurants[adapterPosition],itemView)
            }
        }



        fun bindData(restaurant: Restaurant){

            restaurantBg.setImageResource(restaurant.brandImage)
            restaurant_logo.setImageResource(restaurant.brandLogo)

            restorant_sub_title.text=restaurant.title


        }
    }
}