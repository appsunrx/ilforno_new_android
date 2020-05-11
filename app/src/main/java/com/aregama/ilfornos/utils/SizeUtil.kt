package com.aregama.ilfornos.utils

import android.content.Context

class SizeUtil {

    companion object{
        fun Dp2Px(context: Context,dp:Int):Int=dp*context.resources.displayMetrics.density.toInt()
    }
}