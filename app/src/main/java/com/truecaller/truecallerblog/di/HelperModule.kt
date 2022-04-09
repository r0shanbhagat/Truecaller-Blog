package com.truecaller.truecallerblog.di

import com.truecaller.truecallerblog.data.helper.DistinctWordCountHelper
import com.truecaller.truecallerblog.data.helper.EveryTenthCharacterHelper
import com.truecaller.truecallerblog.data.helper.TenthCharacterHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Qualifier

/**
 * @Details :OperationHelperModule
 * @Author Roshan Bhagat
 */
@InstallIn(ViewModelComponent::class)
@Module
class OperationHelperModule {

    @TenthCharacter
    @Provides
    fun providesTenthCharacterHelper(): TenthCharacterHelper = TenthCharacterHelper()

    @EveryTenthCharacter
    @Provides
    fun providesEveryTenthCharacterHelper(): EveryTenthCharacterHelper = EveryTenthCharacterHelper()

    @DistinctWordCount
    @Provides
    fun providesDistinctWordCountHelper(): DistinctWordCountHelper = DistinctWordCountHelper()

}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class TenthCharacter

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class EveryTenthCharacter

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DistinctWordCount