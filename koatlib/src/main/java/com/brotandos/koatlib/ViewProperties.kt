package com.brotandos.koatlib

import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import org.jetbrains.anko.backgroundResource
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.wrapContent

/**
 * @author: Brotandos
 * @date: 23.02.2018.
 */

val visible: View.() -> Unit = {
    visibility = View.VISIBLE
}

val invisible: View.() -> Unit = {
    visibility = View.INVISIBLE
}

val hidden: View.() -> Unit = {
    visibility = View.GONE
}

val enabled: View.() -> Unit = {
    isEnabled = true
}

val disabled: View.() -> Unit = {
    isEnabled = false
}

val clickable: View.() -> Unit = {
    isClickable = true
}

val unclickable: View.() -> Unit = {
    isClickable = false
}

val checked: CompoundButton.() -> Unit = {
    isChecked = true
}

val unchecked: CompoundButton.() -> Unit = {
    isChecked = false
}

val ww: View.() -> Unit = {
    layoutParams = ViewGroup.LayoutParams(wrapContent, wrapContent)
}

val wm: View.() -> Unit = {
    layoutParams = ViewGroup.LayoutParams(wrapContent, matchParent)
}

val mw: View.() -> Unit = {
    layoutParams = ViewGroup.LayoutParams(matchParent, wrapContent)
}

val mm: View.() -> Unit = {
    layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)
}

/**
 * Advice: use this, if view is inside recyclerView and has onClickListener property.
 * TODO add use example link
 * */
val View.tagIndex: Int get() = tag as Int

/**
 * 'bg' stands for 'background'
 * */
fun bg(res: Int): View.() -> Unit = {
    backgroundResource = res
}

/**
 * Listeners setting functions
 * */
operator fun View.OnClickListener.invoke(): View.() -> Unit = {
    setOnClickListener(this@invoke)
}

operator fun View.OnFocusChangeListener.invoke(): View.() -> Unit = {
    onFocusChangeListener = this@invoke
}

operator fun View.OnTouchListener.invoke(): View.() -> Unit = {
    setOnTouchListener(this@invoke)
}

operator fun Int.invoke(): View.() -> Unit = {
    id = this@invoke
}

fun tag(t: Any): View.() -> Unit = {
    tag = t
}

operator fun Drawable.invoke(): View.() -> Unit = {
    background = this@invoke
}

/**
 * Padding settings functions
 * 'p' stands for 'padding'
 * 'c' stands for 'coefficient'
 * */
fun p(c: Int): View.() -> Unit = {
    setPadding(c, c, c, c)
}

fun p(h: Int, v: Int): View.() -> Unit = {
    setPadding(h, v, h, v)
}

fun p(l: Int, t: Int, r: Int, b: Int): View.() -> Unit = {
    setPadding(l, t, r, b)
}

fun pLeft(c: Int): View.() -> Unit = {
    setPadding(c, paddingTop, paddingRight, paddingBottom)
}

fun pTop(c: Int): View.() -> Unit = {
    setPadding(paddingLeft, c, paddingRight, paddingBottom)
}

fun pRight(c: Int): View.() -> Unit = {
    setPadding(paddingLeft, paddingTop, c, paddingBottom)
}

fun pBottom(c: Int): View.() -> Unit = {
    setPadding(paddingLeft, paddingTop, paddingRight, c)
}

fun pHorizontal(c: Int): View.() -> Unit = {
    setPadding(c, paddingTop, c, paddingBottom)
}

fun pVertical(c: Int): View.() -> Unit = {
    setPadding(paddingLeft, c, paddingRight, c)
}