package com.brotandos.koatlib

import android.content.Context
import android.support.design.widget.NavigationView
import android.support.v4.content.res.ResourcesCompat
import android.view.View
import android.view.animation.Animation
import android.widget.*
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import org.jetbrains.anko.AlertBuilder
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream

/**
 * @author: Brotandos
 * @date: 26.02.2018.
 */
val fitSystemWindow: NavigationView.() -> Unit = {
    fitsSystemWindows = true
}

val ImageView.resourceId: Int
    get() {
        val field = javaClass.getDeclaredField("mResource")
        field.isAccessible = true
        return field.getInt(this)
    }

fun animationListener (
        onStart: ((Animation?) -> Unit)? = null,
        onRepeat: ((Animation?) -> Unit)? = null,
        onEnd: ((Animation?) -> Unit)? = null
) = object : Animation.AnimationListener {
    override fun onAnimationStart(animation: Animation?) { if (onStart != null) onStart(animation) }
    override fun onAnimationRepeat(animation: Animation?) { if (onRepeat != null) onRepeat(animation) }
    override fun onAnimationEnd(animation: Animation?) { if (onEnd != null) onEnd(animation) }
}

fun BufferedInputStream.getString() : String {
    val bos = ByteArrayOutputStream()
    var i = this.read()
    while (i != -1) {
        bos.write(i)
        i = this.read()
    }
    return bos.toString()
}

inline val EditText.textVal: String get() = text.toString()


fun BottomNavigationViewEx.setItemStateColor(resId: Int) {
    val colorStateList = ResourcesCompat.getColorStateList(resources, resId, null)
    itemIconTintList = colorStateList
    itemTextColor = colorStateList
}


operator fun <T: Adapter> AdapterView.OnItemSelectedListener.invoke(): AdapterView<T>.() -> Unit = {
    onItemSelectedListener = this@invoke
}


fun AlertBuilder<*>.customKoatlView(dsl: KoatlContext<Context>.() -> Unit) {
    customView = ctx.KUI(dsl)
}

/**
 * Advice: use this, if view is inside recyclerView and has onClickListener property.
 * TODO add use example link
 * */
val View.tagIndex: Int get() = tag as Int


fun View.setVisible() {
    visibility = View.VISIBLE
}

fun View.setInvisiblle() {
    visibility = View.INVISIBLE
}

fun View.hide() {
    visibility = View.GONE
}