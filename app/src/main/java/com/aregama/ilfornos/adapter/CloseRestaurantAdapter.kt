package com.aregama.ilfornos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aregama.ilfornos.R
import com.aregama.ilfornos.models.Restaurant
import kotlinx.android.synthetic.main.restaurans_close_card_view.view.*


class CloseRestaurantAdapter(val restaurants: ArrayList<Restaurant>) : RecyclerView.Adapter<CloseRestaurantAdapter.ViewHolder>() {


    var onItemClick: ((Restaurant,View) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder (

        LayoutInflater.from(parent.context).inflate(R.layout.restaurans_close_card_view,parent,false)
    )


    override fun getItemCount(): Int {
       return restaurants.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindData(restaurants[position])

    }





    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val restaurantBg=itemView.restaurant_bg
        private val restaurant_logo=itemView.restaurant_logo
        private val distance=itemView.distanceText
        private val time=itemView.delivery_timeText

        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(restaurants[adapterPosition],itemView)
            }
        }



        fun bindData(restaurant: Restaurant){

            restaurantBg.setImageResource(restaurant.brandImage)
            restaurant_logo.setImageResource(restaurant.brandLogo)
            distance.text="${restaurant.distance} км"
            time.text="${restaurant.time} мин"

        }
    }
}