package com.brotandos.koatlib

import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation

/**
 * @author: Brotandos
 * @date: 22.02.2018.
 */
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


inline operator fun <T: View> T.invoke(init: T.() -> Unit): T {
    this.init()
    return this
}

inline fun <T: View> T.params(init: T.() -> Unit): T {
    this.init()
    return this
}

inline infix fun <T: View> T.style(init: T.() -> Unit): T {
    this.init()
    return this
}