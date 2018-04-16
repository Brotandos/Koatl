package com.brotandos.koatlib

import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation

/**
 * @author: Brotandos
 * @date: 22.02.2018.
 */
fun ViewGroup.createView(init: KoatlContext<ViewGroup>.() -> Unit)
        = com.brotandos.koatlib.KoatlContextImpl(context, this, false).apply(init).view


inline operator fun <T: View> T.times(block: T.() -> Unit): T {
    block()
    return this
}


inline operator fun <T: ViewGroup.LayoutParams> T.times(block: T.() -> Unit): T {
    block()
    return this
}


inline operator fun <T: Animation> T.times(block: T.() -> Unit): T {
    block()
    return this
}


inline operator fun <T: Drawable> T.times(block: T.() -> Unit) : T {
    block()
    return this
}


inline operator fun <E: View> List<E>.times(block: E.() -> Unit) = forEach { it * block }


inline operator fun <E: View> Sequence<E>.times(block: E.() -> Unit) = forEach { it * block }