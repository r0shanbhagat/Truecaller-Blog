package com.truecaller.truecallerblog.di

import com.truecaller.truecallerblog.contract.BlogDataSource
import com.truecaller.truecallerblog.contract.Repository
import com.truecaller.truecallerblog.data.BlogRemoteDataSource
import com.truecaller.truecallerblog.data.BlogRepository
import com.truecaller.truecallerblog.data.RemoteDataSource
import com.truecaller.truecallerblog.data.api.BlogService
import com.truecaller.truecallerblog.data.helper.DataHelper
import com.truecaller.truecallerblog.utils.DataState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher

/**
 * @Details RepositoryModule
 * @Author Roshan Bhagat
 * @constructor Create Repository module
 */
@InstallIn(ViewModelComponent::class)
@Module
class RepositoryModule {

    /**
     * Provide movie repository
     *
     * @param blogDataSource
     * @param ioDispatcher
     * @return
     */
    @Provides
    fun provideMovieRepository(
        @RemoteDataSource blogDataSource: BlogDataSource<DataState>,
        dataHelper: DataHelper<String>,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): Repository<DataState> = BlogRepository(blogDataSource, dataHelper, ioDispatcher)

    /**
     * Provide blog remote data source
     *
     * @param apiService
     * @param ioDispatcher
     * @return
     */
    @RemoteDataSource
    @Provides
    fun provideBlogRemoteDataSource(
        apiService: BlogService,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): BlogDataSource<DataState> =
        BlogRemoteDataSource(apiService, ioDispatcher)

}