package com.brotandos.koatlib

import android.content.Context
import android.support.v4.widget.DrawerLayout
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import android.widget.*
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.support.v4._DrawerLayout

/**
 * @author: Brotandos
 * @date: 22.02.2018.
 */

/*
    inline val g1: .LayoutParams.() -> Unit
        get() = { gravity = Gravity.START or Gravity.TOP }
    inline val g2: .LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP }
    inline val g3: .LayoutParams.() -> Unit
        get() = { gravity = Gravity.END or Gravity.TOP }
    inline val g4: .LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL or Gravity.START}
    inline val g5: .LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL }
    inline val g6: .LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL or Gravity.END }
    inline val g7: .LayoutParams.() -> Unit
        get() = { gravity = Gravity.START or Gravity.BOTTOM }
    inline val g8: .LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM }
    inline val g9: .LayoutParams.() -> Unit
        get() = { gravity = Gravity.END or Gravity.BOTTOM }
    inline val g123: .LayoutParams.() -> Unit
        get() = { gravity = Gravity.TOP }
    inline val g147: .LayoutParams.() -> Unit
        get() = { gravity = Gravity.START }
    inline val g258: .LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_HORIZONTAL }
    inline val g456: .LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL }
    inline val g369: .LayoutParams.() -> Unit
        get() = { gravity = Gravity.END }
    inline val g789: .LayoutParams.() -> Unit
        get() = { gravity = Gravity.BOTTOM }
    inline val submissive: .LayoutParams.() -> Unit
        get() = { width = wrapContent; height = wrapContent }
    inline val row: .LayoutParams.() -> Unit
        get() = { width = matchParent; height = wrapContent }
    inline val column: .LayoutParams.() -> Unit
        get() = { width = wrapContent; height = matchParent }
    inline val dominant: .LayoutParams.() -> Unit
        get() = { width = matchParent; height = matchParent }

    /**
     * Margin setting functions
     * 'm' stands for 'margin'
     * 't' stands for 'top'
     * 'l' stands for 'left'
     * 'r' stands for 'right'
     * 'b' stands for 'bottom'
     * 'e' stands for 'end'
     * 's' stands for 'start'
     * 'c' stands for 'coefficient'
     * */

    fun m(l: Int, t: Int, r: Int, b: Int): .LayoutParams.() -> Unit = {
        setMargins(l, t, r, b)
    }
    fun m(c: Int): .LayoutParams.() -> Unit = {
        setMargins(c, c, c, c)
    }
    fun m(h: Int, v: Int): .LayoutParams.() -> Unit = {
        setMargins(h, v, h, v)
    }
    fun mHorizontal(c: Int): .LayoutParams.() -> Unit = {
        marginStart = c
        marginEnd = c
    }
    fun mVertical(c: Int): .LayoutParams.() -> Unit = {
        topMargin = c
        bottomMargin = c
    }
    fun top(c: Int): .LayoutParams.() -> Unit = {
        topMargin = c
    }
    fun bottom(c: Int): .LayoutParams.() -> Unit = {
        bottomMargin = c
    }
    fun start(c: Int): .LayoutParams.() -> Unit = {
        marginStart = c
    }
    fun end(c: Int): .LayoutParams.() -> Unit = {
        marginEnd = c
    }

    fun <T: View> T.lp(vararg params: .LayoutParams.() -> Unit) : T {
        layoutParams = .LayoutParams(wrapContent, wrapContent).apply {
            for (param in params) param()
        }
        return this
    }

    /**
     * You will able to write functions like this (just example):
     * `lp(row) { margin = dip(10) }` instead of this `lp(row, { margin = dip(10) })`
     * */
    fun <T: View> T.lp (
            vararg params: .LayoutParams.() -> Unit,
            init: .LayoutParams.() -> Unit
    ): T {
        layoutParams = .LayoutParams(wrapContent, wrapContent).apply {
            for (param in params) param()
            init()
        }
        return this
    }
*/

