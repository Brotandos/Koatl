package com.brotandos.koatlib

import android.widget.CompoundButton

/**
 * @author: Brotandos
 * @creation_date: 10.04.2018
 */
fun btnRes(res: Int): CompoundButton.() -> Unit = {
    setButtonDrawable(res)
}