package com.brotandos.koatlib

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Html
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import org.jetbrains.anko.*

/**
 * @author: Brotandos
 * @creation_date: 22.03.2018
 */
interface KoatlContext<out T> : AnkoContext<T> {
    val Int.dp: Int get() = ctx.dip(this)

    val visible: View.() -> Unit get() = {
        visibility = View.VISIBLE
    }

    val invisible: View.() -> Unit get() = {
        visibility = View.INVISIBLE
    }

    val hidden: View.() -> Unit get() = {
        visibility = View.GONE
    }

    val enabled: View.() -> Unit get() = {
        isEnabled = true
    }

    val disabled: View.() -> Unit get() = {
        isEnabled = false
    }

    val clickable: View.() -> Unit get() = {
        isClickable = true
    }

    val unclickable: View.() -> Unit get() = {
        isClickable = false
    }

    val checked: CompoundButton.() -> Unit get() = {
        isChecked = true
    }

    val unchecked: CompoundButton.() -> Unit get() = {
        isChecked = false
    }

    val <T: View> T.asSubmissive: T  get() {
        layoutParams = ViewGroup.LayoutParams(wrapContent, wrapContent)
        return this
    }

    val <T: View> T.asColumn: T get() {
        layoutParams = ViewGroup.LayoutParams(wrapContent, matchParent)
        return this
    }

    val <T: View> T.asRow: T get() {
        layoutParams = ViewGroup.LayoutParams(matchParent, wrapContent)
        return this
    }

    val <T: View> T.asDominant: T get() {
        layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)
        return this
    }

    val lpRow: ViewGroup.LayoutParams.() -> Unit get() = {
        width = matchParent
        height = wrapContent
    }

    /**
     * 'bg' stands for 'background'
     * */
    fun bg(res: Int): View.() -> Unit = {
        backgroundResource = res
    }

    fun bgColor(color: Int): View.() -> Unit = {
        backgroundColor = color
    }

    /**
     * Listeners setting functions
     * */
    operator fun View.OnClickListener.unaryPlus(): View.() -> Unit = {
        setOnClickListener(this@unaryPlus)
    }

    operator fun View.OnFocusChangeListener.unaryPlus(): View.() -> Unit = {
        onFocusChangeListener = this@unaryPlus
    }

    operator fun View.OnTouchListener.unaryPlus(): View.() -> Unit = {
        setOnTouchListener(this@unaryPlus)
    }

    operator fun Int.not(): View.() -> Unit = {
        id = this@not
    }

    fun id(id: Int): View.() -> Unit = {
        this.id = id
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

    fun selected(selectedItemId: Int): BottomNavigationViewEx.() -> Unit = {
         this.selectedItemId = selectedItemId
    }

    val stretch: TableLayout.() -> Unit
        get() = { isStretchAllColumns = true }

    val Float.asWeightSum: TableRow.() -> Unit get() = {
        weightSum = this@asWeightSum
    }

    // TextView extensions
    val underlined: TextView.() -> Unit get() = {
        paintFlags = Paint.UNDERLINE_TEXT_FLAG
    }

    val textBlack: TextView.() -> Unit get() = {
        textColor = Color.BLACK
    }

    val text4: TextView.() -> Unit get() = {
        textAlignment = View.TEXT_ALIGNMENT_TEXT_START
    }

    val text5: TextView.() -> Unit get() = {
        textAlignment = View.TEXT_ALIGNMENT_CENTER
    }

    val text6: TextView.() -> Unit get() = {
        textAlignment = View.TEXT_ALIGNMENT_TEXT_END
    }

    val password: TextView.() -> Unit get() = {
        inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
    }

    val numeric: TextView.() -> Unit get() = {
        inputType = InputType.TYPE_CLASS_NUMBER
    }

    val bold: TextView.() -> Unit get() = {
        typeface = Typeface.DEFAULT_BOLD
    }

    val line: TextView.() -> Unit get() = {
        singleLine = true
    }

    val Float.sp: TextView.() -> Unit get() = {
        textSize = sp(this@sp).toFloat()
    }

    val selectable: TextView.() -> Unit get() = {
        setTextIsSelectable(true)
    }

    val String.html: CharSequence get()
    =   if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) Html.fromHtml(this)
        else Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)

    fun text(color: Int): TextView.() -> Unit = {
        textColor = color
    }

    operator fun String.unaryPlus(): TextView.() -> Unit = {
        hint = this@unaryPlus
    }

    fun <T: TextView> T.html(text: String) {
        this.text =
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) Html.fromHtml(text)
                else Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT)
    }

    /**
     * Icon setting functions
     * */
    fun icLeft(iconRes: Int): TextView.() -> Unit = {
        setCompoundDrawablesWithIntrinsicBounds(iconRes, 0, 0, 0)
    }

    fun icRight(iconRes: Int): TextView.() -> Unit = {
        setCompoundDrawablesWithIntrinsicBounds(0, 0, iconRes, 0)
    }

    fun icLeftRight(leftIcon: Int, rightIcon: Int): TextView.() -> Unit = {
        setCompoundDrawablesWithIntrinsicBounds(leftIcon, 0, rightIcon, 0)
    }

    fun icTopRight(topIcon: Int, rightIcon: Int): TextView.() -> Unit = {
        setCompoundDrawablesWithIntrinsicBounds(0, topIcon, rightIcon, 0)
    }

    fun pIcon(c: Int): TextView.() -> Unit = {
        compoundDrawablePadding = c
    }


    fun <T> T.createKoatlContext (
            ctx: Context,
            init: KoatlContext<T>.() -> Unit,
            setContentView: Boolean = false
    ) : KoatlContext<T> {
        val dsl = KoatlContextImpl(ctx, this, setContentView)
        dsl.init()
        return dsl
    }

}

open class KoatlContextImpl<T> (
        override val ctx: Context,
        override val owner: T,
        setContentView: Boolean
) : AnkoContextImpl<T>(ctx, owner, setContentView), KoatlContext<T>

inline fun Context.KUI(init: KoatlContext<Context>.() -> Unit): android.view.View =
        createKoatlContext(this, init)


inline fun <T> createKoatlContext (
        ctx: Context,
        init: KoatlContext<T>.() -> Unit,
        setContentView: Boolean = false
): android.view.View {
    val dsl = KoatlContextImpl(ctx, ctx, setContentView)
    (dsl as KoatlContext<T>).init()
    return dsl.view
}


abstract class KoatlFragment : Fragment() {
    fun Fragment.KUI(init: KoatlContext<Context>.() -> Unit)
            = createKoatlContext(context!!, init)

    abstract fun markup(): View

    override fun onCreateView(i: LayoutInflater, vg: ViewGroup?, b: Bundle?) = markup()
}