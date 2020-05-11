package com.aregama.ilfornos.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aregama.ilfornos.R
import com.aregama.ilfornos.adapter.MenuItemAdapter
import com.aregama.ilfornos.models.Food
import com.aregama.ilfornos.utils.RecyclerDivider
import kotlinx.android.synthetic.main.fragment_menu_item.*

/**
 * A simple [Fragment] subclass.
 */
class MenuItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_item, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val food= Food(R.drawable.burgers,"Бургеры",100)
        val foodList= mutableListOf<Food>()

        for(i in 1..5){
            foodList.add(food)
        }



        val adapter=MenuItemAdapter(ArrayList(foodList))

        rvInnerFood.layoutManager= LinearLayoutManager(context)
        rvInnerFood.adapter=adapter

        rvInnerFood.addItemDecoration(RecyclerDivider.customDivider(context!!))

        adapter.onItemClick={f,v->
            v.findNavController().navigate(R.id.toAddToCart)
        }

    }


}
