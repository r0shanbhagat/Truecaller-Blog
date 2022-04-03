package com.truecaller.truecallerblog.data

import com.truecaller.truecallerblog.contract.BlogDataSource
import com.truecaller.truecallerblog.contract.Repository
import com.truecaller.truecallerblog.di.IoDispatcher
import com.truecaller.truecallerblog.utils.DataState
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject


/**
 * @Details BlogRepository
 * @Author Roshan Bhagat
 * @see "https://developer.android.com/jetpack/guide/data-layer#architecture"
 * @property dataSource
 * @property ioDispatcher
 * @constructor Create [BlogRepository]
 */
@ViewModelScoped
class BlogRepository @Inject constructor(
    @RemoteDataSource override val dataSource: BlogDataSource<DataState>,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : Repository<DataState> {

    /**
     * Get blog content.
     * TODO Convert this to Flow  ("https://developer.android.com/kotlin/coroutines/coroutines-best-practices#coroutines-data-layer")
     *  Link : https://developer.android.com/jetpack/guide/data-layer#multiple-levels
    https://github.com/inspire-coding/OMDB_MVVM_KotlinFlow_DaggerHilt_Retrofit_MotionLayout/tree/master/app/src/main/java/com/inspirecoding/omdb_mvvm_kotlinflow_daggerhilt_retrofit/repository     * @return [DataState]
     */
    override suspend fun getBlogContent(): DataState =
        dataSource.getBlogContent()
}