package com.kg.sampleproject

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

object BindingAdapter {

    @BindingAdapter( value = ["dividerDirection","dividerMarginLeft",
        "dividerMarginRight", "noMarginForLastDivider"],
        requireAll = false)
    @JvmStatic
   fun itemDecorator( view: RecyclerView, dividerDirection: Int = 0, dividerMarginLeft: Int = 0,
                           dividerMarginRight: Int = 0 , noMarginForLastDivider: Boolean = false) {

        if (dividerDirection == DividerItemDecoration.HORIZONTAL) {
            val divider = DividerItemDecorator(view.context, dividerMarginLeft,
                dividerMarginRight, noMarginForLastDivider)
            view.addItemDecoration(divider)
        }
    }

}