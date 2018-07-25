package com.brotandos.koatlib

import android.support.v7.widget.RecyclerView
import android.view.ViewManager
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import org.jetbrains.anko.AnkoViewDslMarker
import org.jetbrains.anko._RadioGroup
import org.jetbrains.anko.custom.ankoView

/**
 * @author: Brotandos
 * @date: 26.02.2018.
 */
fun ViewManager.v (
        vararg initializations: (@AnkoViewDslMarker android.view.View).() -> Unit
): android.view.View = ankoView({ android.view.View(it) }, 0) {
    initializations.forEach { it() }
}

fun ViewManager.v (
        vararg initializations: (@AnkoViewDslMarker android.view.View).() -> Unit,
        init: (@AnkoViewDslMarker android.view.View).() -> Unit
): android.view.View = ankoView({ android.view.View(it) }, 0) {
    initializations.forEach { it() }
    init()
}

fun ViewManager.vLabel (
        text: CharSequence?,
        vararg initializations: (@AnkoViewDslMarker android.widget.TextView).() -> Unit
): android.widget.TextView = ankoView({ android.widget.TextView(it) }, theme = 0) {
    for (init in initializations) init()
    setText(text)
}

fun ViewManager.vLabel (
        text: CharSequence?,
        vararg initializations: (@AnkoViewDslMarker android.widget.TextView).() -> Unit,
        additionalInit: (@AnkoViewDslMarker android.widget.TextView).() -> Unit
): android.widget.TextView = ankoView({ android.widget.TextView(it) }, theme = 0) {
    for (init in initializations) init()
    additionalInit()
    setText(text)
}

fun ViewManager.vLabel (
        text: Int,
        vararg initializations: (@AnkoViewDslMarker android.widget.TextView).() -> Unit
): android.widget.TextView = ankoView({ android.widget.TextView(it) }, theme = 0) {
    for (init in initializations) init()
    setText(text)
}

fun ViewManager.vLabel (
        text: Int,
        vararg initializations: (@AnkoViewDslMarker android.widget.TextView).() -> Unit,
        additionalInit: (@AnkoViewDslMarker android.widget.TextView).() -> Unit
): android.widget.TextView = ankoView({ android.widget.TextView(it) }, theme = 0) {
    for (init in initializations) init()
    additionalInit()
    setText(text)
}

fun ViewManager.vLabel (
        vararg initializations: (@AnkoViewDslMarker android.widget.TextView).() -> Unit
): android.widget.TextView
        = ankoView({ android.widget.TextView(it) }, 0) { for (init in initializations) init() }

fun ViewManager.vLabel (
        vararg initializations: (@AnkoViewDslMarker android.widget.TextView).() -> Unit,
        additionalInit: (@AnkoViewDslMarker android.widget.TextView).() -> Unit
): android.widget.TextView = ankoView({ android.widget.TextView(it) }, 0) {
    for (init in initializations) init()
    additionalInit()
}


fun ViewManager.vText (
        vararg initializations: (@AnkoViewDslMarker android.widget.EditText).() -> Unit
) : android.widget.EditText
        = ankoView({ android.widget.EditText(it) }, theme = 0) { for (init in initializations) init() }

fun ViewManager.vText (
        vararg initializations: (@AnkoViewDslMarker android.widget.EditText).() -> Unit,
        additionalInit: (@AnkoViewDslMarker android.widget.EditText).() -> Unit
) : android.widget.EditText = ankoView({ android.widget.EditText(it) }, theme = 0) {
    for (init in initializations) init()
    additionalInit()
}

fun ViewManager.vText (
        text: CharSequence?,
        vararg initializations: (@AnkoViewDslMarker android.widget.EditText).() -> Unit
): android.widget.EditText
        = ankoView({ android.widget.EditText(it) }, theme = 0) {
    for (init in initializations) init()
    setText(text)
}

