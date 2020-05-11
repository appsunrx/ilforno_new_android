package com.aregama.ilfornos.fragments


import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.viewpager.widget.ViewPager
import com.aregama.ilfornos.R
import com.aregama.ilfornos.adapter.CustomPagerAdpter
import com.aregama.ilfornos.models.Images
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.restaurans_grid.*


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        enterLocationBtn.setOnClickListener (Navigation.createNavigateOnClickListener(R.id.toMap))




        setUpDealsPager()

        setUpRestaurants()






    }





    private fun setUpDealsPager(){
        val oneImage=Images("Кофе по акции -10%",R.drawable.coffe)


        val imageList= mutableListOf<Images>()

        for(i in 1..5){
            imageList.add(oneImage)
        }


        val pageAdapter= CustomPagerAdpter(imageList)

        viewPager.adapter=pageAdapter



        // set image height equel to device width

        val wm = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displayMetrics = DisplayMetrics()
        wm.defaultDisplay.getMetrics(displayMetrics)

        val width = displayMetrics.widthPixels
        var height = displayMetrics.heightPixels
        val pagerParams = viewPager.getLayoutParams()
        pagerParams.height=width/2


        viewPager.startAutoScroll()




        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

                    pageIndicator?.setSelected(position)

            }

        })



    }





    private fun setUpRestaurants(){


        craft.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toMap))

        steak.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toMap))

        limonchino.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toMap))


        ilforno.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toMap))

        burger.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toMap))

        cut.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toMap))

        fornetto.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toMap))



    }

    override fun onStop() {
        super.onStop()
        viewPager.stopAutoScroll()
    }




}
