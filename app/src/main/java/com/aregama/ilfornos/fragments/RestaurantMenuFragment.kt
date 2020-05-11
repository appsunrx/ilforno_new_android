package com.aregama.ilfornos.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.aregama.ilfornos.R
import com.aregama.ilfornos.adapter.RestaurantAdapter
import com.aregama.ilfornos.models.Food
import com.aregama.ilfornos.utils.RecyclerDivider
import kotlinx.android.synthetic.main.fragment_restaurant_menu.*
import kotlinx.android.synthetic.main.fragment_restaurants.*

/**
 * A simple [Fragment] subclass.
 */
class RestaurantMenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant_menu, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val food= Food(R.drawable.burgers,"Бургеры")

        val foodList= mutableListOf<Food>()

        for(i in 1..5){
            foodList.add(food)
        }

        val adapter= RestaurantAdapter(ArrayList(foodList))


        rvRestaurantMenu.layoutManager= LinearLayoutManager(context)
        rvRestaurantMenu.adapter=adapter

        rvRestaurantMenu.addItemDecoration(RecyclerDivider.customDivider(context!!))

        adapter.onItemClick={f,v->
            v.findNavController().navigate(R.id.toMenuItem)

        }

        about_restaurant.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toAboutRestaurant))




    }


}
