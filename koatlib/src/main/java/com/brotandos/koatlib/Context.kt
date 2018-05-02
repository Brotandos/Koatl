package com.brotandos.koatlib

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.support.v7.widget.LinearLayoutManager
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import io.reactivex.Single
import org.jetbrains.anko.*
import retrofit2.Call

/**
 * @author: Brotandos
 * @date: 22.02.2018.
 */
fun Context.isOnline() : Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netInfo = connectivityManager.activeNetworkInfo
    return (netInfo != null && netInfo.isConnected)
}

fun <T> Context.createSingleResponse(call: Call<T>) : Single<T>
        = Single.create { subscriber ->
    if (isOnline()) {
        val response = call.execute()
        if (response.isSuccessful)  subscriber.onSuccess(response.body()!!)
        else                        subscriber.onError(Throwable(response.message()))
    } else subscriber.onError(Throwable("No internet connection"))
}

fun Context.createMessageSingle(call: Call<Void>) : Single<String>
        = Single.create { subscriber ->
    if (isOnline()) {
        val response = call.execute()
        if (response.isSuccessful)  subscriber.onSuccess(response.message())
        else                        subscriber.onError(Throwable(response.message()))
    } else subscriber.onError(Throwable("No internet connection"))
}

fun Context.attribute(value : Int) : TypedValue {
    val ret = TypedValue()
    theme.resolveAttribute(value, ret, true)
    return ret
}

fun Context.attrAsDimen(value: Int)
        = TypedValue.complexToDimensionPixelSize(attribute(value).data, resources.displayMetrics)

fun Context.actionBarSize() = attrAsDimen(R.attr.actionBarSize)

fun Context.loadLayoutAnimation(id: Int) : LayoutAnimationController
        = AnimationUtils.loadLayoutAnimation(this, id)

fun Context.llManager() = LinearLayoutManager(this)

fun <E> Context.spinnerDropdownAdapter(items: List<E>)
        = ArrayAdapter<E>(this, R.layout.support_simple_spinner_dropdown_item, items).apply {
    setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
}