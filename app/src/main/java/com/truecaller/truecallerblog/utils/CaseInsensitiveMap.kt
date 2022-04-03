package com.truecaller.truecallerblog.utils

import java.util.*


/**
 * Case insensitive map
 *
 * @param K
 * @param V
 * @constructor Create Case insensitive map
 */
class CaseInsensitiveMap<K, V> : LinkedHashMap<String, Int?>() {
    override fun put(key: String, value: Int?): Int? {
        return super.put(key.lowercase(Locale.getDefault()), value)
    }

    override operator fun get(key: String): Int? {
        return super.get(key.lowercase(Locale.getDefault()))
    }
}