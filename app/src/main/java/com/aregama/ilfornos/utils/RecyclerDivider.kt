package com.aregama.ilfornos.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.aregama.ilfornos.R

class RecyclerDivider {

    companion object{
        fun customDivider(context: Context): DividerItemDecoration{
            val dividerItemDecoration=DividerItemDecoration(context,DividerItemDecoration.VERTICAL)

            val drawable=ContextCompat.getDrawable(context,R.drawable.list_divider)
            dividerItemDecoration.setDrawable(drawable!!)

            return dividerItemDecoration
        }
    }
}