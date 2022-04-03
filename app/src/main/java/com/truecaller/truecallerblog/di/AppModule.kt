package com.truecaller.truecallerblog.di

import com.truecaller.truecallerblog.contract.BlogDataSource
import com.truecaller.truecallerblog.contract.Repository
import com.truecaller.truecallerblog.contract.UseCase
import com.truecaller.truecallerblog.data.BlogRemoteDataSource
import com.truecaller.truecallerblog.data.RemoteDataSource
import com.truecaller.truecallerblog.data.api.BlogService
import com.truecaller.truecallerblog.data.helper.*
import com.truecaller.truecallerblog.domain.BlogContentUseCase
import com.truecaller.truecallerblog.utils.DataState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Defines all the classes that need to be provided in the scope of the app.
 *@see "https://developer.android.com/training/dependency-injection/hilt-android"
 *
 * Define here all objects that are shared throughout the app, like SharedPreferences, navigators or
 * others. If some of those objects are singletons, they should be annotated with `@Singleton`.
 * @Author Roshan Bhagat
 **/
@InstallIn(ViewModelComponent::class)
@Module
class AppModule {

    /**
     * Provide blog content use case.
     *
     * @param repository Repository
     * @param ioDispatcher Io dispatcher
     * @return [UseCase]
     */
    @Provides
    fun provideBlogContentUseCase(
        repository: Repository<DataState>,
        helperFactory: DataHelper<String>,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): UseCase<DataState> = BlogContentUseCase(repository, helperFactory, ioDispatcher)

    /**
     * Provide operation helper factory
     *
     * @return
     */
    @Provides
    fun provideOperationHelperFactory(
        @TenthCharacter tenthChar: TenthCharacterHelper,
        @EveryTenthCharacter everyTenthChar: EveryTenthCharacterHelper,
        @DistinctWordCount distinctWordCount: DistinctWordCountHelper
    ): DataHelper<String> = DataHelperFactory(
        tenthChar, everyTenthChar, distinctWordCount
    )

    /**
     * Provide blog remote data source factory
     *
     * @param apiService
     * @param ioDispatcher
     * @return
     */
    @RemoteDataSource
    @Provides
    fun provideBlogRemoteDataSourceFactory(
        apiService: BlogService,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): BlogDataSource<DataState> =
        BlogRemoteDataSource(apiService, ioDispatcher)

}