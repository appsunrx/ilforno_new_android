package com.aregama.ilfornos.views

import android.graphics.Rect
import android.view.View
import androidx.appcompat.widget.ViewUtils
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GridSpanDecoration(val padding:Int): RecyclerView.ItemDecoration() {


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)


        val gridLayoutManager=parent.layoutManager as GridLayoutManager

        val spanCount=gridLayoutManager.spanCount

        val params=view.layoutParams as GridLayoutManager.LayoutParams

        val spanIndex=params.spanIndex
        val spanSize=params.spanSize

        if(spanIndex==0){
            outRect.left=padding
        } else{
            outRect.right=padding/2
        }

        outRect.top=padding/2
        outRect.bottom=padding/2

        if(isLayoutRT(parent)){
            val temp=outRect.left
            outRect.left=outRect.right
            outRect.right=temp
        }

    }



    private companion object{
        fun  isLayoutRT (parent:RecyclerView)=parent.layoutDirection==ViewCompat.LAYOUT_DIRECTION_RTL
    }


}