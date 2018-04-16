package com.brotandos.koatlib

import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import org.jetbrains.anko.wrapContent

/**
 * @author: Brotandos
 * @date: 23.02.2018.
 */
val content5: LinearLayout.() -> Unit = {
    gravity = Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL
}

val content456: LinearLayout.() -> Unit = {
    gravity = Gravity.CENTER_VERTICAL
}

val content258: LinearLayout.() -> Unit = {
    gravity = Gravity.CENTER_HORIZONTAL
}

val horizontal: LinearLayout.() -> Unit = {
    orientation = LinearLayout.HORIZONTAL
}

val vertical: LinearLayout.() -> Unit = {
    orientation = LinearLayout.VERTICAL
}

fun <T: View> T.llp(vararg inits: LinearLayout.LayoutParams.() -> Unit) : T {
    layoutParams = LinearLayout.LayoutParams(wrapContent, wrapContent).apply {
        for (init in inits) init()
    }
    return this
}

fun <T: View> T.llp (
        vararg inits: LinearLayout.LayoutParams.() -> Unit,
        additionalInit: LinearLayout.LayoutParams.() -> Unit
) : T {
    layoutParams = LinearLayout.LayoutParams(wrapContent, wrapContent).apply {
        for (init in inits) init()
        additionalInit()
    }
    return this
}