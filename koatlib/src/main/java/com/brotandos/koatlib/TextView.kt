package com.brotandos.koatlib

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Build
import android.text.Editable
import android.text.Html
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import org.jetbrains.anko.*

/**
 * @author: Brotandos
 * @date: 22.02.2018.
 */
val underlined: TextView.() -> Unit = {
    paintFlags = Paint.UNDERLINE_TEXT_FLAG
}

val textBlack: TextView.() -> Unit = {
    textColor = Color.BLACK
}

val text4: TextView.() -> Unit = {
    textAlignment = View.TEXT_ALIGNMENT_TEXT_START
}

val text5: TextView.() -> Unit = {
    textAlignment = View.TEXT_ALIGNMENT_CENTER
}

val text6: TextView.() -> Unit = {
    textAlignment = View.TEXT_ALIGNMENT_TEXT_END
}

val password: TextView.() -> Unit = {
    inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
}

val numeric: TextView.() -> Unit = {
    inputType = InputType.TYPE_CLASS_NUMBER
}

val bold: TextView.() -> Unit = {
    typeface = Typeface.DEFAULT_BOLD
}

val line: TextView.() -> Unit = {
    singleLine = true
}

val Float.sp: TextView.() -> Unit
    get() = {
        textSize = sp(this@sp).toFloat()
    }

val selectable: TextView.() -> Unit
    get() = {
        setTextIsSelectable(true)
    }

val String.html: CharSequence
    get() = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) Html.fromHtml(this)
            else Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)

fun text(size: Float): TextView.() -> Unit = {
    textSize = dip(size).toFloat()
}

fun text(color: Int): TextView.() -> Unit = {
    textColor = color
}

operator fun String.invoke(): TextView.() -> Unit = {
    hint = this@invoke
}

@Deprecated("Use Float.sp instead")
operator fun Float.invoke(): TextView.() -> Unit = {
    textSize = dip(this@invoke).toFloat()
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

fun textWatcher (
        beforeChanged: ((CharSequence?, Int, Int, Int) -> Unit)? = null,
        onChanged: ((CharSequence?, Int, Int, Int) -> Unit)? = null,
        afterChanged: ((Editable?) -> Unit)? = null
) = object : TextWatcher {

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        if (beforeChanged != null) beforeChanged(s, start, count, after)
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (onChanged != null) onChanged(s, start, before, count)
    }

    override fun afterTextChanged(s: Editable?) {
        if (afterChanged != null) afterChanged(s)
    }
}