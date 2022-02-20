package com.kg.sampleproject

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class DividerItemDecorator(context: Context, private val marginLeft: Int,
                           private val marginRight: Int, private val noMarginForLastDivider: Boolean)  :
    RecyclerView.ItemDecoration() {

    private val mDivider: Drawable = ContextCompat.getDrawable(context, R.drawable.recycler_divider)!!


    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {

        //since our values is in dp we have to convert it into pixel
        // by multiplying dp value with density
        val density = parent.context.resources.displayMetrics.density

        //scale is in float but left,right,top and bottom should be int type
        //so we have to convert it into int.
        var left = parent.paddingLeft + (marginLeft * density).toInt()
        var right = parent.width - parent.paddingRight - (marginRight * density ).toInt()

        val childCount = parent.childCount
        for (i in 0 until childCount) {

            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + mDivider.getIntrinsicHeight()

            if(noMarginForLastDivider && i==childCount-1){
                left = parent.paddingLeft
                right= parent.width - parent.paddingRight
            }

            mDivider.setBounds(left, top, right, bottom)
            mDivider.draw(c)
        }
    }
}