package com.aregama.ilfornos.fragments


import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.viewpager.widget.ViewPager

import com.aregama.ilfornos.R
import com.aregama.ilfornos.adapter.CustomPagerAdpter
import com.aregama.ilfornos.models.Images
import kotlinx.android.synthetic.main.fragment_about_restaurant.*
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class AboutRestaurantFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_restaurant, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val oneImage= Images("",R.drawable.about_restaurant)

        val imageList= mutableListOf<Images>()

        for(i in 1..5){
            imageList.add(oneImage)
        }

        val pageAdapter= CustomPagerAdpter(imageList)

        viewPagerAbout.adapter=pageAdapter

        val wm = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displayMetrics = DisplayMetrics()
        wm.defaultDisplay.getMetrics(displayMetrics)

        val width = displayMetrics.widthPixels
        var height = displayMetrics.heightPixels
        val pagerParams = viewPagerAbout.getLayoutParams()
        pagerParams.height=width/2

        viewPagerAbout.startAutoScroll()

        viewPagerAbout.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

                pageIndicatorAbout?.setSelected(position)

            }

        })
    }


    override fun onStop() {
        super.onStop()
        viewPagerAbout.stopAutoScroll()
    }


}
