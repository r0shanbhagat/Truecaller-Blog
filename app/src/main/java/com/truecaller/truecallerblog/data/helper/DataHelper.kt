package com.truecaller.truecallerblog.data.helper

/**
 * @Details OperationHelper: Interface that contains all the abstract fun(C)
 * for o/p to be performed after blog parsed
 * @Author Roshan Bhagat  * @param T
 * @constructor Create Operation helper
 */
interface DataHelper<T> {

    /**
     * Get tenth character
     *
     * @param value
     * @return
     */
    fun getTenthCharacter(value: T?): T

    /**
     * Get every tenth character
     *
     * @param value
     * @return
     */
    fun getEveryTenthCharacter(value: T?): T

    /**
     * Get distinct word count
     *
     * @param value
     * @return
     */
    fun getDistinctWordCount(value: T?): T
}