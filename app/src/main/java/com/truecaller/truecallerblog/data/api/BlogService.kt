package com.truecaller.truecallerblog.data.api

import retrofit2.Response
import retrofit2.http.GET


/**
 * @Details ApiService
 * @Author Roshan Bhagat
 * @constructor Create Api service
 */
interface BlogService {
    /**
     * Get blog content
     *
     * @return
     */
    @GET("2018/01/22/life-as-an-android-engineer/")
    suspend fun getBlogContent(): Response<String>
}