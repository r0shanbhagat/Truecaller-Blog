package com.truecaller.truecallerblog.data

import com.truecaller.truecallerblog.contract.BlogDataSource
import com.truecaller.truecallerblog.data.api.BlogService
import com.truecaller.truecallerblog.di.IoDispatcher
import com.truecaller.truecallerblog.utils.DataState
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Qualifier


/**
 * @Details :BlogParseRemoteDataSource
 * @Author Roshan Bhagat
 *
 * @property apiService
 * @property ioDispatcher
 * @constructor Create Blog parse remote data source
 */
@ViewModelScoped
class BlogRemoteDataSource @Inject constructor(
    override val apiService: BlogService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : BlogDataSource<DataState> {

    /**
     * TODO Convert this to Flow  if possible
     *
     * @return [DataState]
     */
    override suspend fun getBlogContent(): DataState = try {
        withContext(ioDispatcher) {
            val content = apiService.getBlogContent()
            content.body()
        }.let {
            DataState.Success(it)
        }
    } catch (e: Exception) {
        DataState.Error(e)
    }
}

@Retention(AnnotationRetention.SOURCE)
@Qualifier
annotation class RemoteDataSource