/**
 * ViewGroup extensions
 * */
fun <T: View> T.lp(width: Int, height: Int): T {
    this.layoutParams = ViewGroup.LayoutParams(width, height)
    return this
}

fun <T: View> T.lp(init: ViewGroup.LayoutParams.() -> Unit): T {
    this.layoutParams.init()
    return this
}

inline val submissive: ViewGroup.LayoutParams.() -> Unit
    get() = { width = wrapContent; height = wrapContent }
inline val row: ViewGroup.LayoutParams.() -> Unit
    get() = { width = matchParent; height = wrapContent }
inline val column: ViewGroup.LayoutParams.() -> Unit
    get() = { width = wrapContent; height = matchParent }
inline val dominant: ViewGroup.LayoutParams.() -> Unit
    get() = { width = matchParent; height = matchParent }


open class KoatlFrame(ctx: Context) : _FrameLayout(ctx) {
    inline val g1: FrameLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.START or Gravity.TOP }
    inline val g2: FrameLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP }
    inline val g3: FrameLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.END or Gravity.TOP }
    inline val g4: FrameLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL or Gravity.START}
    inline val g5: FrameLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL }
    inline val g6: FrameLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL or Gravity.END }
    inline val g7: FrameLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.START or Gravity.BOTTOM }
    inline val g8: FrameLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM }
    inline val g9: FrameLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.END or Gravity.BOTTOM }
    inline val g123: FrameLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.TOP }
    inline val g147: FrameLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.START }
    inline val g258: FrameLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_HORIZONTAL }
    inline val g456: FrameLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL }
    inline val g369: FrameLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.END }
    inline val g789: FrameLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.BOTTOM }
    inline val submissive: FrameLayout.LayoutParams.() -> Unit
        get() = { width = wrapContent; height = wrapContent }
    inline val row: FrameLayout.LayoutParams.() -> Unit
        get() = { width = matchParent; height = wrapContent }
    inline val column: FrameLayout.LayoutParams.() -> Unit
        get() = { width = wrapContent; height = matchParent }
    inline val dominant: FrameLayout.LayoutParams.() -> Unit
        get() = { width = matchParent; height = matchParent }

    /**
     * Margin setting functions
     * 'm' stands for 'margin'
     * 't' stands for 'top'
     * 'l' stands for 'left'
     * 'r' stands for 'right'
     * 'b' stands for 'bottom'
     * 'e' stands for 'end'
     * 's' stands for 'start'
     * 'c' stands for 'coefficient'
     * */

    fun m(c: Int): FrameLayout.LayoutParams.() -> Unit = {
        setMargins(c, c, c, c)
    }
    fun m(h: Int, v: Int): FrameLayout.LayoutParams.() -> Unit = {
        setMargins(h, v, h, v)
    }
    fun m(l: Int, t: Int, r: Int, b: Int): FrameLayout.LayoutParams.() -> Unit = {
        setMargins(l, t, r, b)
    }
    fun mHorizontal(c: Int): FrameLayout.LayoutParams.() -> Unit = {
        marginStart = c
        marginEnd = c
    }
    fun mVertical(c: Int): FrameLayout.LayoutParams.() -> Unit = {
        topMargin = c
        bottomMargin = c
    }
    fun top(c: Int): FrameLayout.LayoutParams.() -> Unit = {
        topMargin = c
    }
    fun bottom(c: Int): FrameLayout.LayoutParams.() -> Unit = {
        bottomMargin = c
    }
    fun start(c: Int): FrameLayout.LayoutParams.() -> Unit = {
        marginStart = c
    }
    fun end(c: Int): FrameLayout.LayoutParams.() -> Unit = {
        marginEnd = c
    }

    fun <T: View> T.lp(vararg params: FrameLayout.LayoutParams.() -> Unit) : T {
        layoutParams = FrameLayout.LayoutParams(wrapContent, wrapContent).apply {
            for (param in params) param()
        }
        return this
    }

    /**
     * You will able to write functions like this (just example):
     * `lp(row) { margin = dip(10) }` instead of this `lp(row, { margin = dip(10) })`
     * */
    fun <T: View> T.lp (
            vararg params: FrameLayout.LayoutParams.() -> Unit,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        layoutParams = FrameLayout.LayoutParams(wrapContent, wrapContent).apply {
            for (param in params) param()
            init()
        }
        return this
    }
}


