package com.brotandos.koatlib

import android.text.*
import android.widget.EditText

/**
 * @author: Brotandos
 * @date: 22.02.2018.
 */
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


/**
 * Credits to Scott A Dixon (thanks!)
 * https://gist.github.com/scottdarch/bdd9a7abebd1bf6dc9b8
 * */
val colorFilters: EditText.() -> Unit = {
    filters = arrayOf(InputFilter { source, start, end, _, _, _ ->
        val mUpperCase = false
        var cleanSequence: CharArray? = null
        val sequenceLen = end - start
        var nextOpenSlot = 0
        var i = start

        // defensive posture to prevent taking action on bad input.
        if (sequenceLen <= 0) return@InputFilter null

        // Force valid hex characters which are all upper-case.
        while (i < end) {
            val testChar = source[i]
            val testCharUpperCase = Character.toUpperCase(testChar)
            if ( testCharUpperCase != 'A' &&
                    testCharUpperCase != 'B' &&
                    testCharUpperCase != 'C' &&
                    testCharUpperCase != 'D' &&
                    testCharUpperCase != 'E' &&
                    testCharUpperCase != 'F' &&
                    !Character.isDigit(testChar)) {
                // not a valid hex character. Redact.
                if (null == cleanSequence) {
                    cleanSequence = CharArray(sequenceLen)
                    TextUtils.getChars(source, start, i, cleanSequence, 0)
                }
            } else if (mUpperCase && testChar != testCharUpperCase || !mUpperCase && testChar == testCharUpperCase) {
                // valid but not the right case. Make this upper-case.
                if (null == cleanSequence) {
                    cleanSequence = CharArray(sequenceLen)
                    TextUtils.getChars(source, start, i, cleanSequence, 0)
                }
                cleanSequence[nextOpenSlot++] = if (mUpperCase) testCharUpperCase else Character.toLowerCase(testChar)
            } else if (null != cleanSequence) {
            // a valid character but we already found an invalid character
            // so we're forming a replacement.
                cleanSequence[nextOpenSlot++] = testCharUpperCase
            } else {
            // keep the nextOpenSlot index updated in-case we find an invalid
            // character later on and end up doing a mass copy of all the valid
            // characters to this point from the source.
                ++nextOpenSlot
            }
            ++i
        }

        if (cleanSequence != null) {
            // We are filtering the source. Create a string from our clean
            // sequence but remember that this array may contain less values
            // if we found invalid characters.
            val cleanString: String = if (nextOpenSlot >= sequenceLen) String(cleanSequence)
            else String(cleanSequence, 0, nextOpenSlot)

            if (source !is Spanned) return@InputFilter cleanString

            val cleanSpannable = SpannableString(cleanString)
            TextUtils.copySpansFrom(source, start, nextOpenSlot, null, cleanSpannable, 0)
            cleanSpannable
        } else null
    }, InputFilter.LengthFilter(8))
}