package com.aregama.ilfornos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aregama.ilfornos.R
import com.aregama.ilfornos.models.Food
import kotlinx.android.synthetic.main.inner_food_item.view.*

class MenuItemAdapter (val foodList: ArrayList<Food>) : RecyclerView.Adapter<MenuItemAdapter.ViewHolder>() {


    var onItemClick: ((Food, View) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.inner_food_item, parent, false)
    )


    override fun getItemCount() = foodList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(foodList[position])
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val foodImage = itemView.innerFoodImage
        private val foodText = itemView.innerFoodText
        private val foodprice = itemView.innerFoodPrice

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(foodList[adapterPosition],itemView)
            }
        }

        fun bindData(food: Food) {
            foodImage.setImageResource(food.image)
            foodText.text = food.name
            foodprice.text = "${food.price} \u20BD"
        }

    }



}