open class KoatlLinear(ctx: Context): _LinearLayout(ctx) {
    inline val g1: LinearLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.START or Gravity.TOP }
    inline val g2: LinearLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP }
    inline val g3: LinearLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.END or Gravity.TOP }
    inline val g4: LinearLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL or Gravity.START}
    inline val g5: LinearLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL }
    inline val g6: LinearLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL or Gravity.END }
    inline val g7: LinearLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.START or Gravity.BOTTOM }
    inline val g8: LinearLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM }
    inline val g9: LinearLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.END or Gravity.BOTTOM }
    inline val g123: LinearLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.TOP }
    inline val g147: LinearLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.START }
    inline val g258: LinearLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_HORIZONTAL }
    inline val g456: LinearLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL }
    inline val g369: LinearLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.END }
    inline val g789: LinearLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.BOTTOM }
    inline val submissive: LinearLayout.LayoutParams.() -> Unit
        get() = { width = wrapContent; height = wrapContent }
    inline val row: LinearLayout.LayoutParams.() -> Unit
        get() = { width = matchParent; height = wrapContent }
    inline val column: LinearLayout.LayoutParams.() -> Unit
        get() = { width = wrapContent; height = matchParent }
    inline val dominant: LinearLayout.LayoutParams.() -> Unit
        get() = { width = matchParent; height = matchParent }

    /**
     * Margin setting functions
     * 'm' stands for 'margin'
     * 't' stands for 'top'
     * 'l' stands for 'left'
     * 'r' stands for 'right'
     * 'b' stands for 'bottom'
     * 'e' stands for 'end'
     * 's' stands for 'start'
     * 'c' stands for 'coefficient'
     * */

    fun m(c: Int): LinearLayout.LayoutParams.() -> Unit = {
        setMargins(c, c, c, c)
    }
    fun m(h: Int, v: Int): LinearLayout.LayoutParams.() -> Unit = {
        setMargins(h, v, h, v)
    }
    fun m(l: Int, t: Int, r: Int, b: Int): LinearLayout.LayoutParams.() -> Unit = {
        setMargins(l, t, r, b)
    }
    fun mHorizontal(c: Int): LinearLayout.LayoutParams.() -> Unit = {
        marginStart = c
        marginEnd = c
    }
    fun mVertical(c: Int): LinearLayout.LayoutParams.() -> Unit = {
        topMargin = c
        bottomMargin = c
    }
    fun top(c: Int): LinearLayout.LayoutParams.() -> Unit = {
        topMargin = c
    }
    fun bottom(c: Int): LinearLayout.LayoutParams.() -> Unit = {
        bottomMargin = c
    }
    fun start(c: Int): LinearLayout.LayoutParams.() -> Unit = {
        marginStart = c
    }
    fun end(c: Int): LinearLayout.LayoutParams.() -> Unit = {
        marginEnd = c
    }

    fun <T: View> T.lp(vararg params: LinearLayout.LayoutParams.() -> Unit) : T {
        layoutParams = LinearLayout.LayoutParams(wrapContent, wrapContent).apply {
            for (param in params) param()
        }
        return this
    }

    @Deprecated("Use Float.invoke instead")
    fun <T: View> T.lp(weight: Float, vararg params: LinearLayout.LayoutParams.() -> Unit) : T {
        layoutParams = LinearLayout.LayoutParams(wrapContent, wrapContent).apply {
            this.weight = weight
            for (param in params) param()
        }
        return this
    }

    /**
     * You will able to write functions like this (just example):
     * `lp(row) { margin = dip(10) }` instead of this `lp(row, { margin = dip(10) })`
     * */
    fun <T: View> T.lp (
            vararg params: LinearLayout.LayoutParams.() -> Unit,
            init: LinearLayout.LayoutParams.() -> Unit
    ): T {
        layoutParams = LinearLayout.LayoutParams(wrapContent, wrapContent).apply {
            for (param in params) param()
            init()
        }
        return this
    }

    @Deprecated("Use Float.invoke instead")
    fun <T: View> T.lp (
            weight: Float,
            vararg params: LinearLayout.LayoutParams.() -> Unit,
            init: LinearLayout.LayoutParams.() -> Unit
    ) : T {
        layoutParams = LinearLayout.LayoutParams(wrapContent, wrapContent).apply {
            this.weight = weight
            for (param in params) param()
            init()
        }
        return this
    }

    operator fun Float.invoke(): LinearLayout.LayoutParams.() -> Unit = {
        weight = this@invoke
    }
}


