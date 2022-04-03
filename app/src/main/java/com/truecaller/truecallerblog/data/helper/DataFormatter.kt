package com.truecaller.truecallerblog.data.helper

/**
 * Data formatter
 *
 * @param T
 * @constructor Create Data formatter
 */
interface DataFormatter<T> {
    /**
     * Get formatted data
     *
     * @param value
     * @return
     */
    fun getFormattedData(value: String?): T
}