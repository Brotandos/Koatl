package com.brotandos.koatlib

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.graphics.drawable.StateListDrawable
import android.os.Build
import android.view.ViewGroup
import android.widget.CompoundButton

open class StateListDrawableBuilder(private val defaultDrawable: Drawable, private val resources: Resources) {

    constructor(defaultDrawableId: Int, resources: Resources) : this(
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                resources.getDrawable(defaultDrawableId, null)
            else
                resources.getDrawable(defaultDrawableId),
            resources)

    private val stateListDrawable = StateListDrawable()

    operator fun Int.get(vararg states: Int) {
        stateListDrawable.addState (
                intArrayOf(*states),
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    resources.getDrawable(this, null)
                else
                    resources.getDrawable(this)
        )
    }

    operator fun Drawable.get(vararg states: Int) {
        stateListDrawable.addState(intArrayOf(*states), this)
    }

    fun build(): StateListDrawable {
        stateListDrawable.addState(intArrayOf(), defaultDrawable)
        return stateListDrawable
    }
}

fun CompoundButton.stateListDrawable(defaultDrawable: Drawable, init: StateListDrawableBuilder.() -> Unit): StateListDrawable {
    val stateListDrawableBuilder = StateListDrawableBuilder(defaultDrawable, resources)
    stateListDrawableBuilder.init()
    return stateListDrawableBuilder.build()
}

fun CompoundButton.stateListDrawable(defaultDrawableId: Int, init: StateListDrawableBuilder.() -> Unit): StateListDrawable {
    val stateListDrawableBuilder = StateListDrawableBuilder(defaultDrawableId, resources)
    stateListDrawableBuilder.init()
    return stateListDrawableBuilder.build()
}

fun ViewGroup.stateListDrawable(defaultDrawable: Drawable, init: StateListDrawableBuilder.() -> Unit): StateListDrawable {
    val stateListDrawableBuilder = StateListDrawableBuilder(defaultDrawable, resources)
    stateListDrawableBuilder.init()
    return stateListDrawableBuilder.build()
}

fun ViewGroup.stateListDrawable(defaultDrawableId: Int, init: StateListDrawableBuilder.() -> Unit): StateListDrawable {
    val stateListDrawableBuilder = StateListDrawableBuilder(defaultDrawableId, resources)
    stateListDrawableBuilder.init()
    return stateListDrawableBuilder.build()
}