open class KoatlRelative(ctx: Context) : _RelativeLayout(ctx) {
    inline val submissive: RelativeLayout.LayoutParams.() -> Unit
        get() = { width = wrapContent; height = wrapContent }
    inline val row: RelativeLayout.LayoutParams.() -> Unit
        get() = { width = matchParent; height = wrapContent }
    inline val column: RelativeLayout.LayoutParams.() -> Unit
        get() = { width = wrapContent; height = matchParent }
    inline val dominant: RelativeLayout.LayoutParams.() -> Unit
        get() = { width = matchParent; height = matchParent }
    /**
     * Margin setting functions
     * 'dp' stands for 'dip'
     * 'm' stands for 'margin'
     * 't' stands for 'top'
     * 'l' stands for 'left'
     * 'r' stands for 'right'
     * 'b' stands for 'bottom'
     * 'e' stands for 'end'
     * 's' stands for 'start'
     * 'c' stands for 'coefficient'
     * */
    fun m(c: Int): RelativeLayout.LayoutParams.() -> Unit = {
        setMargins(c, c, c, c)
    }
    fun m(h: Int, v: Int): RelativeLayout.LayoutParams.() -> Unit = {
        setMargins(h, v, h, v)
    }
    fun m(l: Int, t: Int, r: Int, b: Int): RelativeLayout.LayoutParams.() -> Unit = {
        setMargins(l, t, r, b)
    }
    fun mHorizontal(c: Int): RelativeLayout.LayoutParams.() -> Unit = {
        marginStart = c
        marginEnd = c
    }
    fun mVertical(c: Int): RelativeLayout.LayoutParams.() -> Unit = {
        topMargin = c
        bottomMargin = c
    }
    fun top(c: Int): RelativeLayout.LayoutParams.() -> Unit = {
        topMargin = c
    }
    fun bottom(c: Int): RelativeLayout.LayoutParams.() -> Unit = {
        bottomMargin = c
    }
    fun start(c: Int): RelativeLayout.LayoutParams.() -> Unit = {
        marginStart = c
    }
    fun end(c: Int): RelativeLayout.LayoutParams.() -> Unit = {
        marginEnd = c
    }

    fun <T: View> T.lp(vararg params: RelativeLayout.LayoutParams.() -> Unit) : T {
        layoutParams = RelativeLayout.LayoutParams(wrapContent, wrapContent).apply {
            for (param in params) param()
        }
        return this
    }

    fun <T: View> T.lp (
            vararg params: RelativeLayout.LayoutParams.() -> Unit,
            init: RelativeLayout.LayoutParams.() -> Unit
    ) : T {
        layoutParams = RelativeLayout.LayoutParams(wrapContent, wrapContent).apply {
            for (param in params) param()
            init()
        }
        return this
    }
}


