package com.brotandos.koatlib

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author: Brotandos
 * @creation_date: 22.03.2018
 */
abstract class KoatlFragment : Fragment() {
    fun Fragment.KUI(init: KoatlContext<Context>.() -> Unit)
            = createKoatlContext(context!!, init)

    abstract fun markup(): View

    override fun onCreateView(i: LayoutInflater, vg: ViewGroup?, b: Bundle?) = markup()
}