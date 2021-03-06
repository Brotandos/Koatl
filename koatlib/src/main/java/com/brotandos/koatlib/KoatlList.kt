package com.brotandos.koatlib

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.animation.AnimationUtils
import android.view.animation.GridLayoutAnimationController
import android.view.animation.LayoutAnimationController
import android.widget.FrameLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.wrapContent

/**
 * @author: Brotandos
 * @date: 22.02.2018.
 */
val linear: RecyclerView.() -> Unit = {
    layoutManager = LinearLayoutManager(context)
}

/**
 * WARNING, must be called after layout manager set
 * */
val itemPrefetchDisabled: RecyclerView.() -> Unit = {
    layoutManager.isItemPrefetchEnabled = false
}

/**
 * Animation setting functions
 * */
fun anim(a: LayoutAnimationController): RecyclerView.() -> Unit = {
    layoutAnimation = a
}

fun anim(resId: Int): RecyclerView.() -> Unit = {
    layoutAnimation = AnimationUtils.loadLayoutAnimation(context, resId)
}


class GridList : RecyclerView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {}

    override fun attachLayoutAnimationParameters(child: View, params: ViewGroup.LayoutParams,
                                                 index: Int, count: Int) {
        val layoutManager = layoutManager
        if (adapter != null && layoutManager is GridLayoutManager) {
            val animationParams =
                    if (params.layoutAnimationParameters == null) GridLayoutAnimationController.AnimationParameters()
                    else params.layoutAnimationParameters as GridLayoutAnimationController.AnimationParameters

            params.layoutAnimationParameters = animationParams

            // Next we are updating the parameters

            // Set the number of result in the RecyclerView and the tagIndex of this item
            animationParams.count = count
            animationParams.index = index

            // Calculate the number of columns and rows in the grid
            val columns = layoutManager.spanCount
            animationParams.columnsCount = columns
            animationParams.rowsCount = count / columns

            // Calculate the column/row position in the grid
            val invertedIndex = count - 1 - index
            animationParams.column = columns - 1 - invertedIndex % columns
            animationParams.row = animationParams.rowsCount - 1 - invertedIndex / columns

        } else {
            // Proceed as normal if using another type of LayoutManager
            super.attachLayoutAnimationParameters(child, params, index, count)
        }
    }
}