fun ViewManager.vText (
        text: CharSequence?,
        vararg initializations: (@AnkoViewDslMarker android.widget.EditText).() -> Unit,
        additionalInit: (@AnkoViewDslMarker android.widget.EditText).() -> Unit
): android.widget.EditText = ankoView({ android.widget.EditText(it) }, theme = 0) {
    for (init in initializations) init()
    additionalInit()
    setText(text)
}

fun ViewManager.vText (
        text: Int,
        vararg initializations: (@AnkoViewDslMarker android.widget.EditText).() -> Unit
): android.widget.EditText = ankoView({ android.widget.EditText(it) }, theme = 0) {
    for (init in initializations) init()
    setText(text)
}

fun ViewManager.vText (
        text: Int,
        vararg initializations: (@AnkoViewDslMarker android.widget.EditText).() -> Unit,
        additionalInit: (@AnkoViewDslMarker android.widget.EditText).() -> Unit
): android.widget.EditText = ankoView({ android.widget.EditText(it) }, theme = 0) {
    for (init in initializations) init()
    additionalInit()
    setText(text)
}


fun ViewManager.vTextSuggest (
        vararg initializations: (@AnkoViewDslMarker android.widget.AutoCompleteTextView).() -> Unit
) : android.widget.AutoCompleteTextView = ankoView({ android.widget.AutoCompleteTextView(it) }, 0) { for (init in initializations) init() }

fun ViewManager.vTextSuggest (
        vararg initializations: (@AnkoViewDslMarker android.widget.AutoCompleteTextView).() -> Unit,
        additionalInit: (@AnkoViewDslMarker android.widget.AutoCompleteTextView).() -> Unit
) : android.widget.AutoCompleteTextView = ankoView({ android.widget.AutoCompleteTextView(it) }, 0) {
    for (init in initializations) init()
    additionalInit()
}

fun ViewManager.vTextSuggest (
        text: CharSequence,
        vararg initializations: (@AnkoViewDslMarker android.widget.AutoCompleteTextView).() -> Unit
) : android.widget.AutoCompleteTextView = ankoView({ android.widget.AutoCompleteTextView(it) }, 0) {
    for (init in initializations) init()
    setText(text)
}

fun ViewManager.vTextSuggest (
        text: CharSequence,
        vararg initializations: (@AnkoViewDslMarker android.widget.AutoCompleteTextView).() -> Unit,
        additionalInit: (@AnkoViewDslMarker android.widget.AutoCompleteTextView).() -> Unit
) : android.widget.AutoCompleteTextView = ankoView({ android.widget.AutoCompleteTextView(it) }, 0) {
    for (init in initializations) init()
    additionalInit()
    setText(text)
}

fun ViewManager.vTextSuggest (
        textRes: Int,
        vararg initializations: (@AnkoViewDslMarker android.widget.AutoCompleteTextView).() -> Unit
): android.widget.AutoCompleteTextView
        = ankoView({ android.widget.AutoCompleteTextView(it) }, 0) {
    for (init in initializations) init()
    setText(textRes)
}

fun ViewManager.vTextSuggest (
        textRes: Int,
        vararg initializations: (@AnkoViewDslMarker android.widget.AutoCompleteTextView).() -> Unit,
        additionalInit: (@AnkoViewDslMarker android.widget.AutoCompleteTextView).() -> Unit
): android.widget.AutoCompleteTextView = ankoView({ android.widget.AutoCompleteTextView(it) }, 0) {
    for (init in initializations) init()
    additionalInit()
    setText(textRes)
}

fun ViewManager.vBtn (
        vararg initializations: (@AnkoViewDslMarker android.widget.Button).() -> Unit
) : android.widget.Button
        = ankoView({ android.widget.Button(it) }, 0) { for (init in initializations) init() }

fun ViewManager.vBtn (
        vararg initializations: (@AnkoViewDslMarker android.widget.Button).() -> Unit,
        additionalInit: (@AnkoViewDslMarker android.widget.Button).() -> Unit
) : android.widget.Button = ankoView({ android.widget.Button(it) }, 0) {
    for (init in initializations) init()
    additionalInit()
}