open class KoatlDrawer (ctx: Context): _DrawerLayout(ctx) {
    inline val g1: DrawerLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.START or Gravity.TOP }
    inline val g2: DrawerLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP }
    inline val g3: DrawerLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.END or Gravity.TOP }
    inline val g4: DrawerLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL or Gravity.START}
    inline val g5: DrawerLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL }
    inline val g6: DrawerLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL or Gravity.END }
    inline val g7: DrawerLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.START or Gravity.BOTTOM }
    inline val g8: DrawerLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM }
    inline val g9: DrawerLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.END or Gravity.BOTTOM }
    inline val g123: DrawerLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.TOP }
    inline val g147: DrawerLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.START }
    inline val g258: DrawerLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_HORIZONTAL }
    inline val g456: DrawerLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL }
    inline val g369: DrawerLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.END }
    inline val g789: DrawerLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.BOTTOM }
    inline val submissive: DrawerLayout.LayoutParams.() -> Unit
        get() = { width = wrapContent; height = wrapContent }
    inline val row: DrawerLayout.LayoutParams.() -> Unit
        get() = { width = matchParent; height = wrapContent }
    inline val column: DrawerLayout.LayoutParams.() -> Unit
        get() = { width = wrapContent; height = matchParent }
    inline val dominant: DrawerLayout.LayoutParams.() -> Unit
        get() = { width = matchParent; height = matchParent }

    /**
     * Margin setting functions
     * 'm' stands for 'margin'
     * 't' stands for 'top'
     * 'l' stands for 'left'
     * 'r' stands for 'right'
     * 'b' stands for 'bottom'
     * 'e' stands for 'end'
     * 's' stands for 'start'
     * 'c' stands for 'coefficient'
     * */

    fun m(c: Int): DrawerLayout.LayoutParams.() -> Unit = {
        setMargins(c, c, c, c)
    }
    fun m(h: Int, v: Int): DrawerLayout.LayoutParams.() -> Unit = {
        setMargins(h, v, h, v)
    }
    fun m(l: Int, t: Int, r: Int, b: Int): DrawerLayout.LayoutParams.() -> Unit = {
        setMargins(l, t, r, b)
    }
    fun mHorizontal(c: Int): DrawerLayout.LayoutParams.() -> Unit = {
        marginStart = c
        marginEnd = c
    }
    fun mVertical(c: Int): DrawerLayout.LayoutParams.() -> Unit = {
        topMargin = c
        bottomMargin = c
    }
    fun top(c: Int): DrawerLayout.LayoutParams.() -> Unit = {
        topMargin = c
    }
    fun bottom(c: Int): DrawerLayout.LayoutParams.() -> Unit = {
        bottomMargin = c
    }
    fun start(c: Int): DrawerLayout.LayoutParams.() -> Unit = {
        marginStart = c
    }
    fun end(c: Int): DrawerLayout.LayoutParams.() -> Unit = {
        marginEnd = c
    }

    fun <T: View> T.lp(vararg params: DrawerLayout.LayoutParams.() -> Unit) : T {
        layoutParams = DrawerLayout.LayoutParams(wrapContent, wrapContent).apply {
            for (param in params) param()
        }
        return this
    }

    /**
     * You will able to write functions like this (just example):
     * `lp(row) { margin = dip(10) }` instead of this `lp(row, { margin = dip(10) })`
     * */
    fun <T: View> T.lp (
            vararg params: DrawerLayout.LayoutParams.() -> Unit,
            init: DrawerLayout.LayoutParams.() -> Unit
    ): T {
        layoutParams = DrawerLayout.LayoutParams(wrapContent, wrapContent).apply {
            for (param in params) param()
            init()
        }
        return this
    }
}


