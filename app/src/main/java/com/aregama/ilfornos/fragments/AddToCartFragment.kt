package com.aregama.ilfornos.fragments


import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.aregama.ilfornos.R
import kotlinx.android.synthetic.main.fragment_add_to_cart.*

/**
 * A simple [Fragment] subclass.
 */
class AddToCartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_to_cart, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var counter=0


        counter_plus.setOnClickListener {
            counterText.text="${++counter}"
            slideToBottom(counterText)
        }



        counter_minus.setOnClickListener {
            counterText.apply {
                counter--
                if(counter<0) counter=0
                counterText.text="${counter}"
                slideToTop(counterText)
            }
        }
    }


    private fun slideToBottom(view: View){

        val anim=
            ObjectAnimator.ofFloat(view,View.TRANSLATION_Y,-parcelCounterLayout.height.toFloat(),0.toFloat())
        anim.duration=300
        anim.start()


    }


    private fun slideToTop(view:View){
        val anim=
            ObjectAnimator.ofFloat(view,View.TRANSLATION_Y,parcelCounterLayout.height.toFloat(),0.toFloat())
        anim.duration=300
        anim.start()
    }


}
