package com.aregama.ilfornos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aregama.ilfornos.R
import com.aregama.ilfornos.models.Food
import kotlinx.android.synthetic.main.restaurant_menu_item.view.*

class RestaurantAdapter(val foodList: ArrayList<Food>) : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {



    var onItemClick: ((Food,View) -> Unit)? = null




    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val foodImage=itemView.menuItemImage
        private val foodText=itemView.menuItemText

        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(foodList[adapterPosition],itemView)
            }
        }

        fun bindData(food: Food){
            foodImage.setImageResource(food.image)
            foodText.text=food.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.restaurant_menu_item,parent,false)
    )


    override fun getItemCount()=foodList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(foodList[position])
    }
}