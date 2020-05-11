package com.aregama.ilfornos.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aregama.ilfornos.R
import com.aregama.ilfornos.models.Restaurant
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.AlignSelf
import com.google.android.flexbox.FlexboxLayoutManager
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.main_meu_item.view.*
import java.lang.Exception

class MainMenuAdapter (val restaurantList: List< Restaurant>) : RecyclerView.Adapter<MainMenuAdapter.ViewHolder>() {



    var onItemClick: ((Restaurant) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.main_meu_item,parent,false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bindData(restaurantList[position])
    }

    override fun getItemCount()=restaurantList.size



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val restaurantText=itemView.main_menu_text
        private val restaurantBg=itemView.main_menu_bg
        private val restaurantLogo=itemView.main_menu_logo

        private  val cardView=itemView.mainMenuCard


        init {

            val params=itemView.layoutParams

            if(params is FlexboxLayoutManager.LayoutParams){
                val flexboxLp=params
                flexboxLp.flexGrow=1.0f
                flexboxLp.alignSelf= AlignItems.CENTER

            }





            cardView.setOnClickListener{
                onItemClick?.invoke(restaurantList[adapterPosition])
            }
        }


        fun bindData(restaurant: Restaurant){

            restaurantText.text=restaurant.title

            restaurantLogo.setImageResource(restaurant.brandLogo)
            restaurantBg.setImageResource(restaurant.brandImage)




        }

    }




}