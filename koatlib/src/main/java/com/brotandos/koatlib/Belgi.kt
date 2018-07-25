package com.brotandos.koatlib

object BelgiUtil {
    const val START_OF_BELGI = "<belgi>"
    const val BELGI_SEPARATOR = ":"
    const val END_OF_BELGI = "</belgi>"
    private const val BELGI_TYPE_ORDER = 0
    private const val BELGI_ID_ORDER = 1

    val String.belgi: Belgi get() {
        val paramsString = this.removeSurrounding(START_OF_BELGI, END_OF_BELGI)
        val params = paramsString.split(BELGI_SEPARATOR)
        val belgiType = BelgiType.values().find { it.name == params[BELGI_TYPE_ORDER] } ?: BelgiType.DEFAULT
        val id = params[BELGI_ID_ORDER].toInt()
        return Belgi(belgiType, id)
    }
}

enum class BelgiType {
    VIEW,
    LABEL,

    DEFAULT
}

class Belgi(val type: BelgiType, val id: Int) {

    val qatnasList = mutableListOf<Qatnas>()

    fun addQatnas(qatnas: Qatnas) {
        if (qatnas.isExist) qatnasList += qatnas
    }

    override fun toString() =
            BelgiUtil.START_OF_BELGI +
            type.name +
            BelgiUtil.BELGI_SEPARATOR +
            id +
            BelgiUtil.END_OF_BELGI
}

data class Qatnas(val toBelgi: Belgi? = null, val margin: Int = 0) {
    val isExist: Boolean get() = toBelgi != null || margin != 0
}