open class KoatlTable(ctx: Context) : _TableLayout(ctx) {
    inline val g1: TableLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.START or Gravity.TOP }
    inline val g2: TableLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP }
    inline val g3: TableLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.END or Gravity.TOP }
    inline val g4: TableLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL or Gravity.START}
    inline val g5: TableLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL }
    inline val g6: TableLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL or Gravity.END }
    inline val g7: TableLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.START or Gravity.BOTTOM }
    inline val g8: TableLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM }
    inline val g9: TableLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.END or Gravity.BOTTOM }
    inline val g123: TableLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.TOP }
    inline val g147: TableLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.START }
    inline val g258: TableLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_HORIZONTAL }
    inline val g456: TableLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL }
    inline val g369: TableLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.END }
    inline val g789: TableLayout.LayoutParams.() -> Unit
        get() = { gravity = Gravity.BOTTOM }
    inline val submissive: TableLayout.LayoutParams.() -> Unit
        get() = { width = wrapContent; height = wrapContent }
    inline val row: TableLayout.LayoutParams.() -> Unit
        get() = { width = matchParent; height = wrapContent }
    inline val column: TableLayout.LayoutParams.() -> Unit
        get() = { width = wrapContent; height = matchParent }
    inline val dominant: TableLayout.LayoutParams.() -> Unit
        get() = { width = matchParent; height = matchParent }

    /**
     * Margin setting functions
     * 'm' stands for 'margin'
     * 't' stands for 'top'
     * 'l' stands for 'left'
     * 'r' stands for 'right'
     * 'b' stands for 'bottom'
     * 'e' stands for 'end'
     * 's' stands for 'start'
     * 'c' stands for 'coefficient'
     * */

    fun m(l: Int, t: Int, r: Int, b: Int): TableLayout.LayoutParams.() -> Unit = {
        setMargins(l, t, r, b)
    }
    fun m(c: Int): TableLayout.LayoutParams.() -> Unit = {
        setMargins(c, c, c, c)
    }
    fun m(h: Int, v: Int): TableLayout.LayoutParams.() -> Unit = {
        setMargins(h, v, h, v)
    }
    fun mHorizontal(c: Int): TableLayout.LayoutParams.() -> Unit = {
        marginStart = c
        marginEnd = c
    }
    fun mVertical(c: Int): TableLayout.LayoutParams.() -> Unit = {
        topMargin = c
        bottomMargin = c
    }
    fun top(c: Int): TableLayout.LayoutParams.() -> Unit = {
        topMargin = c
    }
    fun bottom(c: Int): TableLayout.LayoutParams.() -> Unit = {
        bottomMargin = c
    }
    fun start(c: Int): TableLayout.LayoutParams.() -> Unit = {
        marginStart = c
    }
    fun end(c: Int): TableLayout.LayoutParams.() -> Unit = {
        marginEnd = c
    }

    fun <T: View> T.lp(vararg params: TableLayout.LayoutParams.() -> Unit) : T {
        layoutParams = TableLayout.LayoutParams(wrapContent, wrapContent).apply {
            for (param in params) param()
        }
        return this
    }

    /**
     * You will able to write functions like this (just example):
     * `lp(row) { margin = dip(10) }` instead of this `lp(row, { margin = dip(10) })`
     * */
    fun <T: View> T.lp (
            vararg params: TableLayout.LayoutParams.() -> Unit,
            init: TableLayout.LayoutParams.() -> Unit
    ): T {
        layoutParams = TableLayout.LayoutParams(wrapContent, wrapContent).apply {
            for (param in params) param()
            init()
        }
        return this
    }

    /**
     * tableRow functions
     * */
    fun ViewManager.vRow (init: (@AnkoViewDslMarker KoatlTableRow).() -> Unit): TableRow
            = ankoView({ KoatlTableRow(it) }, 0) { init() }

    fun ViewManager.vRow (
            vararg inits: (@AnkoViewDslMarker KoatlTableRow).() -> Unit,
            init: (@AnkoViewDslMarker KoatlTableRow).() -> Unit
    ): TableRow = ankoView({ KoatlTableRow(it) }, 0) {
        inits.forEach { it() }
        init()
    }
}

