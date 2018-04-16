package com.brotandos.koatl

import android.view.View
import android.view.ViewGroup
import java.util.*

/**
 * @author: Brotandos
 * @date: 22.02.2018.
 */
class ChildrenSequence<out T: View>(private val view: ViewGroup) : Sequence<T> {
    private var index = 0
    private val count = view.childCount

    override fun iterator(): Iterator<T> = object : Iterator<T> {
        override fun hasNext(): Boolean {
            checkCount()
            return index < count
        }

        override fun next(): T {
            if (!hasNext()) throw NoSuchElementException()
            return view.getChildAt(index++) as T
        }

        private fun checkCount() {
            if (count != view.childCount) throw ConcurrentModificationException()
        }
    }
}


fun <E: View> ViewGroup.children() : Sequence<E> = ChildrenSequence(this)