fun ViewManager.vBtn (
        text: CharSequence?,
        vararg initializations: (@AnkoViewDslMarker android.widget.Button).() -> Unit
) : android.widget.Button = ankoView({ android.widget.Button(it) }, 0) {
    for (init in initializations) init()
    setText(text)
}

fun ViewManager.vBtn (
        text: CharSequence?,
        vararg initializations: (@AnkoViewDslMarker android.widget.Button).() -> Unit,
        additionalInit: (@AnkoViewDslMarker android.widget.Button).() -> Unit
) : android.widget.Button = ankoView({ android.widget.Button(it) }, 0) {
    for (init in initializations) init()
    additionalInit()
    setText(text)
}


fun ViewManager.vRadio (
        text: String
): android.widget.RadioButton = ankoView({ android.widget.RadioButton(it) }, 0) {
    this.text = text
}

fun ViewManager.vRadio (
        text: String, init: (@AnkoViewDslMarker android.widget.RadioButton).() -> Unit
): android.widget.RadioButton = ankoView({ android.widget.RadioButton(it) }, 0) {
    this.text = text
    init()
}

fun ViewManager.vRadio (
        text: String,
        vararg initializations: (@AnkoViewDslMarker android.widget.RadioButton).() -> Unit
): android.widget.RadioButton = ankoView({ android.widget.RadioButton(it) }, 0) {
    this.text = text
    initializations.forEach { it() }
}

fun ViewManager.vRadio (
        text: String,
        vararg initializations: (@AnkoViewDslMarker android.widget.RadioButton).() -> Unit,
        additionalInit: (@AnkoViewDslMarker android.widget.RadioButton).() -> Unit
): android.widget.RadioButton = ankoView({ android.widget.RadioButton(it) }, 0) {
    this.text = text
    initializations.forEach { it() }
    additionalInit()
}


fun ViewManager.vImage (
        vararg initializations: (@AnkoViewDslMarker android.widget.ImageView).() -> Unit
) : android.widget.ImageView = ankoView({ android.widget.ImageView(it) }, 0) {
    for (init in initializations) init()
}

fun ViewManager.vImage (
        vararg initializations: (@AnkoViewDslMarker android.widget.ImageView).() -> Unit,
        additionalInit: (@AnkoViewDslMarker android.widget.ImageView).() -> Unit
) : android.widget.ImageView = ankoView({ android.widget.ImageView(it) }, 0) {
    for (init in initializations) init()
    additionalInit()
}

fun ViewManager.vImage (
        imageResource: Int,
        vararg initializations: (@AnkoViewDslMarker android.widget.ImageView).() -> Unit
) : android.widget.ImageView = ankoView({ android.widget.ImageView(it) }, 0) {
    for (init in initializations) init()
    setImageResource(imageResource)
}

fun ViewManager.vImage (
        imageResource: Int,
        vararg initializations: (@AnkoViewDslMarker android.widget.ImageView).() -> Unit,
        additionalInit: (@AnkoViewDslMarker android.widget.ImageView).() -> Unit
) : android.widget.ImageView = ankoView({ android.widget.ImageView(it) }, 0) {
    for (init in initializations) init()
    additionalInit()
    setImageResource(imageResource)
}

fun ViewManager.vFab (
        imageResource: Int
): android.support.design.widget.FloatingActionButton = ankoView({ android.support.design.widget.FloatingActionButton(it) }, 0) {
    setImageResource(imageResource)
}

fun ViewManager.vFab (
        imageResource: Int,
        init: (@AnkoViewDslMarker android.support.design.widget.FloatingActionButton).() -> Unit
): android.support.design.widget.FloatingActionButton = ankoView({ android.support.design.widget.FloatingActionButton(it) }, 0) {
    init()
    setImageResource(imageResource)
}

