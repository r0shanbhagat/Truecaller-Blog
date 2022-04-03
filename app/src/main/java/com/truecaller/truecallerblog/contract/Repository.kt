package com.truecaller.truecallerblog.contract


/**
 * @Details :IRepository
 * @Author Roshan Bhagat
 *
 * @param T
 * @constructor Create Repository
 */
interface Repository<T> {

    val dataSource: BlogDataSource<T>

    /**
     * Get blog content
     *
     * @return
     */
    suspend fun getBlogContent(): T

}