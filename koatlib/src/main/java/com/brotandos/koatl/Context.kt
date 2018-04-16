package com.brotandos.koatl

import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.widget.LinearLayoutManager
import android.util.TypedValue
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.ArrayAdapter
import io.reactivex.Single
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.AnkoContextImpl
import org.jetbrains.anko.dip
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

interface KoatlContext<out T> : AnkoContext<T> {
    val Int.dp: Int get() = ctx.dip(this)

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