fun ViewManager.vFab (
        imageResource: Int,
        vararg initializations: (@AnkoViewDslMarker android.support.design.widget.FloatingActionButton).() -> Unit
): android.support.design.widget.FloatingActionButton = ankoView({ android.support.design.widget.FloatingActionButton(it) }, 0) {
    initializations.forEach { it() }
    setImageResource(imageResource)
}

fun ViewManager.vFab (
        imageResource: Int,
        vararg initializations: (@AnkoViewDslMarker android.support.design.widget.FloatingActionButton).() -> Unit,
        additionalInit: (@AnkoViewDslMarker android.support.design.widget.FloatingActionButton).() -> Unit
): android.support.design.widget.FloatingActionButton = ankoView({ android.support.design.widget.FloatingActionButton(it) }, 0) {
    initializations.forEach { it() }
    additionalInit()
    setImageResource(imageResource)
}


fun ViewManager.vCheck (
        vararg inits: (@AnkoViewDslMarker android.widget.CheckBox).() -> Unit
) = ankoView({ android.widget.CheckBox(it) }, 0) { inits.forEach { it() } }

fun ViewManager.vCheck (
        vararg inits: (@AnkoViewDslMarker android.widget.CheckBox).() -> Unit,
        init: (@AnkoViewDslMarker android.widget.CheckBox).() -> Unit
) = ankoView({ android.widget.CheckBox(it) }, 0) {
    inits.forEach { it() }
    init()
}

fun ViewManager.vCheck (
        text: CharSequence?,
        vararg inits: (@AnkoViewDslMarker android.widget.CheckBox).() -> Unit
) = ankoView({ android.widget.CheckBox(it) }, 0) {
    inits.forEach { it() }
    setText(text)
}

fun ViewManager.vCheck (
        text: CharSequence?,
        vararg inits: (@AnkoViewDslMarker android.widget.CheckBox).() -> Unit,
        init: (@AnkoViewDslMarker android.widget.CheckBox).() -> Unit
) = ankoView({ android.widget.CheckBox(it) }, 0) {
    inits.forEach { it() }
    init()
    setText(text)
}


inline fun ViewManager.vFrame (init: (@AnkoViewDslMarker KoatlFrame).() -> Unit): android.widget.FrameLayout
        = ankoView({ KoatlFrame(it) }, theme = 0) { init() }

fun ViewManager.vFrame (vararg initializations: (@AnkoViewDslMarker KoatlFrame).() -> Unit): android.widget.FrameLayout
        = ankoView({ KoatlFrame(it) }, theme = 0) { for (init in initializations) init() }

fun ViewManager.vFrame (
        vararg initializations: (@AnkoViewDslMarker KoatlFrame).() -> Unit,
        additionalInit: (@AnkoViewDslMarker KoatlFrame).() -> Unit
): android.widget.FrameLayout = ankoView({ KoatlFrame(it) }, theme = 0) {
    for (init in initializations) init()
    additionalInit()
}


inline fun ViewManager.vVertical (
        init: (@AnkoViewDslMarker KoatlLinear).() -> Unit
): android.widget.LinearLayout = ankoView({ KoatlLinear(it) }, theme = 0) {
    init()
    orientation = android.widget.LinearLayout.VERTICAL
}

fun ViewManager.vVertical (
        vararg initializations: (@AnkoViewDslMarker KoatlLinear).() -> Unit
): android.widget.LinearLayout = ankoView({ KoatlLinear(it) }, theme = 0) {
    for (init in initializations) init()
    orientation = android.widget.LinearLayout.VERTICAL
}

fun ViewManager.vVertical (
        vararg initializations: (@AnkoViewDslMarker KoatlLinear).() -> Unit,
        additionalInit: (@AnkoViewDslMarker KoatlLinear).() -> Unit
): android.widget.LinearLayout = ankoView({ KoatlLinear(it) }, theme = 0) {
    for (init in initializations) init()
    additionalInit()
    orientation = android.widget.LinearLayout.VERTICAL
}

