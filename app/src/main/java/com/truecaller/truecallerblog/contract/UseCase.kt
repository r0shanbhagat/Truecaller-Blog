package com.truecaller.truecallerblog.contract

import kotlinx.coroutines.flow.Flow

/**
 * I use case
 *
 * @param T
 * @constructor Create empty I use case
 */
interface UseCase<T> {

    val repository: Repository<T>

    /**
     * Get blog content
     *
     * @return
     */
    suspend fun getBlogContent(): Flow<T>


}