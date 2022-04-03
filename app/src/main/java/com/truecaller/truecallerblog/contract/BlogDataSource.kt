package com.truecaller.truecallerblog.contract

import com.truecaller.truecallerblog.data.api.BlogService


/**
 * @Details :IBlogDataSource
 * @Author Roshan Bhagat
 * @param T
 * @constructor Create Blog data source
 */
interface BlogDataSource<T> {
    val apiService: BlogService

    /**
     * Get blog content
     *
     * @return
     */
    suspend fun getBlogContent(): T

}