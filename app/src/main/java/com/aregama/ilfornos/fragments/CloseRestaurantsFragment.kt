package com.aregama.ilfornos.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.aregama.ilfornos.R
import com.aregama.ilfornos.adapter.CloseRestaurantAdapter
import com.aregama.ilfornos.models.Restaurant
import com.aregama.ilfornos.utils.RecyclerDivider
import kotlinx.android.synthetic.main.fragment_close_restaurants.*

/**
 * A simple [Fragment] subclass.
 */
class CloseRestaurantsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_close_restaurants, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val restaurant= Restaurant(1,"Craft",R.drawable.ic_craft,R.drawable.craft_bg,35,45.toDouble())
        val restaurants= mutableListOf<Restaurant>()

        for(i in 1..5){
            restaurants.add(restaurant)
        }

        val adapter= CloseRestaurantAdapter(ArrayList(restaurants))

        rv_close_restorants.layoutManager= LinearLayoutManager(context)
        rv_close_restorants.adapter=adapter
        rv_close_restorants.addItemDecoration(RecyclerDivider.customDivider(context!!))




        adapter.onItemClick={res, v ->

          v.findNavController().navigate(R.id.toRestaurantMenu)

        }




    }


}