open class KoatlTableRow(ctx: Context) : _TableRow(ctx) {
    inline val g1: TableRow.LayoutParams.() -> Unit
        get() = { gravity = Gravity.START or Gravity.TOP }
    inline val g2: TableRow.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP }
    inline val g3: TableRow.LayoutParams.() -> Unit
        get() = { gravity = Gravity.END or Gravity.TOP }
    inline val g4: TableRow.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL or Gravity.START}
    inline val g5: TableRow.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL }
    inline val g6: TableRow.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL or Gravity.END }
    inline val g7: TableRow.LayoutParams.() -> Unit
        get() = { gravity = Gravity.START or Gravity.BOTTOM }
    inline val g8: TableRow.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM }
    inline val g9: TableRow.LayoutParams.() -> Unit
        get() = { gravity = Gravity.END or Gravity.BOTTOM }
    inline val g123: TableRow.LayoutParams.() -> Unit
        get() = { gravity = Gravity.TOP }
    inline val g147: TableRow.LayoutParams.() -> Unit
        get() = { gravity = Gravity.START }
    inline val g258: TableRow.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_HORIZONTAL }
    inline val g456: TableRow.LayoutParams.() -> Unit
        get() = { gravity = Gravity.CENTER_VERTICAL }
    inline val g369: TableRow.LayoutParams.() -> Unit
        get() = { gravity = Gravity.END }
    inline val g789: TableRow.LayoutParams.() -> Unit
        get() = { gravity = Gravity.BOTTOM }
    inline val submissive: TableRow.LayoutParams.() -> Unit
        get() = { width = wrapContent; height = wrapContent }
    inline val row: TableRow.LayoutParams.() -> Unit
        get() = { width = matchParent; height = wrapContent }
    inline val column: TableRow.LayoutParams.() -> Unit
        get() = { width = wrapContent; height = matchParent }
    inline val dominant: TableRow.LayoutParams.() -> Unit
        get() = { width = matchParent; height = matchParent }

    /**
     * Margin setting functions
     * 'm' stands for 'margin'
     * 't' stands for 'top'
     * 'l' stands for 'left'
     * 'r' stands for 'right'
     * 'b' stands for 'bottom'
     * 'e' stands for 'end'
     * 's' stands for 'start'
     * 'c' stands for 'coefficient'
     * */

    fun m(l: Int, t: Int, r: Int, b: Int): TableRow.LayoutParams.() -> Unit = {
        setMargins(l, t, r, b)
    }
    fun m(c: Int): TableRow.LayoutParams.() -> Unit = {
        setMargins(c, c, c, c)
    }
    fun m(h: Int, v: Int): TableRow.LayoutParams.() -> Unit = {
        setMargins(h, v, h, v)
    }
    fun mHorizontal(c: Int): TableRow.LayoutParams.() -> Unit = {
        marginStart = c
        marginEnd = c
    }
    fun mVertical(c: Int): TableRow.LayoutParams.() -> Unit = {
        topMargin = c
        bottomMargin = c
    }
    fun top(c: Int): TableRow.LayoutParams.() -> Unit = {
        topMargin = c
    }
    fun bottom(c: Int): TableRow.LayoutParams.() -> Unit = {
        bottomMargin = c
    }
    fun start(c: Int): TableRow.LayoutParams.() -> Unit = {
        marginStart = c
    }
    fun end(c: Int): TableRow.LayoutParams.() -> Unit = {
        marginEnd = c
    }

    fun <T: View> T.lp(vararg params: TableRow.LayoutParams.() -> Unit) : T {
        layoutParams = TableRow.LayoutParams(wrapContent, wrapContent).apply {
            for (param in params) param()
        }
        return this
    }

    /**
     * You will able to write functions like this (just example):
     * `lp(row) { margin = dip(10) }` instead of this `lp(row, { margin = dip(10) })`
     * */
    fun <T: View> T.lp (
            vararg params: TableRow.LayoutParams.() -> Unit,
            init: TableRow.LayoutParams.() -> Unit
    ): T {
        layoutParams = TableRow.LayoutParams(wrapContent, wrapContent).apply {
            for (param in params) param()
            init()
        }
        return this
    }
}