inline fun ViewManager.vLinear (
        init: (@AnkoViewDslMarker KoatlLinear).() -> Unit
): android.widget.LinearLayout = ankoView({ KoatlLinear(it) }, theme = 0) {
    init()
    orientation = android.widget.LinearLayout.HORIZONTAL
}

fun ViewManager.vLinear (
        vararg initializations: (@AnkoViewDslMarker KoatlLinear).() -> Unit
): android.widget.LinearLayout = ankoView({ KoatlLinear(it) }, theme = 0) {
    for (init in initializations) init()
    orientation = android.widget.LinearLayout.HORIZONTAL
}

fun ViewManager.vLinear (
        vararg initializations: (@AnkoViewDslMarker KoatlLinear).() -> Unit,
        additionalInit: (@AnkoViewDslMarker KoatlLinear).() -> Unit
): android.widget.LinearLayout = ankoView({ KoatlLinear(it) }, theme = 0) {
    for (init in initializations) init()
    additionalInit()
    orientation = android.widget.LinearLayout.HORIZONTAL
}


fun ViewManager.vRelative (init: (@AnkoViewDslMarker KoatlRelative).() -> Unit): android.widget.RelativeLayout
        = ankoView({ KoatlRelative(it) }, 0) { init() }

fun ViewManager.vRelative (
        vararg initializations: (@AnkoViewDslMarker KoatlRelative).() -> Unit,
        additionalInit: (@AnkoViewDslMarker KoatlRelative).() -> Unit
): android.widget.RelativeLayout = ankoView({ KoatlRelative(it) }, 0) {
    for (init in initializations) init()
    additionalInit()
}


fun ViewManager.vTable (init: (@AnkoViewDslMarker KoatlTable).() -> Unit): android.widget.TableLayout
        = ankoView({ KoatlTable(it) }, 0) { init() }

fun ViewManager.vTable (
        vararg inits: (@AnkoViewDslMarker KoatlTable).() -> Unit,
        init: (@AnkoViewDslMarker KoatlTable).() -> Unit
): android.widget.TableLayout = ankoView({ KoatlTable(it) }, 0) {
    inits.forEach { it() }
    init()
}


fun ViewManager.vDrawer (init: (@AnkoViewDslMarker KoatlDrawer).() -> Unit): android.support.v4.widget.DrawerLayout
        = ankoView({ KoatlDrawer(it) }, 0) { init() }


fun ViewManager.vRadioGroup (
        vararg initializations: (@AnkoViewDslMarker android.widget.RadioGroup).() -> Unit
): android.widget.RadioGroup = ankoView({ android.widget.RadioGroup(it) }, 0) {
    for (init in initializations) init()
}

fun ViewManager.vRadioGroup (
        vararg initializations: (@AnkoViewDslMarker android.widget.RadioGroup).() -> Unit,
        additionalInit: (@AnkoViewDslMarker android.widget.RadioGroup).() -> Unit
): android.widget.RadioGroup = ankoView({ android.widget.RadioGroup(it) }, 0) {
    for (init in initializations) init()
    additionalInit()
}

fun ViewManager.vRadioGroup(
        orientation: Int,
        init: (@AnkoViewDslMarker _RadioGroup).() -> Unit
): android.widget.RadioGroup = ankoView({ _RadioGroup(it) }, 0) {
    init()
    this.orientation = orientation
}

fun ViewManager.vRadioGroup(
        orientation: Int,
        vararg initializations: (@AnkoViewDslMarker _RadioGroup).() -> Unit
): android.widget.RadioGroup = ankoView({ _RadioGroup(it) }, 0) {
    initializations.forEach { it() }
    this.orientation = orientation
}

fun ViewManager.vRadioGroup(
        orientation: Int,
        vararg initializations: (@AnkoViewDslMarker _RadioGroup).() -> Unit,
        additionalInit: (@AnkoViewDslMarker _RadioGroup).() -> Unit
): android.widget.RadioGroup = ankoView({ _RadioGroup(it) }, 0) {
    initializations.forEach { it() }
    additionalInit()
    this.orientation = orientation
}


