package com.truecaller.truecallerblog.di

import com.truecaller.truecallerblog.contract.BlogDataSource
import com.truecaller.truecallerblog.contract.Repository
import com.truecaller.truecallerblog.data.BlogRepository
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
        blogDataSource: BlogDataSource<DataState>,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): Repository<DataState> = BlogRepository(blogDataSource, ioDispatcher)
}