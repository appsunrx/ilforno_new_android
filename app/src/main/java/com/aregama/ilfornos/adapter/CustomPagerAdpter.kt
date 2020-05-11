package com.aregama.ilfornos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.aregama.ilfornos.R
import com.aregama.ilfornos.models.Images
import com.squareup.picasso.Picasso

class CustomPagerAdpter(private val images:List<Images>) : PagerAdapter() {



    override fun isViewFromObject(view: View, `object`: Any): Boolean {


        return view===`object` as View
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view =
            LayoutInflater.from(container.context).inflate(R.layout.pages_layout,container,false)

        val image: ImageView =view.findViewById(R.id.page_img)
        val text: TextView =view.findViewById(R.id.pageText)

        Picasso.get().load(images.get(position).image).into(image)






        text.text=images.get(position).title



        container.addView(view)


        return view
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }



    override fun getCount(): Int {

        return  images.size
    }
}