fun ViewManager.vNav (
        vararg initializations: (@AnkoViewDslMarker android.support.design.widget.NavigationView).() -> Unit,
        additionalInit: (@AnkoViewDslMarker android.support.design.widget.NavigationView).() -> Unit
) : android.support.design.widget.NavigationView = ankoView({ android.support.design.widget.NavigationView(it) }, 0) {
    for (init in initializations) init()
    additionalInit()
}

fun ViewManager.vList(vararg initializations: (@AnkoViewDslMarker android.support.v7.widget.RecyclerView).() -> Unit): android.support.v7.widget.RecyclerView
        = ankoView({ android.support.v7.widget.RecyclerView(it) }, 0) {
    for (init in initializations) init()
}

fun ViewManager.vList (
        vararg initializations: (@AnkoViewDslMarker RecyclerView).() -> Unit,
        additionalInit: (@AnkoViewDslMarker RecyclerView).() -> Unit
) = ankoView({ RecyclerView(it) }, theme = 0) {
    for(init in initializations) init()
    additionalInit()
}

inline fun ViewManager.vGridList (
        init: (@AnkoViewDslMarker GridList).() -> Unit,
        spanCount: Int = 2
) : GridList = ankoView( {GridList(it)}, 0 ) {
    layoutManager = android.support.v7.widget.GridLayoutManager(context, spanCount)
    init()
}

fun ViewManager.vGridList (
        vararg initializations: (@AnkoViewDslMarker GridList).() -> Unit,
        spanCount: Int = 2
) : GridList = ankoView({ GridList(it) }, 0) {
    layoutManager = android.support.v7.widget.GridLayoutManager(context, spanCount)
    initializations.forEach { it() }
}

fun ViewManager.vGridList (
        vararg initializations: (@AnkoViewDslMarker GridList).() -> Unit,
        additionalInit: (@AnkoViewDslMarker GridList).() -> Unit,
        spanCount: Int = 2
) : GridList = ankoView({ GridList(it) }, 0) {
    layoutManager = android.support.v7.widget.GridLayoutManager(context, spanCount)
    initializations.forEach { it() }
    additionalInit()
}

fun ViewManager.vNavSelector (
        vararg inits: (@AnkoViewDslMarker BottomNavigationViewEx).() -> Unit
) : BottomNavigationViewEx = ankoView({ BottomNavigationViewEx(it) }, 0) {
    inits.forEach { it() }
}

fun ViewManager.vNavSelector (
        menuId: Int,
        init: (@AnkoViewDslMarker BottomNavigationViewEx).() -> Unit
) : BottomNavigationViewEx = ankoView({ BottomNavigationViewEx(it) }, 0) {
    inflateMenu(menuId)
    init()
}

fun ViewManager.vNavSelector (
        menuId: Int,
        vararg inits: (@AnkoViewDslMarker BottomNavigationViewEx).() -> Unit
) : BottomNavigationViewEx = ankoView({ BottomNavigationViewEx(it) }, 0) {
    inflateMenu(menuId)
    inits.forEach { it() }
}

fun ViewManager.vNavSelector (
        menuId: Int,
        vararg inits: (@AnkoViewDslMarker BottomNavigationViewEx).() -> Unit,
        init: (@AnkoViewDslMarker BottomNavigationViewEx).() -> Unit
) : BottomNavigationViewEx = ankoView({ BottomNavigationViewEx(it) }, 0) {
    inflateMenu(menuId)
    inits.forEach { it() }
    init()
}

fun <E> ViewManager.vDropdown (
        items: List<E>
) = vDropdown(items) {}

fun <E> ViewManager.vDropdown (
        items: List<E>,
        init: (@AnkoViewDslMarker android.widget.Spinner).() -> Unit
) : android.widget.Spinner = ankoView({ android.widget.Spinner(it) }, 0) {
    init()
    adapter = context.spinnerDropdownAdapter(items)
}