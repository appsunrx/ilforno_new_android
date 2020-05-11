package com.aregama.ilfornos.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.aregama.ilfornos.R
import com.aregama.ilfornos.adapter.RestaurantsAdapter
import com.aregama.ilfornos.models.Restaurant
import com.aregama.ilfornos.utils.RecyclerDivider
import kotlinx.android.synthetic.main.fragment_restaurants.*

/**
 * A simple [Fragment] subclass.
 */
class RestaurantsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurants, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setUpRestaurants()


    }


    private fun setUpRestaurants(){

        val res1= Restaurant(1,getString(R.string.craft_bottom),R.drawable.ic_craft,R.drawable.craft_h)
        val res2=Restaurant(2,getString(R.string.steak_bottom),R.drawable.ic_steak,R.drawable.steak_h)
        val res3=Restaurant(3,getString(R.string.limonchino_bottom),R.drawable.limonchino,R.drawable.limonchino_h)
        val res4=Restaurant(4,getString(R.string.ilforno_bottom),R.drawable.ic_ilforno,R.drawable.ilforno_h)
        val res5=Restaurant(5,getString(R.string.burger_bottom),R.drawable.ic_burger,R.drawable.burger_h)
        val res6=Restaurant(6,getString(R.string.cut_bottom),R.drawable.cut,R.drawable.craft_h)
        val res7=Restaurant(7,getString(R.string.cut_bottom),R.drawable.ic_fornetto,R.drawable.steak_h)

        val restaurants= listOf(res1,res2,res3,res4,res5,res6,res7)

        val adapter=RestaurantsAdapter(restaurants )

        rvRestaurants.layoutManager=LinearLayoutManager(context)
        rvRestaurants.adapter=adapter
        rvRestaurants.addItemDecoration(RecyclerDivider.customDivider(context!!))

        adapter.onItemClick={res,v->
            v.findNavController().navigate(R.id.toRestaurantMenu)

        }


    }


}
